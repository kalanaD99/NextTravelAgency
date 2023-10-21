package lk.ijse.user.api;

import lk.ijse.user.dto.UserDto;
import lk.ijse.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/user")
public class UserApi {
@Autowired
UserService service;

    @PostMapping
    public ResponseEntity<String> SaveUser(@RequestBody UserDto userDto){
        service.saveUser(userDto);
        return new ResponseEntity<>(userDto.getId()+"User Saved !.", HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<String> UpdateUser(@RequestBody UserDto userDto){
        service.updateUser(userDto);
        return new ResponseEntity<>(userDto.getId()+"User Updated",HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String>deleteUser(String id){
        service.deleteUser(id);
        return new ResponseEntity<>(id+ "Deleted Successfully!",HttpStatus.OK);
    }
    @GetMapping(params = "id")
    public ResponseEntity<UserDto>findById(String id){
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<UserDto>>getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }
}
