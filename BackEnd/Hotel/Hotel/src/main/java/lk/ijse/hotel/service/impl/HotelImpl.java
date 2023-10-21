package lk.ijse.hotel.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.hotel.dto.HotelDTO;
import lk.ijse.hotel.repo.Repo;
import lk.ijse.hotel.service.HotelService;
import lk.ijse.hotel.utilConfig.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HotelImpl implements HotelService {
    @Autowired
    Repo repo;

    @Autowired
    Converter converter;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveHotel(HotelDTO hotelDTO) {
        if(repo.existsById(hotelDTO.getId()))
            throw new RuntimeException(hotelDTO.getId()+"Hotel Already Exists");
        repo.save(converter.hotelDtoToHotelEntity(hotelDTO));
    }

    @Override
    public void updateHotel(HotelDTO hotelDTO) {
        if (!repo.existsById(hotelDTO.getId()))
            throw new RuntimeException(hotelDTO.getId()+"Hotel does not Exists.!");
        repo.save(converter.hotelDtoToHotelEntity(hotelDTO));
    }

    @Override
    public void deleteHotel(String id) {
        if (!repo.existsById(id))
            throw new RuntimeException(id+"Hotel does not Exists");
    }

    @Override
    public HotelDTO findId(String id) {
       if(!repo.existsById(id))
           throw new RuntimeException(id+" Cannot find the Hotel");
      return converter.hotelEntityToHotelDto(repo.findById(id).get());
    }

    @Override
    public List<HotelDTO> getAll() {
        return converter.hotelEntityListToHotelDtoList(repo.findAll());
    }


}
