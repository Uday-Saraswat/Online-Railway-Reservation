package com.casestudy.uday.resources;


import java.util.Optional;

import com.casestudy.uday.model.BookingOrder;
import com.casestudy.uday.repository.BookingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class 	BookingOrderController {
	
	@Autowired
	private BookingOrderRepository bookrepository;

	@PostMapping("/addOrder")
	@CrossOrigin(origins = "http://localhost:3000")
	public String saveBook(@RequestBody BookingOrder book) {
	bookrepository.save(book);
	return "Booked ticket with id :  " + book.getId();
    }
	@GetMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public Optional<BookingOrder> getBook(@PathVariable String id){
		return bookrepository.findById(id);
	}
	@PutMapping("/update/{id}")
	public BookingOrder updateOrder(@PathVariable("id") String id,@RequestBody BookingOrder order ) {
		order.setId(id);
		bookrepository.save(order);
		return order;
	}
		
	 @DeleteMapping("/del/{id}")
	 @CrossOrigin(origins = "http://localhost:3000")

	 public String deleteOrder (@PathVariable String id) {
	  bookrepository.deleteById(id);
		return "Order deleted with id : "+id;
		}
	}

