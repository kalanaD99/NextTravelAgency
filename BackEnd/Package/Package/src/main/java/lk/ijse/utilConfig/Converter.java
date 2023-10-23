package lk.ijse.utilConfig;


import lk.ijse.dto.BookDTO;
import lk.ijse.dto.PackageDTO;
import lk.ijse.entity.BookEntity;
import lk.ijse.entity.PackageEntity;
import org.modelmapper.ModelMapper;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Converter {

    @Autowired
    ModelMapper modelMapper;

    public PackageEntity PackageDtotoPackageEntity(PackageDTO packageDTO){
        return modelMapper.map(packageDTO, PackageEntity.class);
    }

    public PackageDTO packageEntityToPackageDto(PackageEntity aPackage){
        return modelMapper.map(aPackage, PackageDTO.class);
    }
    public List<PackageDTO> packageEntityListToPackageDTOList(List<PackageEntity> packages){
        return modelMapper.map(packages,new TypeToken<List<PackageDTO>>(){}.getType());
    }
    public BookEntity BookDtoToBookEntity(BookDTO bookDTO){
        return modelMapper.map(bookDTO, BookEntity.class);
    }

    public BookDTO BookEntityToBookDto(BookEntity bookEntity){
        return modelMapper.map(bookEntity, BookDTO.class);
    }
    public List<BookDTO> BookEntityListToBookDtoList(List<BookEntity> list){
        return modelMapper.map(list,new TypeToken<List<BookDTO>>(){}.getType());
    }


}
