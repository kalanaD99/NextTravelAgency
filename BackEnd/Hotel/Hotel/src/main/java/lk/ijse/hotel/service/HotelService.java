package lk.ijse.hotel.service;

import lk.ijse.hotel.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    public void saveHotel(HotelDTO hotelDTO);

    public void updateHotel(HotelDTO hotelDTO);

    void deleteHotel(String id);

    HotelDTO findId(String id);

    List<HotelDTO>getAll();
}
