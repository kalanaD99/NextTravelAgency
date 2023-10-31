package lk.ijse.user.api;

import lk.ijse.user.dto.CustomerDto;
import lk.ijse.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    public ResponseEntity<String>updateCustomer(CustomerDto customerDto){
        customerService.updateCustomer(customerDto);
        return new ResponseEntity<>(customerDto.getCustomerId()+"Successfully Updated!",HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String>deleteCustomer(String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(id+"Successfully Deleted!",HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<CustomerDto>findById(String id){
        return new ResponseEntity<>(customerService.findById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>>findAll(){
        return new ResponseEntity<>(customerService.getAll(),HttpStatus.OK);
    }


}
