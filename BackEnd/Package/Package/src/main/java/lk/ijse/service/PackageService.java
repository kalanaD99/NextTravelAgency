package lk.ijse.service;


import lk.ijse.dto.PackageDTO;

import java.util.List;

public interface PackageService {
    void savePackage(PackageDTO packageDTO);

    void updatePackage(PackageDTO packageDTO);

    void deletePackage(String id);

    PackageDTO findById(String id);

    List<PackageDTO> getAll();
}
