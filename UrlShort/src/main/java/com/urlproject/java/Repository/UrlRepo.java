package com.urlproject.java.Repository;

import com.urlproject.java.Model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepo extends JpaRepository<Url,Long> {

   public Url findByShortUrl(String url);
}
