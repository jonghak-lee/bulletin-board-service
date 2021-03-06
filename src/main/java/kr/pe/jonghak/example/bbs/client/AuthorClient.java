package kr.pe.jonghak.example.bbs.client;

import kr.pe.jonghak.example.bbs.model.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${feign.client.config.user-service.url}")
public interface AuthorClient {

    @GetMapping("/users/{id}")
    Author getAuthor(@PathVariable("id") String id);
}
