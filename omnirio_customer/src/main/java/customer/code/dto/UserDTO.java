/**
 * 
 */
package customer.code.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonTypeName;


/**
 * @author Asd
 *
 */
@JsonTypeName("User")
public class UserDTO {
	
	private String userId;
	private String userName;
	private Date dateOfBirth;	
	private String gender;
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
