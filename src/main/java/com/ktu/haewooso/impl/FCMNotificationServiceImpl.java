package com.ktu.haewooso.impl;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.ktu.haewooso.domain.SendMsg;
import com.ktu.haewooso.dto.pushMessage.MessagePushDto;
import com.ktu.haewooso.repository.MessagePushRepository;
import com.ktu.haewooso.service.FCMNotificationService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class FCMNotificationServiceImpl implements FCMNotificationService {

    private final MessagePushRepository messagePushRepository;
    private final FirebaseMessaging firebaseMessaging;
    private final EntityManager em;
    @Autowired
    public FCMNotificationServiceImpl(MessagePushRepository messagePushRepository, FirebaseMessaging firebaseMessaging, EntityManager em){
        this.messagePushRepository = messagePushRepository;
        this.firebaseMessaging = firebaseMessaging;
        this.em = em;
    }

    @Override
    public String getRandomReceiverToken(String uuid) {
        try{
            String randomToken = messagePushRepository.findByRandomPushToken(uuid);
            return randomToken;
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("400", HttpStatus.BAD_REQUEST).getBody();
        }
    }

    @Override
    public String getRandomReceiverUuid(String pushToken) {
        try{
            String uuidOfRendomToken = messagePushRepository.findByUuidOfRandomPushToken(pushToken);
            return uuidOfRendomToken;
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("400", HttpStatus.BAD_REQUEST).getBody();
        }
    }

    @Override
    public ResponseEntity<String> sendNotificationByToken(MessagePushDto messagePushDto, String randomReceiverToken) {

        Notification notification = Notification.builder()
                .setTitle(messagePushDto.getTitle())
                .setBody(messagePushDto.getDescription())
                .build();

        Message message = Message.builder()
                .setToken(randomReceiverToken)
                .setNotification(notification)
                .build();

        try{
            firebaseMessaging.send(message);
            return new ResponseEntity<String>("200", HttpStatus.OK);
        }catch (FirebaseMessagingException e){
            e.printStackTrace();
            return new ResponseEntity<String>("400", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> insertMessageInfomation(MessagePushDto messagePushDto) {
        try{
            SendMsg sendMsg = SendMsg.builder()
                    .sendUuid(messagePushDto.getSendUuid())
                    .receiveUuid(messagePushDto.getReceiveUuid())
                    .title(messagePushDto.getTitle())
                    .description(messagePushDto.getDescription())
                    .sendBoardReplyCount(5)
                    .replyCompleteYn('N')
                    .sendDate(LocalDateTime.now())
                    .receiveDate(null)
                    .replyViewYn(messagePushDto.getReplyViewYn())
                    .mainViewYn(messagePushDto.getMainViewYn())
                    .replyPossibleYn(messagePushDto.getReplyPossibleYn())
                    .build();
            messagePushRepository.save(sendMsg);
            em.flush();
            em.clear();
            System.out.println("sendMsg = " + sendMsg.toString());
            return new ResponseEntity<String>("200", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("400", HttpStatus.OK);
        }

    }
}
