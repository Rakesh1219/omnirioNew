/**
 * 
 */
package account.code.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import account.code.model.Account;

/**
 * @author Asd
 *
 */
@Repository
public interface AccountRepository extends CrudRepository<Account,String> {
	
	Account findByAccountId(String accountId);
	
	@SuppressWarnings("unchecked")
	Account save(Account accountModel);
	

}
