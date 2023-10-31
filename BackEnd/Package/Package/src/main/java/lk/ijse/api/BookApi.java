package lk.ijse.api;

import lk.ijse.dto.BookDTO;
import lk.ijse.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ api/v1/Booking")
public class BookApi {
    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<String>save(@RequestBody BookDTO bookDTO){
        bookService.save(bookDTO);
        return new ResponseEntity<>(bookDTO.getBookingId()+"Saved Successfully!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String>update(@RequestBody BookDTO bookDTO){
        bookService.update(bookDTO);
        return new ResponseEntity<>(bookDTO.getBookingId()+"Successfully Updated!",HttpStatus.OK);
    }
    @DeleteMapping(params = "id")
    public ResponseEntity<String>delete(String id){
        bookService.delete(id);
        return new ResponseEntity<>(id+"Successfully Deleted",HttpStatus.OK);
    }
    @GetMapping(params = "id")
    public ResponseEntity<BookDTO>findById(String id){
        return new ResponseEntity<>(bookService.findId(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<BookDTO>>getAll(){
        return new ResponseEntity<>(bookService.findAll(),HttpStatus.OK);
    }

}
