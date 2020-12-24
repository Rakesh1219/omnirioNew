/**
 * 
 */
package account.code.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import account.code.dto.AccountDTO;
import account.code.dto.ResponseDTO;
import account.code.model.Account;
import account.code.repository.AccountRepository;

/**
 * @author Asd
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired(required=true)
	AccountRepository accountRepository;

	
	public ResponseDTO<AccountDTO> createAccount(AccountDTO accountDTO) {
		// TODO Auto-generated method stub
		ResponseDTO<AccountDTO> response = null;		
		Account isExistsAccount = accountRepository.findByAccountId(accountDTO.getAccountId());
		if (null == isExistsAccount) {
			response = new ResponseDTO<AccountDTO>();
			try {
				Account accountModel = null;
				accountModel = transformDTOToModel(accountDTO);
				Account accountSaved = accountRepository.save(accountModel);
				response.setStatus(true);
				response.setMessage("Account has been created successfully.");
				AccountDTO dto = transferModelToDTO(accountSaved);
				response.setData(dto);
			}catch (Exception ex) {
				ex.printStackTrace();
				response = new ResponseDTO<AccountDTO>();
				response.setStatus(false);
				response.setMessage("Data Creation issue.");
				response.setData(null);
			}			
		} else {
			response = new ResponseDTO<AccountDTO>();
			response.setStatus(false);
			response.setMessage(accountDTO.getAccountId()+" is already exists!");
			response.setData(null);
		}		
		return response;
	}

	@Transactional
	public ResponseDTO<AccountDTO> updateAccount(AccountDTO accountDTO) {
		// TODO Auto-generated method stub
		ResponseDTO<AccountDTO> response = null;		
		Account isExistsAccount = accountRepository.findByAccountId(accountDTO.getAccountId());
		if (null != isExistsAccount) {
			response = new ResponseDTO<AccountDTO>();
			try {
				Account accountModel = null;
				accountModel = transformDTOToModel(accountDTO);
				Account accountSaved = accountRepository.save(accountModel);
				response.setStatus(true);
				response.setMessage("Account has been updated successfully.");
				AccountDTO dto = transferModelToDTO(accountSaved);
				response.setData(dto);
			}catch (Exception ex) {
				ex.printStackTrace();
				response = new ResponseDTO<AccountDTO>();
				response.setStatus(false);
				response.setMessage("Account Updation issue.");
				response.setData(null);
			}			
		} else {
			response = new ResponseDTO<AccountDTO>();
			response.setStatus(false);
			response.setMessage(accountDTO.getAccountId()+" does not exists!");
			response.setData(null);
		}		
		return response;
	}

	public ResponseDTO<Account> getAccountDetail(AccountDTO accountDTO) {
		// TODO Auto-generated method stub
		ResponseDTO<Account> response = null;	
		if(null != accountDTO.getAccountId()) {
			response = new ResponseDTO<Account>();
			Account accountModel = accountRepository.findByAccountId(accountDTO.getAccountId());
			response.setStatus(true);
			response.setMessage("Data fetch successfully.");
			response.setData(accountModel);
		}else {
			response = new ResponseDTO<Account>();
			response.setStatus(false);
			response.setMessage(accountDTO.getAccountId()+" does not exists!");
			response.setData(null);
		}		
		return response;
	}

	public ResponseDTO<List<AccountDTO>> getAllAccount() {
		// TODO Auto-generated method stub
		ResponseDTO<List<AccountDTO>> response = new ResponseDTO<List<AccountDTO>>();
		List<Account> accountModelList = new ArrayList<Account>();
		accountModelList = (List<Account>) accountRepository.findAll();
		List<AccountDTO> accountList = new ArrayList<AccountDTO>();
		for(Account am : accountModelList) {
			AccountDTO accountDTO = new AccountDTO();
			accountDTO = transferModelToDTO(am);
			accountList.add(accountDTO);
		}
		response.setData(accountList);
		response.setStatus(true);
		response.setMessage("Data fetch successfully.");
		
		return response;
	}

	public ResponseDTO<AccountDTO> deleteAccount(AccountDTO accountDTO) {
		// TODO Auto-generated method stub
		ResponseDTO<AccountDTO> response = new ResponseDTO<AccountDTO>();
		accountRepository.deleteById(accountDTO.getAccountId());
		response.setStatus(true);
		response.setMessage("Account Deleted Successfully.");
		response.setData(null);
		return response;
	}
	
	
	private Account transformDTOToModel(AccountDTO accountDTO) {
		Account accountModel = new Account();
		accountModel.setAccountId(accountDTO.getAccountId());
		accountModel.setAccountType(accountDTO.getAccountType());
		accountModel.setCustomerId(accountDTO.getCustomerId());
		accountModel.setOpenDate(accountDTO.getOpenDate());
		accountModel.setMinorIndicator(accountDTO.getMinorIndicator());
		accountModel.setBranch(accountDTO.getBranch());
		return accountModel;
	}	
	
	private AccountDTO transferModelToDTO (Account accountModel) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountId(accountModel.getAccountId());
		accountDTO.setAccountType(accountModel.getAccountType());
		accountDTO.setCustomerId(accountModel.getCustomerId());
		accountDTO.setOpenDate(accountModel.getOpenDate());
		accountDTO.setMinorIndicator(accountModel.getMinorIndicator());
		accountDTO.setBranch(accountModel.getBranch());
		return accountDTO;
	}

}
