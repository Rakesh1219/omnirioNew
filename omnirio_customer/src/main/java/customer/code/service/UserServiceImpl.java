/**
 * 
 */
package customer.code.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import customer.code.dto.ResponseDTO;
import customer.code.dto.UserDTO;
import customer.code.model.Customer;
import customer.code.repository.UserRepository;


/**
 * @author Asd
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;	

	@Override
	public ResponseDTO<UserDTO> saveUser(HttpServletRequest request, UserDTO userDTO) {
		// TODO Auto-generated method stub
		ResponseDTO<UserDTO> response = null;
		Customer isExistsUser = userRepository.findByUserId(userDTO.getUserId());
		if (null == isExistsUser) {
			response = new ResponseDTO<UserDTO>();
			try {
				Customer Customer = null;
				Customer = transformUserDTOToModel(userDTO);
				Customer userSaved = userRepository.save(Customer);
				response.setStatus(true);
				response.setMessage("User has been saved successfully.");
				UserDTO dto = transferModelToDTO(userSaved);
				response.setData(dto);
			}catch (Exception ex) {
				ex.printStackTrace();
				response = new ResponseDTO<UserDTO>();
				response.setStatus(false);
				response.setMessage("Data Creation issue.");
				response.setData(null);
			}			
		} else {
			response = new ResponseDTO<UserDTO>();
			response.setStatus(false);
			response.setMessage(userDTO.getUserName()+" is already exists!");
			response.setData(null);
		}
		
		return response;
	}


	@Transactional
	@Override
	public ResponseDTO<UserDTO> updateUser(HttpServletRequest request, UserDTO userDTO) {
		// TODO Auto-generated method stub
		ResponseDTO<UserDTO> response = null;
		Customer isExistsUser = userRepository.findByUserId(userDTO.getUserId());
		if(null != isExistsUser) {
			response = new ResponseDTO<UserDTO>();
			try {
				Customer Customer = null;
				Customer = transformUserDTOToModel(userDTO);
				Customer userSaved = userRepository.save(Customer);
				response.setStatus(true);
				response.setMessage("User has been updated successfully.");
				UserDTO dto = transferModelToDTO(userSaved);
				response.setData(dto);
			}catch (Exception ex) {
				ex.printStackTrace();
				response = new ResponseDTO<UserDTO>();
				response.setStatus(false);
				response.setMessage("Data Updation issue.");
				response.setData(null);
			}
		}else {
			response = new ResponseDTO<UserDTO>();
			response.setStatus(false);
			response.setMessage(userDTO.getUserName()+" is does not exists!");
			response.setData(null);
		}
		
		return response;
	}

	@Override
	public ResponseDTO<Customer> getUserDetail(HttpServletRequest request, String userId) {
		// TODO Auto-generated method stub
		ResponseDTO<Customer> response = null;
		try {
			response = new ResponseDTO<Customer>();
			Customer Customer = userRepository.findByUserId(userId);
			if(null != Customer) {
				response.setStatus(true);
				response.setMessage("Record found.");
				response.setData(Customer);
			} else {
				response.setStatus(false);
				response.setMessage("No record found.");
				response.setData(null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("User fetching issue.");
			response.setData(null);
		}
		return response;
	}
	
	@Override
	public ResponseDTO<List<UserDTO>> getAllUsers() {
		// TODO Auto-generated method stub
		ResponseDTO<List<UserDTO>> response = null;
		try {
			response = new ResponseDTO<List<UserDTO>>();
			List<Customer> users = userRepository.findAll();
			List<UserDTO> userDTOList = null;
			if(null != users) {				
				userDTOList = new ArrayList<UserDTO>();
				for (Customer um : users) {
					userDTOList.add(transferModelToDTO(um));
				}				
				response.setStatus(true);
				response.setMessage("Record found.");
				response.setData(userDTOList);
			} else {
				response.setStatus(false);
				response.setMessage("No record found.");
				response.setData(null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("User fetching issue.");
			response.setData(null);
		}
		return response;
	}
	
	private Customer transformUserDTOToModel(UserDTO userDTO) {
		Customer Customer = new Customer();
		Customer.setUserId(userDTO.getUserId());
		Customer.setUserName(userDTO.getUserName());
		Customer.setGender(userDTO.getGender());
		Customer.setDateOfBirth(userDTO.getDateOfBirth());
		Customer.setPhoneNumber(userDTO.getPhoneNumber());
		return Customer;
	}	
	
	private UserDTO transferModelToDTO (Customer Customer) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(Customer.getUserId());
		userDTO.setUserName(Customer.getUserName());
		userDTO.setGender(Customer.getGender());
		userDTO.setDateOfBirth(Customer.getDateOfBirth());
		userDTO.setPhoneNumber(Customer.getPhoneNumber());
		return userDTO;
	}
}
