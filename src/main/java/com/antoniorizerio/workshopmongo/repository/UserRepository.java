package com.antoniorizerio.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.antoniorizerio.workshopmongo.repository.entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

}
