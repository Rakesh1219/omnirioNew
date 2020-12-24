/**
 * 
 */
package account.code.service;

import java.util.List;

import account.code.dto.AccountDTO;
import account.code.dto.ResponseDTO;
import account.code.model.Account;

/**
 * @author Asd
 * @param <AccountDTO>
 *
 */
public interface AccountService {

	public ResponseDTO<AccountDTO> createAccount(final AccountDTO accountDTO);
	
	public ResponseDTO<AccountDTO> updateAccount(final AccountDTO accountDTO);
	
	public ResponseDTO<Account> getAccountDetail(final AccountDTO accountDTO);
	
	public ResponseDTO<List<AccountDTO>> getAllAccount();
	
	public ResponseDTO<AccountDTO> deleteAccount(final AccountDTO accountDTO);
	
}
