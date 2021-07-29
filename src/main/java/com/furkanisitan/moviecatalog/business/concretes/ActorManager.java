package com.furkanisitan.moviecatalog.business.concretes;

import com.furkanisitan.moviecatalog.business.abstracts.ActorService;
import com.furkanisitan.moviecatalog.dataaccess.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ActorManager implements ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorManager(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
}
