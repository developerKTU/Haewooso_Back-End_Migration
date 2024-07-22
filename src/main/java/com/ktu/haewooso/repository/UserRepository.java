package com.ktu.haewooso.repository;

import com.ktu.haewooso.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Members, String> {

    List<Members> findByUuid(String uuid);

}
