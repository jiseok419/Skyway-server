package com.example.skyway.domain.item.controller;

import java.util.List;

import com.example.skyway.domain.item.Repository.UserRepository;
import com.example.skyway.domain.item.dto.UserRequestDto;
import com.example.skyway.domain.item.dto.UserResponseDto;
import com.example.skyway.domain.item.entity.UserEntity;
import com.example.skyway.domain.item.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserController {

    private final UserService boardService;
    private final UserRepository userRepository;


    @PostMapping
    public Long save(@RequestBody final UserRequestDto params) {
        return boardService.save(params);
    }


    @GetMapping
    public List<UserResponseDto> findAll() {
        return boardService.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity geBookById(@PathVariable long id) {
        return userRepository.findUserEntityById(id);
    }


    @PutMapping
    public Long save(@PathVariable Long id, @RequestBody final UserRequestDto params) {
        return boardService.update(id, params);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

}
