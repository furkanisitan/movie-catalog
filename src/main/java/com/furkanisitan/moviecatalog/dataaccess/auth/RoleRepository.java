package com.furkanisitan.moviecatalog.dataaccess.auth;

import com.furkanisitan.moviecatalog.entities.concretes.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}