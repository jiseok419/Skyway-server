package com.example.skyway.domain.item.service;

import java.util.List;
import java.util.stream.Collectors;


import com.example.skyway.domain.item.Repository.UserRepository;
import com.example.skyway.domain.item.dto.UserRequestDto;
import com.example.skyway.domain.item.dto.UserResponseDto;
import com.example.skyway.domain.item.entity.UserEntity;
import com.example.skyway.global.exception.CustomException;
import com.example.skyway.global.exception.ErrorCode;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(final UserRequestDto params) {
        UserEntity entity = userRepository.save(params.toEntity());
        return entity.getId();
    }


    public List<UserResponseDto> findAll() {
        Sort sort = Sort.by(Direction.DESC, "id", "createdDate");
        List<UserEntity> list = userRepository.findAll(sort);
        return list.stream().map(UserResponseDto::new).collect(Collectors.toList());
    }
    
    @Transactional
    public Long update(final Long id, final UserRequestDto params) {
        UserEntity entity = userRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getName(), params.getStatus(), params.getNumber(), params.getBattalion());
        return id;
    }

}
