package lk.ijse.service;

import lk.ijse.dto.BookDTO;

import java.util.List;

public interface BookService {
    public void save(BookDTO bookDTO);
    public void update(BookDTO bookDTO);
    public void delete(String id);
    BookDTO findId(String id);
    List<BookDTO> findAll();
}
