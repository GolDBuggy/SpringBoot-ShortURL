package com.urlproject.java.Service;

import com.urlproject.java.Exceptions.UrlMapException;
import com.urlproject.java.Model.Url;
import com.urlproject.java.Repository.UrlRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepo repo;

    public List<Url> urls(){
        return repo.findAll();
    }

    public void save(Url url) {
        url.setShortUrl(shortUrl());
        repo.save(url);
    }

    public String shortUrl(){
        String s= UUID.randomUUID().toString().substring(0,6);
        return s;
    }

    public Url getUrl(String shortUrl) {
        Url url=repo.findByShortUrl(shortUrl);

        if(url==null)
            throw new UrlMapException("Url mapping error!");

        url.setFullUrl(controlString(url.getFullUrl()));
        return url;
    }


    public void deleteAll(){
        repo.deleteAll();
    }


    public void deleteId(Long id){
        if(id==null)
            throw new UrlMapException("Url Not Found!");

        repo.deleteById(id);
    }



    public String controlString(String url){
        if( !url.substring(0,7).equals("http://") && !url.substring(0,8).equals("https://")){
            url="http://"+url;
        }
        return url;
    }
}
