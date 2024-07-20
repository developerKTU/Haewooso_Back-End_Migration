package com.ktu.haewooso.repository;

import com.ktu.haewooso.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByUuid(String uuid);

}
