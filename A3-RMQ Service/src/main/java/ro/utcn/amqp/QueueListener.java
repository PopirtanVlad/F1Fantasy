package ro.utcn.amqp;

import org.apache.commons.io.IOUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.amqp.dto.UserDto;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class QueueListener {

    @Autowired
    private JavaMailSender mailSender;

    @RabbitListener(queues = "F1Fantasy_Queue")
    public void listen(UserDto userDto) throws MessagingException, IOException {
        MimeMessage message= mailSender.createMimeMessage();

        MimeMessageHelper helper=new MimeMessageHelper(message);
        helper.setSubject("Password remind request");
        helper.setFrom("noreply@fantasy.com");
        helper.setTo("You");

        InputStream fl=new FileInputStream("src/main/resources/templates/new_account_email.html");
        String content= IOUtils.toString(fl,"UTF-8");

        content=content.replace("replaceusername",userDto.getUser_name());

        helper.setText(content,true);

        mailSender.send(message);
    }

    @PostMapping("/sendMail")
    public void sendPasswordMail(@RequestBody UserDto requestedUser) throws MessagingException, IOException {
        MimeMessage message= mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message);

        helper.setSubject("Password remind request");
        helper.setFrom("noreply@fantasy.com");
        helper.setTo("You");

        InputStream fl=new FileInputStream("src/main/resources/templates/forgot_password_email.html");
        String content= IOUtils.toString(fl,"UTF-8");

        content=content.replace("replaceemail",requestedUser.getUser_email());
        content=content.replace("replaceusername",requestedUser.getUser_name());
        content=content.replace("replacepassword",requestedUser.getUser_password());

        helper.setText(content,true);

        mailSender.send(message);
    }

}
