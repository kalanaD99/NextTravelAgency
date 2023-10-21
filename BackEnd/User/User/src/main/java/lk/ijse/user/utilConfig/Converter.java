package lk.ijse.user.utilConfig;

import lk.ijse.user.dto.UserDto;
import lk.ijse.user.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Converter {
    @Autowired
    ModelMapper modelMapper;

    public UserEntity UserDtoToUserEntity(UserDto userDto){
        return modelMapper.map(userDto,UserEntity.class);
    }
    public UserDto userEntityToUserDto(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDto.class);
    }
    public List<UserDto>userEntityListToUserDtoList(List<UserEntity> list){
        return modelMapper.map(list, new TypeToken<UserDto>(){}.getType());
    }
}
