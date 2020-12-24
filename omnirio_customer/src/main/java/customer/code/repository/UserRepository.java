/**
 * 
 */
package customer.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import customer.code.model.Customer;



/**
 * @author Asd
 * 
 */
public interface UserRepository extends JpaRepository<Customer, String> {

	Customer findByUserId(final String userId);
	
}
