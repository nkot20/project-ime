package ime.imebackend.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import ime.imebackend.entity.Email;


@Service
public class SendEmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public Email sendEmail(@Valid Email email) {
		System.out.println("sending email");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("etiennenkot1@gmail.com");
		simpleMailMessage.setTo(email.getTo());
		simpleMailMessage.setSubject (email.getTopic());
		simpleMailMessage.setText(email.getBody());
		javaMailSender.send(simpleMailMessage);
		System.out.println("sent email");
		return email;
	}
	
}
