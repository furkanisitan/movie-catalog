package com.furkanisitan.moviecatalog.dataaccess;

import com.furkanisitan.moviecatalog.business.abstracts.MovieService;
import com.furkanisitan.moviecatalog.dataaccess.abstracts.ActorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoTest {

    @Autowired
    private ActorRepository actorRepository;


    @Test
    public void test() {

        var encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("1234"));

    }
}
