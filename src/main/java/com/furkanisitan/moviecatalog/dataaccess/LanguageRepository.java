package com.furkanisitan.moviecatalog.dataaccess;

import com.furkanisitan.moviecatalog.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}