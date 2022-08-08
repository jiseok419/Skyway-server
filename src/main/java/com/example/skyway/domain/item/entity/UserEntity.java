package com.example.skyway.domain.item.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class UserEntity {

    @Id @GeneratedValue
    private Long id; // PK

    private String name; // 제목

    private String status; // 내용

    private int number;

    @ElementCollection
    private List<String> battalion;


    @Builder
    public UserEntity(String name, String status, int number, List<String> battalion) {
        this.name = name;
        this.status = status;
        this.number = number;
        this.battalion = battalion;
    }


    public void update(String name, String status, int number, List<String> battalion) {
        this.name = name;
        this.status = status;
        this.number = number;
        this.battalion = battalion;
    }

}