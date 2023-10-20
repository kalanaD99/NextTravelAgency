package lk.ijse.service.impl;


import jakarta.transaction.Transactional;
import lk.ijse.dto.PackageDTO;
import lk.ijse.repo.PackageRepo;
import lk.ijse.service.PackageService;
import lk.ijse.utilConfig.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class PackageServiceIMPL implements PackageService {
    @Autowired
    Converter converter;

    @Autowired
    PackageRepo packageRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void savePackage(PackageDTO dto) {
        if (packageRepo.existsById(dto.getPackageId())){
            throw new RuntimeException(dto.getPackageId()+"package already Exists..!");
        }
       packageRepo.save(converter.PackageDtotoPackageEntity(dto));
    }

    @Override
    public void updatePackage(PackageDTO packageDTO) {
        if(!packageRepo.existsById(packageDTO.getPackageId())){
            throw new RuntimeException(packageDTO.getPackageId()+"Package is not in system");
        }
        packageRepo.save(converter.PackageDtotoPackageEntity(packageDTO));
    }

    @Override
    public PackageDTO findById(String id) {
        if (!packageRepo.existsById(id))
            throw new RuntimeException(id+"Package Not Found");
        return converter.packageEntityToPackageDto(packageRepo.findById(id).get());
    }

    @Override
    public List<PackageDTO> getAll()  {
        return converter.packageEntityListToPackageDTOList(packageRepo.findAll());
    }


    @Override
    public void deletePackage(String id) {
        if(!packageRepo.existsById(id)){
            throw new RuntimeException(id+"package does not exists");
        }
        packageRepo.deleteById(id);
    }



}

