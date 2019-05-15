package com.hcl.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.shoppingcart.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
