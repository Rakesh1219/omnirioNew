/**
 * 
 */
package account.code.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author Asd
 *
 */

@Entity
@Table(name = "O_ACCOUNT")
public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name = "ACCOUNT_ID", unique = true, nullable = false)
	private String accountId;
	
	@Column(name = "ACCOUNT_TYPE")
	private String accountType;
	
	@Column(name = "OPEN_DATE")
	private Date openDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", updatable = false, nullable = false)
	private Customer customer;
	
	@Column(name = "BRANCH_NAME")
	private String branch;
	
	@Column(name = "MINOR_INDICATOR")
	private char minorIndicator;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public char getMinorIndicator() {
		return minorIndicator;
	}

	public void setMinorIndicator(char minorIndicator) {
		this.minorIndicator = minorIndicator;
	}
	
}
