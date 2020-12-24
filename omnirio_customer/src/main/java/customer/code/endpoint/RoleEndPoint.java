/**
 * 
 */
package customer.code.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import customer.code.dto.ResponseDTO;
import customer.code.dto.RoleDTO;
import customer.code.model.Role;
import customer.code.service.RoleService;



/**
 * @author Asd
 *
 */
@RestController
@RequestMapping("api")
public class RoleEndPoint {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	public ResponseDTO<RoleDTO> createRole(@RequestBody RoleDTO roleDTO) {		
		return roleService.saveRole(roleDTO);		
	}
	
	@RequestMapping(value = "/updateRole", method = RequestMethod.PUT)
	public ResponseDTO<RoleDTO> updateRole(@RequestBody RoleDTO roleDTO) {		
		return roleService.updateRole(roleDTO);		
	}
	
	@RequestMapping(value = "/getRole", method = RequestMethod.GET)
	public ResponseDTO<Role> getRoleDetail(@RequestParam String roleId) {		
		return roleService.getRoleDetail(roleId);		
	}
	
	@RequestMapping(value = "/getAllRole", method = RequestMethod.POST)
	public ResponseDTO<List<RoleDTO>> getAllRole() {		
		return roleService.getAllRole();		
	}


}
