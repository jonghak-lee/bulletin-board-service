package kr.pe.jonghak.example.bbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BulletinBoardServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BulletinBoardServiceApplication.class, args);
    }

}
