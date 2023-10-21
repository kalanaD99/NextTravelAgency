package lk.ijse.hotel.utilConfig;

import lk.ijse.hotel.dto.HotelDTO;
import lk.ijse.hotel.entity.HotelEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Converter {
    @Autowired
    ModelMapper modelMapper;

    public HotelEntity hotelDtoToHotelEntity(HotelDTO hotelDTO){
      return  modelMapper.map(hotelDTO, HotelEntity.class);
    }
    public HotelDTO hotelEntityToHotelDto(HotelEntity hotel){
        return modelMapper.map(hotel, HotelDTO.class);
    }
    public List<HotelDTO>hotelEntityListToHotelDtoList(List<HotelEntity> hotelEntity){
        return modelMapper.map(hotelEntity,new TypeToken<List<HotelDTO>>(){}.getType());
    }
}
