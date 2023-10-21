package lk.ijse.hotel.api;

import lk.ijse.hotel.dto.HotelDTO;
import lk.ijse.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelApi {
    @Autowired
    HotelService hotelService;

    @PostMapping
    public ResponseEntity<String>saveHotel(@RequestBody HotelDTO hotelDTO){
        hotelService.saveHotel(hotelDTO);
        return new ResponseEntity<>(hotelDTO.getId()+"Hotel saved successfully! ", HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<String>updateHotel(@RequestBody HotelDTO hotelDTO){
        hotelService.updateHotel(hotelDTO);
        return new ResponseEntity<>(hotelDTO.getId()+"Successfully Updated !",HttpStatus.OK);
    }
    @DeleteMapping(params = "id")
    public ResponseEntity<String>deleteHotel(String id){
        hotelService.deleteHotel(id);
        return new ResponseEntity<>(id+"  Hotel delete Successfully",HttpStatus.OK);
    }
    @GetMapping(params = "id")
    public ResponseEntity<HotelDTO>findById(String id){
        return new ResponseEntity<>(hotelService.findId(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<HotelDTO>>findAll(){
        return new ResponseEntity<>(hotelService.getAll(),HttpStatus.OK);
    }


}
