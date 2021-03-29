package tn.esprit.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.*;
import tn.esprit.spring.service.*;
import tn.esprit.spring.repository.*;
@RestController


public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
           // logger.info("logout ok");
        }
        return "redirect";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }


@GetMapping(value = {"/register"})
public String getRegisterPage() {
    return "/account/register";
}
/*
 * @GetMapping(value = {"/customer-register"}) public String
 * getSellerRegisterForm(@ModelAttribute("customer") Customer customer) { return
 * "/account/customerRegister"; }
 */

@GetMapping(value = {"/consultant-register"})
public String getBuyerRegisterForm(@ModelAttribute("consultant") Consultant consultant) {
    return "/account/consultantRegister";
}

@GetMapping(value = {"/register-success"})
public String getSuccessPage() {
    return "/account/register-success";
}
@PostMapping(value = {"/account/customerRegister"})
public String postCustomerrRegister(@Valid @RequestBody User user, BindingResult result) {

    // check if the email is unique
    User existsUser = userService.findByEmail(user.getEmail());
    if (existsUser != null) {
        // reject with error when email is not unique
        result.rejectValue("email", "email.exists", "There is already a user registered with the email provided.");
    }

	/*
	 *  validation data. if (result.hasErrors()) { return
	 * "/account/customerRegister"; }
	 */

    // call service save new user as a customer
    // set user role as BUYER
   // @Type(value = Customer.class, name = "customer");
    // create new user.
    userService.addUser(user);
    

   

   
   
    return "redirect:/login";
}

}