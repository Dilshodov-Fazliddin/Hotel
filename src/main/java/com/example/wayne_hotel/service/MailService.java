package com.example.wayne_hotel.service;

import com.example.wayne_hotel.dto.MailDto;
import com.example.wayne_hotel.entiy.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;


    public void sendMessage(String email,String message) {
        MailDto mailDto=new MailDto(email,message);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailDto.getEmail());
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setText(mailDto.getMessage());
        mailSender.send(simpleMailMessage);
    }

    public void sendInfoBlockAccount(String email) {
        String message = "\uD83D\uDEAB Your account has been blocked by Wayne hotel \uD83D\uDEAB";
        sendMessage(email,message);
    }


    public void sendInfoUnBlockAccount(String email) {
        String message = "✅ Your account has been removed from Block at Wayne hotel ✅";
        sendMessage(email,message);
    }

    public void sendInfoPurchased(String email,Integer daysForRent,Double price,String name) {
        String message = "Congratulations, you have purchased room in Wayne hotel✅"+"\n"
                        +"Day For rent\uD83D\uDCC6: " + daysForRent+"\n"
                        +"Number your room\uD83D\uDD11: " +name + "\n"
                        +"Price\uD83D\uDCB5: "+price;
        sendMessage(email,message);
    }
}
