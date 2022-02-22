package ca.com.deboradittgen.ddcustomers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.com.deboradittgen.ddcustomers.model.Customer;
/* to Manipulate the BD*/
public interface CustomerRepository extends JpaRepository<Customer, Long> {  
}
