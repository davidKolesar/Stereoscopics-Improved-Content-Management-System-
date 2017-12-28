package com.stereoscopics.app.repo;

import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stereoscopics.app.models.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogPostRepo extends MongoRepository<BlogPost, ObjectId> {
}
