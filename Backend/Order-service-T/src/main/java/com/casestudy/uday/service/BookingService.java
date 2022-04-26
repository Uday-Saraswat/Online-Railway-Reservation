package com.casestudy.uday.service;
import java.util.List;
import java.util.Optional;

import com.casestudy.uday.model.BookingOrder;
import com.casestudy.uday.repository.BookingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingOrderRepository bookingOrderRepository;


    public BookingOrder addOrder (BookingOrder bookingOrder)	 {
        return bookingOrderRepository.save(bookingOrder);
    }

    public List<BookingOrder> getOrders() {
        List<BookingOrder> bookingOrders = bookingOrderRepository.findAll();
        System.out.println("Getting data from DB : " + bookingOrders);
        return bookingOrders;
    }

    public Optional<BookingOrder> getOrderbyId(String id) {
        return bookingOrderRepository.findById(id);
    }

    public void deleteOrder(BookingOrder bookingOrder) {
        bookingOrderRepository.delete(bookingOrder);
    }


}
