package lk.ijse.guideserver.api;

import lk.ijse.guideserver.dto.GuideDTO;
import lk.ijse.guideserver.entity.GuideEntity;
import lk.ijse.guideserver.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guide")
public class GuideApi {
    @Autowired
    GuideService service;

    @PostMapping
    public ResponseEntity<String>save(@RequestBody GuideDTO guideDTO){
        service.save(guideDTO);
        return new ResponseEntity<>(guideDTO.getId(), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<String>update(@RequestBody GuideDTO guideDTO){
        service.update(guideDTO);
        return new ResponseEntity<>(guideDTO.getId(),HttpStatus.OK);
    }
    @DeleteMapping(params = "id")
    public ResponseEntity<String>delete(String id){
        service.delete(id);
        return new ResponseEntity<>(id+" Guide delete Successfully!",HttpStatus.OK);
    }
    @GetMapping(params = "id")
    public ResponseEntity<GuideDTO>findId(String id){
        return new ResponseEntity<>(service.findId(id),HttpStatus.OK);
    }

    @GetMapping
   public ResponseEntity<List<GuideDTO>>getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }
}
