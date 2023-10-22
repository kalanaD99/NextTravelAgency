package lk.ijse.guideserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuideDTO {
    private String id;
    private String name;
    private String address;
    private String age;
    private String gender;
    private String number;
    private String images;
    private String guideNicImages;
    private String experience;
    private int manDayValue;

}
