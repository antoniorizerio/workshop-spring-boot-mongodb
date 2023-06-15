package com.antoniorizerio.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.antoniorizerio.workshopmongo.entities.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Long> {

}
