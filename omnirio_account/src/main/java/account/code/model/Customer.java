package account.code.model;



import org.hibernate.annotations.Type;

import account.code.constants.Constants;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "O_USER")
public class Customer {

  @Id
  @Column(name = "USER_ID", nullable = false)
  private String id;

  @Column(name = "USER_NAME")
  private String name;

  @Type(type = Constants.DATE_TYPE)
  @Column(name = "DOB")
  private ZonedDateTime dob;

  @Column(name = "gender", nullable = false)
  private String gender;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Customer customer = (Customer) o;

    return id.equals(customer.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
