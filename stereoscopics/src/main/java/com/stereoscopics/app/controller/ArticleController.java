package com.stereoscopics.app.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stereoscopics.app.models.Article;
import com.stereoscopics.app.models.TitleTransferObject;
import com.stereoscopics.app.repo.ArticleRepo;

/*
* This is the controller that maps article requests to the database. 
*/

@Controller
@RequestMapping("/articles")
public class ArticleController {

	private ArticleRepo articleRepo;
	private Article queryByTitleResults; // I've tried using a list (even with
											// final), but it either throws and
											// NPE from not being instantiated
											// in the constructor or is emptied
											// by garbage collection

	@Autowired
	public ArticleController(ArticleRepo articleRepo) {
		this.articleRepo = articleRepo;
	}

	@RequestMapping(value = "/findAllArticles", method = RequestMethod.GET)
	@ResponseBody
	public List<Article> findAll() {
		return articleRepo.findAll();
	}

	@RequestMapping(value = "/findArticleByTitle", method = RequestMethod.GET)
	@ResponseBody
	public Article findArticleByTitle() {
		return queryByTitleResults;
	}

	@GetMapping("/addArticle")
	public String getAddArticle(Model model) {
		model.addAttribute("article", new Article());
		return "submitAnArticle";
	}

	@PostMapping("/addArticle")
	public String submitAddArticle(@ModelAttribute Article article) {
		// sanitize this data
		articleRepo.save(article);
		return "submitAnArticle";
	}

	@GetMapping("/readArticle")
	public String submitArticleTitleToRead(Model model) {
		model.addAttribute("article", new Article());
		return "readAnArticle";
	}

	@PostMapping("/readArticle")
	public String readAnArticle(@ModelAttribute Article article) {
		List<Article> allArticles = articleRepo.findAll();
		for (Article a : allArticles) {
			if (a.getTitle().equals(article.getTitle())) {
				queryByTitleResults = a;
			}
		}
		return "readAnArticle";
	}

	@GetMapping("/deleteArticle")
	public String submitArticleToDelete(Model model) {
		model.addAttribute("title", new TitleTransferObject());
		return "deleteAnArticle";
	}

	@PostMapping("/deleteArticle") // Make sure you add a modal to the front end
									// confirming delete
	public String deleteArticle(TitleTransferObject title) {
		List<Article> articleList = articleRepo.findAll();
		for (Article a : articleList) {
			if (a.getTitle().equals(title.getTitle())) {
				ObjectId articleToDeleteId = new ObjectId(a.getId());
				articleRepo.delete(articleToDeleteId);
			}
		}
		return "articleDeleted";
	}

}