package com.stereoscopics.app.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.stereoscopics.app.models.Article;

public interface ArticleRepo extends MongoRepository<Article, ObjectId> {
}