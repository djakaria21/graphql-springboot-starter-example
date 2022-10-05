package com.review.core.service;

import com.review.core.dto.*;
import com.review.core.repository.UserRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@GraphQLApi
@Service
public class GraphQLUserService {

    @Autowired
    private UserRepository userRepository;

    @GraphQLQuery(name = "getUserWithID")
   public Optional<User> getUserWithId(@GraphQLArgument(name= "id") Long id) {
        return userRepository.findById(id);
   }

    @GraphQLQuery(name = "getAllUsers", description = "Get all users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GraphQLMutation(name = "addUser")
    public User addUser(@GraphQLArgument(name = "newUser") User user) {
        return userRepository.save(user);
    }

    @GraphQLMutation(name = "deleteUser")
    public void deleteUser(@GraphQLArgument(name = "user") User user) {
        userRepository.delete(user);
    }

}
