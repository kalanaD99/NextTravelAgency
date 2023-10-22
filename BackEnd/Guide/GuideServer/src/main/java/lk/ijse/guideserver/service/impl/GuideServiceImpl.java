package lk.ijse.guideserver.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.guideserver.dto.GuideDTO;
import lk.ijse.guideserver.entity.GuideEntity;
import lk.ijse.guideserver.repo.Repo;
import lk.ijse.guideserver.service.GuideService;
import lk.ijse.guideserver.utilConfig.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class GuideServiceImpl implements GuideService {
    @Autowired
    Repo repo;
    @Autowired
    Converter converter;

    @Override
    public void save(GuideDTO guideDTO) {
        if (repo.existsById(guideDTO.getId()))
            throw new RuntimeException(guideDTO.getId()+" Guide Does not exists");
        repo.save(converter.guideDtoToGuideEntity(guideDTO));

    }

    @Override
    public void update(GuideDTO guideDTO) {
        if (!repo.existsById(guideDTO.getId()))
            throw new RuntimeException(guideDTO.getId()+" Cannot Find The guide");
        repo.save(converter.guideDtoToGuideEntity(guideDTO));

    }

    @Override
    public void delete(String id) {
        if (!repo.existsById(id))
            throw new RuntimeException(id+" Cannot find the Guide!");
        repo.deleteById(id);
    }

    @Override
    public GuideDTO findId(String id) {
        if(!repo.existsById(id))
            throw new RuntimeException(id+ " Guide does not exists");
        return converter.guideEntityToGuideDTO(repo.findById(id).get());
    }

    @Override
    public List<GuideDTO> getAll() {
        return converter.guideEntityListToGuideDtoList(repo.findAll());
    }
}
