/**
 * 
 */
package account.code.client;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import account.code.model.Customer;

/**
 * @author Asd
 *
 */
public class CustomerServiceClient {
	public static final String CUSTOMER_API_PATH = "customer/api/customers/";

	  @Value("${service.registry.customer-service}")
	  private String customerServiceName;

	  @Autowired
	  private EurekaClient discoveryClient;

	  private RestTemplate restTemplate = new RestTemplate();

	  public Customer createCustomer(final Customer customer) {
	    final Application clientApplication = this.discoveryClient.getApplication(customerServiceName);
	    final String homePageUrl = clientApplication.getInstances().get(0).getHomePageUrl();

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    HttpEntity<Customer> request = new HttpEntity<>(customer, headers);

	    final String url = homePageUrl + CUSTOMER_API_PATH;
	    ResponseEntity<Customer> responseEntityStr = restTemplate.postForEntity(url, request, Customer.class);
	    return responseEntityStr.getBody();
	  }
}
