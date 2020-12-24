/**
 * 
 */
package account.code.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import account.code.dto.AccountDTO;
import account.code.dto.ResponseDTO;
import account.code.service.AccountService;

/**
 * @author Asd
 *
 */
@RestController
@RequestMapping("api/account")
public class AccountEnpoint {
	
	@Autowired
	AccountService accountService;

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public
	 * ResponseDTO<AccountDTO> getAccountDetails(@RequestParam(value = "accountId",
	 * defaultValue = "SBI00XXXX52" , required = false) String accountId,
	 * 
	 * @RequestParam(value = "accountType", defaultValue = "SAVING" , required =
	 * false) String accountType) {
	 * 
	 * ResponseDTO<AccountDTO> response = new ResponseDTO<AccountDTO>(); AccountDTO
	 * accountDTO = new AccountDTO(); accountDTO.setAccountId(accountId);
	 * accountDTO.setAccountType(accountType); response.setStatus(true);
	 * response.setMessage("SUCEESS"); response.setData(accountDTO);
	 * 
	 * return response; }
	 */
	
	@RequestMapping(value = "/getAllAccount", method = RequestMethod.GET)
	public ResponseDTO<List<AccountDTO>> getAllAccount() {
		
		return accountService.getAllAccount();
		
	}
	
	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public ResponseDTO<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
		
		return accountService.createAccount(accountDTO);
		
	}
	
	@RequestMapping(value = "/updateAccount", method = RequestMethod.PUT)
	public ResponseDTO<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO) {
		
		return accountService.updateAccount(accountDTO);
		
	}
	
	
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public ResponseDTO<AccountDTO> deleteAccount(@RequestBody AccountDTO accountDTO) {
		
		return accountService.deleteAccount(accountDTO);
		
	}
}
