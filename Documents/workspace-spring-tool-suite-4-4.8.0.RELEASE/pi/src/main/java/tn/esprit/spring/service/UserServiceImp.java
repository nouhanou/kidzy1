package tn.esprit.spring.service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.service.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import tn.esprit.spring.repository.*;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	private static final Logger L = LogManager.getLogger(UserServiceImp.class);

	@Override
	public List<User> retrieveAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		for (User user : users) {
			L.info("user +++ : " + user);
		}
		return users;
	}

	@Override
	public User addUser(User u) {
		u.getUsername();
		String hashPassword=bCryptPasswordEncoder.encode(u.getPassword());

		u.setPassword(hashPassword);
		u.setConfirmPassword(hashPassword);
		u.setEnabled(Boolean.TRUE);
        u.setAuthority("User");
        u.setType("customer");
		return userRepository.save(u);

	}

	@Override
	public User updateUser(User u) {
        // does this user change the password.
        User existsUser = userRepository.findById(u.getId()).get();
        boolean isMatches  = bCryptPasswordEncoder.matches(u.getPassword(), existsUser.getPassword());
        if(!isMatches){
            // update the password.
            String hashPassword = bCryptPasswordEncoder.encode(u.getPassword());
            u.setPassword(hashPassword);
            //u.setType("customer");
        }

        // persisted user to db.
		return userRepository.save(u);

	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(Long.parseLong(id));

	}

	@Override
	public User retrieveUser(String id) {
		User u;
		u = userRepository.findById(Long.parseLong(id)).orElse(null);
		return u;

	}

	@Override
	public User authenticate(String login, String password) {
		// return userRepository.getUserByEmailAndPassword(login, password);
		return null;
	}
	@Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
	
	@Override
    public List<Message> getLastUnreadNotifyMessageByUserEmail(String email) {
        return userRepository.getLastUnreadNotifyMessageByUserEmail(email);
    }

	@Override
	public Void Banned(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
