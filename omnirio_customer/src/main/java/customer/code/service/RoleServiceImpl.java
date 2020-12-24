/**
 * 
 */
package customer.code.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import customer.code.dto.ResponseDTO;
import customer.code.dto.RoleDTO;
import customer.code.model.Role;
import customer.code.repository.RoleRepository;

/**
 * @author Asd
 *
 */
@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public ResponseDTO<RoleDTO> saveRole(RoleDTO roleDTO) {
		// TODO Auto-generated method stub
		ResponseDTO<RoleDTO> response = null;
		Role isRoleExists = roleRepository.findByRoleId(roleDTO.getRoleId());
		if (null == isRoleExists) {
			response = new ResponseDTO<RoleDTO>();
			try {
				Role roleModel = null;
				roleModel = transformDTOToModel(roleDTO);
				Role roleSaved = roleRepository.save(roleModel);
				response.setStatus(true);
				response.setMessage("Role has been saved successfully.");
				RoleDTO dto = transferModelToDTO(roleSaved);
				response.setData(dto);
			}catch (Exception ex) {
				ex.printStackTrace();
				response = new ResponseDTO<RoleDTO>();
				response.setStatus(false);
				response.setMessage("Data Creation issue.");
				response.setData(null);
			}			
		} else {
			response = new ResponseDTO<RoleDTO>();
			response.setStatus(false);
			response.setMessage(roleDTO.getRoleId()+" is already exists!");
			response.setData(null);
		}
		
		return response;

	}

	@Transactional
	@Override
	public ResponseDTO<RoleDTO> updateRole(RoleDTO roleDTO) {
		// TODO Auto-generated method stub
		ResponseDTO<RoleDTO> response = null;
		Role isRoleExists = roleRepository.findByRoleId(roleDTO.getRoleId());
		if(null != isRoleExists) {
			response = new ResponseDTO<RoleDTO>();
			try {
				Role roleModel = null;
				roleModel = transformDTOToModel(roleDTO);
				Role roleSaved = roleRepository.save(roleModel);
				response.setStatus(true);
				response.setMessage("Role has been updated successfully.");
				RoleDTO dto = transferModelToDTO(roleSaved);
				response.setData(dto);
			}catch (Exception ex) {
				ex.printStackTrace();
				response = new ResponseDTO<RoleDTO>();
				response.setStatus(false);
				response.setMessage("Data Updation issue.");
				response.setData(null);
			}
		}else {
			response = new ResponseDTO<RoleDTO>();
			response.setStatus(false);
			response.setMessage(roleDTO.getRoleId()+" is does not exists!");
			response.setData(null);
		}
		
		return response;
	}

	@Override
	public ResponseDTO<Role> getRoleDetail(String roleId) {
		// TODO Auto-generated method stub
		ResponseDTO<Role> response = null;
		try {
			response = new ResponseDTO<Role>();
			Role roleModel = roleRepository.findByRoleId(roleId);
			if(null != roleModel) {
				response.setStatus(true);
				response.setMessage("Record found.");
				response.setData(roleModel);
			} else {
				response.setStatus(false);
				response.setMessage("No record found.");
				response.setData(null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Role fetching issue.");
			response.setData(null);
		}
		return response;
	}

	@Override
	public ResponseDTO<List<RoleDTO>> getAllRole() {
		// TODO Auto-generated method stub
		ResponseDTO<List<RoleDTO>> response = null;
		try {
			response = new ResponseDTO<List<RoleDTO>>();
			List<Role> roles = roleRepository.findAll();
			List<RoleDTO> roleDTOList = null;
			if(null != roles) {				
				roleDTOList = new ArrayList<RoleDTO>();
				for (Role rm : roles) {
					roleDTOList.add(transferModelToDTO(rm));
				}				
				response.setStatus(true);
				response.setMessage("Record found.");
				response.setData(roleDTOList);
			} else {
				response.setStatus(false);
				response.setMessage("No record found.");
				response.setData(null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Role fetching issue.");
			response.setData(null);
		}	
		return response;
	}
	
	
	private Role transformDTOToModel(RoleDTO roleDTO) {
		Role roleModel = new Role();
		roleModel.setRoleId(roleDTO.getRoleId());
		roleModel.setRoleCode(roleDTO.getRoleCode());
		roleModel.setRoleName(roleDTO.getRoleName());
		return roleModel;
	}	
	
	private RoleDTO transferModelToDTO (Role roleModel) {
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setRoleId(roleModel.getRoleId());
		roleDTO.setRoleCode(roleModel.getRoleCode());
		roleDTO.setRoleName(roleModel.getRoleName());
		return roleDTO;
	}

}
