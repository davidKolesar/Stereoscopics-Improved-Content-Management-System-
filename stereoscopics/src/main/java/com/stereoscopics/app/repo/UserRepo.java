package com.stereoscopics.app.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.stereoscopics.app.models.User;

public interface UserRepo extends MongoRepository<User, ObjectId> {
}