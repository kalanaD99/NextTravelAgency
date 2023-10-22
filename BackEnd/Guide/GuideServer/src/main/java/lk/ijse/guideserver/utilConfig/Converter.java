package lk.ijse.guideserver.utilConfig;

import lk.ijse.guideserver.dto.GuideDTO;
import lk.ijse.guideserver.entity.GuideEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Converter {
    @Autowired
    ModelMapper modelMapper;

    public GuideEntity guideDtoToGuideEntity(GuideDTO guideDTO){
      return modelMapper.map(guideDTO, GuideEntity.class);
    }
    public GuideDTO guideEntityToGuideDTO(GuideEntity guideEntity){
        return modelMapper.map(guideEntity, GuideDTO.class);
    }
    public List<GuideDTO> guideEntityListToGuideDtoList(List<GuideEntity> guideEntity){
        return modelMapper.map(guideEntity,new TypeToken<List<GuideDTO>>(){}.getType());
    }

}
