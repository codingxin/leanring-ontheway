package com.codingzx.发送邮件;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import java.util.Date;

public class hello {
    @Autowired
    JavaMailSender javaMailSender;

    @Test
    public void sendSimpleMail() throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一封测试邮件");
        message.setFrom("994683607@qq.com");
        message.setTo("1452212105@qq.com");
//        message.setCc("994683607@qq.com");  // 抄送人
//        message.setBcc("14xxxxx098@qq.com"); // 隐秘抄送
        message.setSentDate(new Date());
        message.setText("测试简单发送邮件");
        javaMailSender.send(message);
    }
}
