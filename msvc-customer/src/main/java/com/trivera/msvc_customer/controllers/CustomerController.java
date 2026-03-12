package com.trivera.msvc_customer.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trivera.msvc_customer.dto.CustomerDTO;
import com.trivera.msvc_customer.services.ICustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
  
  private ICustomerService customerService;

  public CustomerController(ICustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  public List<CustomerDTO> getAllCustomers() {
    return customerService.getAll();
  }

  @PostMapping
  public CustomerDTO saveCustomer(@RequestBody CustomerDTO customer) {
    // Todo: add model validations
    return customerService.save(customer);
  }

  @GetMapping("/{code}")
  public ResponseEntity<CustomerDTO> getByCode(@PathVariable String code) {
    CustomerDTO customer = customerService.getByCode(code);

    // Todo: handle with an exception and try-catch
    if (customer.getId() == null)
      return ResponseEntity.notFound().build();

    return ResponseEntity.ok(customer);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteCustomer(@PathVariable UUID id) {
    customerService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
