/**
 * 
 */
package customer.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import customer.code.model.Role;


/**
 * @author Asd
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

	Role findByRoleId(final String roleId);
}
