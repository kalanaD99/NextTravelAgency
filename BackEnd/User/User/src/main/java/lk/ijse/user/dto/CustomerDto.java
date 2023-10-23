package lk.ijse.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String CustomerId;
    private String Name;
    private String Email;
    private String Address;
    private String NIC;
    private String Username;
    private String Password;

}
