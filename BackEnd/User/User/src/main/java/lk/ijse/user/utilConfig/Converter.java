package lk.ijse.user.utilConfig;

import lk.ijse.user.dto.UserDto;
import lk.ijse.user.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    @Autowired
    ModelMapper modelMapper;

    public UserEntity UserDtoToUserEntity(UserDto userDto){
        return modelMapper.map(userDto,UserEntity.class);
    }
}
