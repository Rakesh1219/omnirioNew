/**
 * 
 */
package customer.code.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author Asd
 *
 */
@Entity
@Table(name = "O_USER_AUTH")
public class UserAuth {
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @OneToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "USER_ID", updatable = false, nullable = false, unique = true)
	  private Customer user;

	  @OneToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "ROLE_ID", updatable = false, nullable = false)
	  private Role role;

	  @Column(name = "PASSWORD")
	  private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	  
	  
}
