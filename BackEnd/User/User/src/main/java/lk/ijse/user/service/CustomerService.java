package lk.ijse.user.service;

import lk.ijse.user.dto.CustomerDto;
import lk.ijse.user.dto.UserDto;

import java.util.List;

public interface CustomerService {
    void saveCustomerr(CustomerDto customerDto);

    void updateCustomer(CustomerDto customerDto);

    void deleteCustomer(String id);

    UserDto findById(String id);

    List<UserDto> getAll();
}
