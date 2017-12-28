package com.stereoscopics.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stereoscopics.app.repo.BlogPostRepo;

/*
* This is the controller that maps requests to actual web pages. 
*/

@Controller
public class WebController implements ErrorController{

	private static final String PATH = "/error";
    private BlogPostRepo blogPostRepo;
    
    @Autowired
    public WebController(BlogPostRepo blogPostRepo) {
        this.blogPostRepo = blogPostRepo;
    }
    
  	@RequestMapping("/index")
  	public String displayBlogPosts(Model model){
  		model.addAttribute("blogPosts", blogPostRepo.findAll());
  		return "index";
  	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}

}