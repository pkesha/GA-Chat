package com.ga.chat.repository;

import java.util.List;
import java.util.Optional;

import com.ga.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUserName(String userName);

    User findByUserName(String userName);

    User findUserById(Long id);
}
