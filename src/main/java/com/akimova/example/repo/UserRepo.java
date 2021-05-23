package com.akimova.example.repo;

import com.akimova.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepo extends JpaRepository<User, Long> {
    User findUserById(Long id);
    User findUserByUsername(String name);
}
