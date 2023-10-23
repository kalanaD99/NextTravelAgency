package lk.ijse.user.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.user.dto.CustomerDto;
import lk.ijse.user.dto.UserDto;
import lk.ijse.user.entity.CustomerEntity;
import lk.ijse.user.repo.CustomerRepo;
import lk.ijse.user.service.CustomerService;
import lk.ijse.user.utilConfig.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerImpl implements CustomerService {


    @Autowired
    CustomerRepo repo;

    @Autowired
    Converter converter;

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        if (repo.existsById(customerDto.getCustomerId())){
            throw new RuntimeException(customerDto.getCustomerId()+" Customer Already Exists..!");
        }
        repo.save(converter.customerDtoToCustomerEntity(customerDto));
    }
}

