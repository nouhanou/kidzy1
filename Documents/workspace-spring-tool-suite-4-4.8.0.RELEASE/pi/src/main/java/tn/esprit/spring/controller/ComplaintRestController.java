package tn.esprit.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.exceptions.UnirestException;

import tn.esprit.spring.entity.*;
import tn.esprit.spring.service.*;
@RestController

public class ComplaintRestController {
	@Autowired
	ComplaintServiceImpl complaintService;
	@Autowired
	MessageServiceImpl messageService;
	
	// http://localhost:8082/SpringMVC/servlet/retrieve-all-Complaint
	@GetMapping("/retrieve-all-Complaint")
	@ResponseBody
	public List<Complaint> getComplaint() {
	List<Complaint> list= complaintService.retrieveAllComplaint();
	return list;
}
	// http://localhost:8082/SpringMVC/servlet/retrieve-Complaint/{Complaint-id}
	@GetMapping("/retrieve-Complaint/{Complaint-id}")
	@ResponseBody
	public Complaint retrieveComplaint(@PathVariable("Complaint-id") String ComplaintId) {
	return complaintService.retrieveComplaint(ComplaintId);}
	
	
	// Ajouter Complaint : http://localhost:8082/SpringMVC/servlet/add-Complaint
	@PostMapping("/add-Complaint")
	@ResponseBody
	public Complaint addComplaint(@RequestBody Complaint r) {
		
		Complaint complaint= complaintService.addComplaint(r);

	return complaint;
	}
	// http://localhost:8082/SpringMVC/servlet/remove-Complaint/{Complaint-id}
	@DeleteMapping("/remove-Complaint/{Complaint-id}")
	@ResponseBody
	public void removeUser(@PathVariable("Complaint-id") String complaintId) {
		complaintService.deleteComplaint(complaintId);
	}

	
	// http://localhost:8082/SpringMVC/servlet/modify-Complaint
	@PutMapping("/modify-Complaint")
	@ResponseBody
	public Complaint modifyComplaint(@RequestBody Complaint complaint) {
	return complaintService.updateComplaint(complaint);
	}
	@PostMapping("/complaint/{comPId}/approve")
    public String approveReview(@PathVariable("comPId") String comPId, Model model) throws UnirestException {
        Complaint complaint = complaintService.retrieveComplaint(comPId);
        if (complaint != null) {
        	complaint.setComplaintStatus(Status.APPROVED);
        	complaintService.addComplaint(complaint);
            String subject = "Dari: Approve Complaint";
            String content = "Your complaint for the announcement " + complaint.getAnnouncement().getTitle() + " has been approved.";
            //messageService.sendEmail("ja.vietanh@gmail.com", orderItem.getOrder().getBuyer().getUser().getEmail(), subject, content);
            messageService.sendEmail();
        }
        model.addAttribute("item", complaint);
        return "redirect:retrieve-all-Complaint";
    }
	@PostMapping("/complaint/{comPId}/reject")
    public String rejectReview(@PathVariable("comPId") String comPId, Model model) throws UnirestException, MessagingException, IOException {
        Complaint complaint = complaintService.retrieveComplaint(comPId);
        if (complaint != null) {
        	complaint.setComplaintStatus(Status.REJECTED);
        	complaintService.addComplaint(complaint);
            String subject = "Dari: Reject Complaint";
            String content = "Your complaint for the announcement " + complaint.getAnnouncement().getTitle() + " has been rejected.";
            //messageService.sendEmail("ja.vietanh@gmail.com", orderItem.getOrder().getBuyer().getUser().getEmail(), subject, content);
            //messageService.sendEmailWithAttachment();
        }
        model.addAttribute("item", complaint);
        return "redirect:retrieve-all-Complaint";
    }
    

}
