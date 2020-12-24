/**
 * 
 */
package customer.code.model;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import customer.code.constants.Constants;

/**
 * @author Asd
 *
 */

@Entity
@Table(name = "O_USER")
public class Customer {

	  @Id
	  @Column(name = "USER_ID", nullable = false)
	  private String userId;

	  @Column(name = "USER_NAME")
	  private String userName;

	  @Column(name = "DATE_OF_BIRTH")
	  private Date dateOfBirth;

	  @Column(name = "GENDER", nullable = false)
	  private String gender;

	  @Column(name = "PHONE_NUMBER")
	  private String phoneNumber;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

  
}
