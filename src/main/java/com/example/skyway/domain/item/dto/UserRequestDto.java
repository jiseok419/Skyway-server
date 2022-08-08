package com.example.skyway.domain.item.dto;

import com.example.skyway.domain.item.entity.UserEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequestDto {

    private String name; // 제목

    private String status; // 내용

    private int number;

    @ElementCollection
    private List<String> battalion;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .name(name)
                .status(status)
                .number(number)
                .battalion(battalion)
                .build();
    }

}
