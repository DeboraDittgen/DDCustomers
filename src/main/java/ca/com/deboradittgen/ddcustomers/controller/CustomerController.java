package ca.com.deboradittgen.ddcustomers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ca.com.deboradittgen.ddcustomers.model.Customer;
import ca.com.deboradittgen.ddcustomers.repository.CustomerRepository;

@Controller
@RequestMapping("/customer")
public class CustomerController {


//Atribute to access and manipulate the BD //
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("customer/list.html");

//Create a list with the database data
        List<Customer> customers = customerRepository.findAll();
//Show the list to view
        modelAndView.addObject("customers", customers);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView delail(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("customer/detail.html");

        Customer customer = customerRepository.getById(id);
        modelAndView.addObject("customer", customer);

        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");

        customerRepository.deleteById(id);

        return modelAndView; 
    }

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView("customer/register");

        modelAndView.addObject("customer", new Customer());
        
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(Customer customer){
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");

        customerRepository.save(customer);

        return modelAndView;

    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("customer/edit");

        Customer customer = customerRepository.getById(id);
        modelAndView.addObject("customer", customer);

        return modelAndView;
    }

    @PostMapping("/{id}/edit")
    public ModelAndView edit(Customer customer){
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");

        customerRepository.save(customer);

        return modelAndView;
        
    }
}
