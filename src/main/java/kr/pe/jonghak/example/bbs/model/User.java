package kr.pe.jonghak.example.bbs.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class User {

    private String name;
    private String email;
}
