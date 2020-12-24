/**
 * 
 */
package customer.code.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import customer.code.dto.ResponseDTO;
import customer.code.dto.UserDTO;
import customer.code.model.Customer;



/**
 * @author Asd
 *
 */
public interface UserService {

	public ResponseDTO<UserDTO> saveUser(HttpServletRequest request, final UserDTO userDTO);
	public ResponseDTO<UserDTO> updateUser(HttpServletRequest request, final UserDTO userDTO);
	public ResponseDTO<Customer> getUserDetail(HttpServletRequest request, final String userId);	
	public ResponseDTO<List<UserDTO>> getAllUsers();
	
}
