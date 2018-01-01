package com.stereoscopics.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.Mongo;
import com.stereoscopics.app.models.BlogPost;
import com.stereoscopics.app.models.TitleTransferObject;
import com.stereoscopics.app.repo.BlogPostRepo;

@Controller
@RequestMapping("/blogposts")
public class BlogPostController {

	private BlogPostRepo blogPostRepo;
	

	@Autowired
	public BlogPostController(BlogPostRepo blogPostRepo) {
		this.blogPostRepo = blogPostRepo;
	}

	@RequestMapping(value = "/findAllBlogPosts", method = RequestMethod.GET)
	@ResponseBody
	public List<BlogPost> findAll() {
		return blogPostRepo.findAll();
	}
	
	

	@GetMapping("/findBlogPostByTitle")
	public String findBlogPostByTitle(Model model) {
		model.addAttribute("blogPost", new BlogPost());
		return "findBlogPostByTitle";
	}

	@PostMapping("/findBlogPostByTitle") 
	public String displayBlogPostToEdit(@ModelAttribute BlogPost blogPost, TitleTransferObject title) {
		
		List<BlogPost> blogPostList = blogPostRepo.findAll();
		for (BlogPost b : blogPostList) {
			if (b.getTitle().equals(title.getTitle())) {

				return "editBlogPost";
						
			}
		} 
		return "cannotFindBlogPost";
	}
	
	
	
/*
	@GetMapping("/findBlogPostByTitle")
	public String findBlogPostByTitle(Model model) {
		model.addAttribute("title", new TitleTransferObject());
		return "findBlogPostByTitle";
	}

	@PostMapping("/findBlogPostByTitle") 
	public String displayBlogPostToEdit(TitleTransferObject title) {
		
		List<BlogPost> blogPostList = blogPostRepo.findAll();
		for (BlogPost b : blogPostList) {
			if (b.getTitle().equals(title.getTitle())) {
				BlogPost updatedBlogPost = new BlogPost();
				updatedBlogPost.setId(b.getId());
				updatedBlogPost.setAuthor(b.getAuthor());
				updatedBlogPost.setContent(b.getContent());
				updatedBlogPost.setDate(b.getDate());
				updatedBlogPost.setTitle(b.getTitle());

				return "submitBlogPost";
			}
		} 
		return "cannotFindBlogPost";
	}
	*/

	
	@RequestMapping("/displayBlogPosts")
	public String displayBlogPosts(Model model) {
		model.addAttribute("blogPosts", blogPostRepo.findAll());
		return "displayBlogPosts";
	}

	@GetMapping("/addBlogPost")
	public String createBlogPost(Model model) {
		model.addAttribute("blogPost", new BlogPost());
		return "submitBlogPost";
	}
	
	@PostMapping("/addBlogPost")
	public String submitBlogPost(@ModelAttribute BlogPost blogPost) {
		blogPostRepo.save(blogPost);
		return "submitBlogPost";
	}

	@GetMapping("/deleteBlogPost")
	public String submitBlogPostToDelete(Model model) {
		model.addAttribute("title", new TitleTransferObject());
		return "deleteBlogPost";
	}

	@PostMapping("/deleteBlogPost") // Make sure you add a modal to the front
									// end confirming delete
	public String deleteBlogPost(TitleTransferObject title) {
		List<BlogPost> blogPostList = blogPostRepo.findAll();
		for (BlogPost b : blogPostList) {
			if (b.getTitle().equals(title.getTitle())) {
				ObjectId blogPostToDeleteId = new ObjectId(b.getId());
				blogPostRepo.delete(blogPostToDeleteId);
			}
		}
		return "blogPostDeleted";
	}

}