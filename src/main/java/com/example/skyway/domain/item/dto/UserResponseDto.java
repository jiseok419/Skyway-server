package com.example.skyway.domain.item.dto;

import com.example.skyway.domain.item.entity.UserEntity;
import lombok.Getter;

import javax.persistence.ElementCollection;
import java.util.List;

@Getter
public class UserResponseDto {

    private Long id; // PK

    private String name; // 제목

    private String status; // 내용

    private int number;

    @ElementCollection
    private List<String> battalion; //알레르기

    public UserResponseDto(UserEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.status = entity.getStatus();
        this.number = entity.getNumber();
        this.battalion = entity.getBattalion();
    }
}
