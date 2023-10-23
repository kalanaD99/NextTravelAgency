package lk.ijse.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.dto.BookDTO;
import lk.ijse.entity.BookEntity;
import lk.ijse.repo.BookRepo;
import lk.ijse.service.BookService;
import lk.ijse.utilConfig.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo repo;
    @Autowired
    Converter converter;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public void save(BookDTO bookDTO) {
        if(repo.existsById(bookDTO.getBookingId()))
            throw new RuntimeException(bookDTO.getBookingId()+"Id Already Exists");
        repo.save(converter.BookDtoToBookEntity(bookDTO));
    }

    @Override
    public void update(BookDTO bookDTO) {
        if (!repo.existsById(bookDTO.getBookingId()))
            throw new RuntimeException(bookDTO.getBookingId()+"Book Does not Exists");
        repo.save(converter.BookDtoToBookEntity(bookDTO));

    }

    @Override
    public void delete(String id) {
        if (!repo.existsById(id))
            throw new RuntimeException(id+"Book Does not exist");
        repo.deleteById(id);
    }

    @Override
    public BookDTO findId(String id) {
        if (!repo.existsById(id))
            throw new RuntimeException(id+"Cannot Find the Booking");
        return converter.BookEntityToBookDto(repo.findById(id).get());
    }

    @Override
    public List<BookDTO> findAll() {
        return converter.BookEntityListToBookDtoList(repo.findAll());
    }
}
