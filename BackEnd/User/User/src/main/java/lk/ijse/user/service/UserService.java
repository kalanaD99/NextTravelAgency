package lk.ijse.user.service;

import lk.ijse.user.dto.UserDto;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void deleteUser(String id);

    UserDto findById(String id);
}
