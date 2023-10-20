package lk.ijse.user.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.user.dto.UserDto;
import lk.ijse.user.entity.UserEntity;
import lk.ijse.user.repo.UserRepo;
import lk.ijse.user.service.UserService;
import lk.ijse.user.utilConfig.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserImpl implements UserService {
    @Autowired
    Converter converter;

    @Autowired
    UserRepo repo;

    @Override
    public void saveUser(UserDto userDto) {
        if (repo.existsById(userDto.getId())){
            throw new RuntimeException(userDto.getId()+"User already exists");
        }
        repo.save(converter.UserDtoToUserEntity(userDto));
    }

    @Override
    public void updateUser(UserDto userDto) {
        if(!repo.existsById(userDto.getId())){
            throw new RuntimeException(userDto.getId()+"User Does not exists");
        }
        repo.save(converter.UserDtoToUserEntity(userDto));
    }

    @Override
    public void deleteUser(String id) {
        if(!repo.existsById(id)){
            throw new RuntimeException(id+"User Does Not exists");
        }
        repo.deleteById(id);
    }

    @Override
    public UserDto findById(String id) {
        if (!repo.existsById(id))
            throw new RuntimeException(id+"User Does Not Exists");
        return converter.userEntityToUserDto(repo.findById(id).get());
    }

}
