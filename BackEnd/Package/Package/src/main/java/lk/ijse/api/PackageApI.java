package lk.ijse.api;

import lk.ijse.dto.PackageDTO;
import lk.ijse.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/packageApi")
public class PackageApI {
    @Autowired
    PackageService packageService;

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String>savePackage(@RequestBody PackageDTO packageDTO){
//        packageService.savePackage(packageDTO);
//        return new ResponseEntity<>(packageDTO.getPackageId()+"Package saved !..", HttpStatus.OK);
//    }



    @PostMapping
    public ResponseEntity<String>savePackage(@RequestBody PackageDTO packageDTO){
        packageService.savePackage(packageDTO);
        return new ResponseEntity<>(packageDTO.getPackageId()+"Package Saved !",HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String>updatePackage(@RequestBody PackageDTO packageDTO){
        packageService.updatePackage(packageDTO);
        return new ResponseEntity<>(packageDTO.getPackageId()+"Successfully Updated !", HttpStatus.OK);
    }
    @DeleteMapping(params = "id")
    public ResponseEntity<String> deletePakage(String id){
        packageService.deletePackage(id);
        return new ResponseEntity<>(id+"Package Deleted !",HttpStatus.OK);
    }
    @GetMapping(params = "id")
    public ResponseEntity<PackageDTO>findById(String id){
      return new  ResponseEntity<>(packageService.findById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PackageDTO>>getAll(){
        return new ResponseEntity<>(packageService.getAll(),HttpStatus.OK);
    }



}
