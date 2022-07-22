package com.urlproject.java.Controller;

import com.urlproject.java.Model.Url;
import com.urlproject.java.Service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService service;


    @GetMapping("/all")
    private ResponseEntity<List<Url>> getAll(){
        return ResponseEntity.ok(service.urls());
    }

    @PostMapping("/save")
    public Url save(@RequestBody Url url){
        service.save(url);
        return url;
    }

    @DeleteMapping("/delete")
    public String delete(){
        service.deleteAll();
        return "All Short Url Deleted!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.deleteId(id);
        return "Short Url Deleted!";
    }


    @PutMapping("/update")
    public Url update(@RequestBody Url url){
        service.save(url);
        return url;
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> getUrl(@PathVariable String shortUrl)  {
        Url url = service.getUrl(shortUrl);


        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url.getFullUrl())).build();
    }




}
