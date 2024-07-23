package com.ktu.haewooso.service;

import com.ktu.haewooso.dto.pushMessage.MessagePushDto;
import org.springframework.http.ResponseEntity;

public interface FCMNotificationService {
    public String getRandomReceiverToken(String uuid);
    public String getRandomReceiverUuid(String pushToken);
    public ResponseEntity<String> sendNotificationByToken(MessagePushDto messagePushDto, String randomReceiverToken);
    public ResponseEntity<String> insertMessageInfomation(MessagePushDto messagePushDto);
}
