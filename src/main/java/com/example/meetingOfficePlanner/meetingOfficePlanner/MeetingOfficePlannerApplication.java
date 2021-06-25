package com.example.meetingOfficePlanner.meetingOfficePlanner;
import com.example.meetingOfficePlanner.meetingOfficePlanner.repository.UserRepository;
import com.example.meetingOfficePlanner.meetingOfficePlanner.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@SpringBootApplication
public class MeetingOfficePlannerApplication {
//	@Autowired
//	private SendEmailService sendEmailService;

    public static void main(String[] args) {
        SpringApplication.run(MeetingOfficePlannerApplication.class, args);
    }
    //@EventListener(ApplicationReadyEvent.class)
//public void triggerWhenStarts(){
//		sendEmailService.sendEmail("kipkemoifred2018@gmail.com","Hi","test");
//	}

}
