package com.stereoscopics.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stereoscopics.app.models.BlogPost;
import com.stereoscopics.app.repo.BlogPostRepo;

@Controller
@RequestMapping("/admin")
public class AdminController {

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

	

	@RequestMapping(value = "/turkey", method = RequestMethod.GET)
	@ResponseBody
	public List<BlogPost> findAll() {
		return blogPostRepo.findAll();
	}

}