package com.furkanisitan.moviecatalog.business.concretes.auth;

import com.furkanisitan.moviecatalog.business.abstracts.auth.UserService;
import com.furkanisitan.moviecatalog.dataaccess.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class UserManager implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserManager(UserRepository repository) {
        this.repository = repository;
    }
}
