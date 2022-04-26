package com.casestudy.uday.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.uday.model.BookingOrder;

public interface BookingOrderRepository extends MongoRepository<BookingOrder, String> {

	

}
