package lk.ijse.user.api;

import lk.ijse.user.dto.UserDto;
import lk.ijse.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
