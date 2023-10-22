package lk.ijse.guideserver.service;

import lk.ijse.guideserver.dto.GuideDTO;

import java.util.List;

public interface GuideService {
    public void save(GuideDTO guideDTO);
    public void update(GuideDTO guideDTO);
    public void delete(String id);
    GuideDTO findId(String id);
    List<GuideDTO>getAll();

}
