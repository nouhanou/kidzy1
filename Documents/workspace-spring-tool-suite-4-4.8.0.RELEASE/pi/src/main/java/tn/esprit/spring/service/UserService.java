package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Admin;
import tn.esprit.spring.entity.Customer;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.User;

public interface UserService {
	List<User> retrieveAllUsers();
	User addUser(User u);
	void deleteUser(String id);
	User updateUser(User u);
	User retrieveUser(String id);
	User authenticate(String login, String password);
    User findByEmail(String email);
    List<Message> getLastUnreadNotifyMessageByUserEmail(String email);
    Void Banned(Long id);

}
