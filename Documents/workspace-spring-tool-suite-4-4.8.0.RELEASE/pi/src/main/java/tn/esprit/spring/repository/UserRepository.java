package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Message;


public interface UserRepository extends CrudRepository<User, Long> {
	/*
	 * @Query("SELECT e FROM User e WHERE e.email=:email and e.password=:password")
	 * public User getUserByEmailAndPassword(
	 * 
	 * @Param("email")String login, @Param("password")String password);
	 */
	// find user by email
    User findByEmail(String email);

    // get last 5 unread notify message of user by email.
    @Query(value = "select m from Message m join User u on m.user = u.id where m.seen = 0 and  u.email = ?1  order by m.receivedDate desc")
    List<Message> getLastUnreadNotifyMessageByUserEmail(String email);

	/*
	 * @Query(value =
	 * "select i.review from order_item i where i.review_status = 'APPROVED' and i.id = ?"
	 * , nativeQuery = true) List<String> getApprovedReviews(Long itemId);
	 */
	/*
	 * @Query(
	 * value="select count (*) from Complaint c join Announcement a on c.announcement=a.id group By (a.customer)"
	 * )
	 * 
	 * @Modifying
	 * 
	 * @Query("update User u set u.enabled = false where u.id=a.id")
	 */
   

}
