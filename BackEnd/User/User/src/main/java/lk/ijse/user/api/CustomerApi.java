package lk.ijse.user.api;

import lk.ijse.user.dto.CustomerDto;
import lk.ijse.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerApi {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<String>saveCustomer(CustomerDto customerDto){
        customerService.saveCustomer(customerDto);
        return new ResponseEntity<>(customerDto.getCustomerId()+" Customer Saved!", HttpStatus.OK);
    }
}
