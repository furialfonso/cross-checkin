package com.crossing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crossing.entities.User;

public interface IUserRepository extends JpaRepository<User, Long>{

}
