package com.example.demo.repositories;

import com.example.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    //Page<User> getUsersByEmail(String email, Pageable pageable);

    //HQL query
    @Query(value = "select u from User u where u.email = ?1")
    Page<User> getUsersByEmail(String email, Pageable pageable);


    //Native sql query
//  @Query(value = "SELECT * FROM USER WHERE EMAIL = ?1", nativeQuery = true)
//  Page<User> getUsersByEmail(String email, Pageable pageable);
}
