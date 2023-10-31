package lk.ijse.user.service;

import lk.ijse.user.dto.CustomerDto;
import lk.ijse.user.dto.UserDto;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDto customerDto);

    void updateCustomer(CustomerDto customerDto);

   void deleteCustomer(String id);

    CustomerDto findById(String id);

    List<CustomerDto> getAll();
}
