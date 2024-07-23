package com.ktu.haewooso.repository;

import com.ktu.haewooso.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    @Query("select m from Member m")
    List<Member> findByMember();

}
