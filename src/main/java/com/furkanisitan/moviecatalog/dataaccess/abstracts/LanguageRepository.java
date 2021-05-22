package com.furkanisitan.moviecatalog.dataaccess.abstracts;

import com.furkanisitan.moviecatalog.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
