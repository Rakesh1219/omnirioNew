/**
 * 
 */
package customer.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import customer.code.model.UserAuth;



/**
 * @author Asd
 *
 */
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

}
