package com.furkanisitan.moviecatalog.business.concretes.auth;

import com.furkanisitan.moviecatalog.business.abstracts.auth.RoleService;
import com.furkanisitan.moviecatalog.dataaccess.auth.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class RoleManager implements RoleService {

    private final RoleRepository repository;

    @Autowired
    public RoleManager(RoleRepository repository) {
        this.repository = repository;
    }
}
