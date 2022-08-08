package com.example.skyway.domain.item.Repository;


import com.example.skyway.domain.item.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserEntityById(long id);
}