package tn.esprit.spring.service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import com.fasterxml.jackson.databind.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.User;

public interface MessageService {
	Message saveMessage(Message message);

    List<Message> getMessages();

    Message getMessageById(Long id);

    void setMessageRead(Long id);

    void delete(Message message);

	void sendMessageToUser(User toUser, String content);
   //JsonNode sendEmail(String from, String to, String subject, String content) throws UnirestException;
	public void sendEmail();
	public void sendEmailWithAttachment() throws MessagingException, IOException;

}
