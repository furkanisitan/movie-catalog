package com.furkanisitan.moviecatalog.dataaccess.auth;

import com.furkanisitan.moviecatalog.entities.concretes.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}