package tn.esprit.spring.controller;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.Authentication;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.service.MessageService;
import tn.esprit.spring.service.UserService;
@RestController


public class MessageController {
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	/*
	 * Get Request
	 */

	@GetMapping(value = { "/message" })
	public String getMessageListForm(Model model) {
		// get the current user message.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			User user = userService.findByEmail(authentication.getName());
			if (user != null) {
				Set<Message> messages = user.getMessages();
				model.addAttribute("messages", messages);
			}
		}

		return "/messages";
	}

	@GetMapping(value = {
			"/messages" }, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Message> getUserMessages() {
		// get current user principal
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.isAuthenticated()) {
			List<Message> messages = userService.getLastUnreadNotifyMessageByUserEmail(auth.getName());
			return messages;
		}

		return null;
	}

	@DeleteMapping(value = {
			"/messages/read/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean setMessageRead(@PathVariable(value = "id") Long id) {
		messageService.setMessageRead(id);
		return true;
	}

	@GetMapping(value = { "/message/read/{id}" })
	public String readMessage(@PathVariable(value = "id") Long id) {
		Message message = messageService.getMessageById(id);
		message.setSeen(true);
		messageService.saveMessage(message);
		return "redirect:/message";
	}

	@GetMapping(value = { "/message/delete/{id}" })
	public String deleteMessage(@PathVariable(value = "id") Long id) {
		Message message = messageService.getMessageById(id);
		messageService.delete(message);
		return "redirect:/message";
	}
}
