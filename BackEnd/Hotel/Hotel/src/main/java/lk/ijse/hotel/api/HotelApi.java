package lk.ijse.hotel.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class HotelApi {
    private String id;
    private String hotelName;
    private String location;
    private String coordinates;
    private String email;
    private String number1;
    private String number2;
    private String petStats;
    private int hotelFee;
    private String cancellationCriteria;

}
