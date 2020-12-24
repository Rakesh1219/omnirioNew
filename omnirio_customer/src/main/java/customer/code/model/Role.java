/**
 * 
 */
package customer.code.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;



/**
 * @author Asd
 *
 */
@EntityScan
@Table(name = "T_ROLES")
public class Role implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROLE_ID", unique = true, nullable = false)    
	private String roleId;
	
	@Column(name="ROLE_NAME", unique = true)    
	private String roleName;
	
	@Column(name="ROLE_CODE", unique = true)   
	private String roleCode;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	

}
