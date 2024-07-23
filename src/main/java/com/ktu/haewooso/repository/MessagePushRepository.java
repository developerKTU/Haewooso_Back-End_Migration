package com.ktu.haewooso.repository;

import com.ktu.haewooso.domain.SendMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MessagePushRepository extends JpaRepository<SendMsg, String> {

    @Query("select m.pushToken from Member m where m.uuid not in :uuid order by random() LIMIT 1")
    String findByRandomPushToken(@Param("uuid") String uuid);

    @Query("select m.uuid from Member m where m.pushToken = :pushToken")
    String findByUuidOfRandomPushToken(@Param("pushToken") String pushToken);

}
