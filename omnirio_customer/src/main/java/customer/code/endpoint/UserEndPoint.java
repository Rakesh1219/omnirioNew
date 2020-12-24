/**
 * 
 */
package customer.code.endpoint;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import customer.code.dto.ResponseDTO;
import customer.code.dto.UserDTO;
import customer.code.model.Customer;
import customer.code.service.UserService;

/**
 * @author Asd
 *
 */
@RestController
@RequestMapping("api/customer")
public class UserEndPoint {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ResponseDTO<UserDTO> createUser(HttpServletRequest request, @RequestBody UserDTO userDTO) {		
		return userService.saveUser(request, userDTO);		
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public ResponseDTO<UserDTO> updateUser(HttpServletRequest request, @RequestBody UserDTO userDTO) {		
		return userService.updateUser(request, userDTO);		
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ResponseDTO<Customer> getUserDetail(HttpServletRequest request, @RequestParam String userId) {		
		return userService.getUserDetail(request, userId);		
	}
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.POST)
	public ResponseDTO<List<UserDTO>> getAllUsers(HttpServletRequest request) {		
		return userService.getAllUsers();		
	}
	
}
