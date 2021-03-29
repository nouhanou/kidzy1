package tn.esprit.spring.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.MessageRepository;
import tn.esprit.spring.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
    MessageRepository messageRepository;

   

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessages() {
        return (List<Message>) messageRepository.findAll();
    }

    @Override
    public Message getMessageById(Long id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public void delete(Message message) {
        messageRepository.delete(message);
    }

    @Override
    public void setMessageRead(Long id) {
        Message msg = messageRepository.findById(id).get();
        if(msg != null){
            msg.setSeen(true);
            messageRepository.save(msg);
        }
    }

    
	@Override
    public void sendMessageToUser(User toUser, String content) {
        Message msg = new Message();
        msg.setContents(content);
        msg.setReceivedDate(LocalDateTime.now());
        msg.setUser(toUser);
        msg.setSeen(false);
        messageRepository.save(msg);
    }
	
	/*
	 * @Override public JsonNode sendEmail(String from, String to, String subject,
	 * String content) throws UnirestException { HttpResponse<JsonNode> request =
	 * Unirest.post(mailConfig.getMailMessageUrl()) .basicAuth("api",
	 * mailConfig.getApiKey()) .queryString("from", from == null ?
	 * mailConfig.getNoReplyEmail() : from) .queryString("to", to)
	 * .queryString("subject", subject) .queryString("text", content) .asJson();
	 * return request.getBody();
	 * 
	 * }
	 */
	@Autowired
    private JavaMailSender javaMailSender;
	public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("darinet953@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }
	public void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        
        helper.setTo("darinet953@gmail.com");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        // hard coded a file path
        //FileSystemResource file = new FileSystemResource(new File("path/android.png"));

        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);

    }

}
