/**
 * 
 */
package account.code.dto;

import java.util.Date;

/**
 * @author Asd
 *
 */
public class AccountDTO {
	
	private String accountId;
	private String accountType;
	private Date openDate;
	private String customerId;
	private String branch;
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
