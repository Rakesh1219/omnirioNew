/**
 * 
 */
package customer.code.service;

import java.util.List;

import customer.code.dto.ResponseDTO;
import customer.code.dto.RoleDTO;
import customer.code.model.Role;

/**
 * @author Asd
 *
 */
public interface RoleService {

	public ResponseDTO<RoleDTO> saveRole(final RoleDTO roleDTO);
	public ResponseDTO<RoleDTO> updateRole(final RoleDTO roleDTO);
	public ResponseDTO<Role> getRoleDetail(final String roleId);	
	public ResponseDTO<List<RoleDTO>> getAllRole();
	
}
