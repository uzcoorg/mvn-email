package com.mkyong;

import com.mkyong.mail.MailSend;
import com.mkyong.service.HelloMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private HelloMessageService helloService;
    @Autowired
    @Qualifier("javasampleapproachMailSender")
    public MailSend mailSender;
    public static void main(String[] args) throws Exception {

        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

        //SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String from = "ibor.test.run@gmail.com";
        String to = "uzco@mail.ru";
        String subject = "JavaMailSender";
        String body = "Just-Testing!";

        mailSender.sendMail(from, to, subject, body);

    }
}