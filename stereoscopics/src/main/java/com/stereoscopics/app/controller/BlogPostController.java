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

import com.stereoscopics.app.models.BlogPost;
import com.stereoscopics.app.models.TitleTransferObject;
import com.stereoscopics.app.repo.BlogPostRepo;

@Controller
@RequestMapping("/blogposts")
public class BlogPostController {

	private BlogPostRepo blogPostRepo;
	private BlogPost queryByTitleResults; /*
											 * I've tried using a list (even
											 * with final), but it either throws
											 * and NPE from not being
											 * instantiated in the constructor
											 * or is emptied by garbage
											 * collection. We could save it
											 * locally as a text document
											 */

	@Autowired
	public BlogPostController(BlogPostRepo blogPostRepo) {
		this.blogPostRepo = blogPostRepo;
	}


	@RequestMapping(value = "/findAllBlogPosts", method = RequestMethod.GET)
	@ResponseBody
	public List<BlogPost> findAll() {
		return blogPostRepo.findAll();
	}
	
	
	@RequestMapping(value = "/findBlogPostByTitle", method = RequestMethod.GET)
	@ResponseBody
	public BlogPost findBlogPostByTitle() {
		return queryByTitleResults;
	}
	
  	@RequestMapping("/displayBlogPosts")
  	public String displayBlogPosts(Model model){
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