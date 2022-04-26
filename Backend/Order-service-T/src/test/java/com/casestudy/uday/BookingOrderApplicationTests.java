package com.casestudy.uday;

import com.casestudy.uday.model.BookingOrder;
import com.casestudy.uday.repository.BookingOrderRepository;
import com.casestudy.uday.service.BookingService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ContextConfiguration
@RunWith(SpringRunner.class)
class BookingOrderApplicationTests {

    @Autowired
    private BookingService bookingService;

    @MockBean
    private BookingOrderRepository bookingOrderRepository;

    @Test
    public void getBookingOrderTest(){
        when(bookingOrderRepository.findAll()).thenReturn(Stream.of(new BookingOrder("87665542","Kalka","Chandigarh","3"),
                        new BookingOrder("1122332","New Delhi","Chandigarh","3"))
                .collect(Collectors.toList()));
        assertEquals(2,bookingService.getOrders().size());
    }

    @Test
    public void saveBookingOrderTest() {
        BookingOrder bookingOrder = new BookingOrder("123331","Howarh", "Kalka", "3");
        when(bookingOrderRepository.save(bookingOrder)).thenReturn(bookingOrder);
        assertEquals(bookingOrder, bookingService.addOrder(bookingOrder));

    }
    @Test
    public void deleteBookingOrderTest() {
        BookingOrder bookingOrder = new BookingOrder("6666666","AGC", "VGLB", "2");
        bookingService.deleteOrder(bookingOrder);
        verify(bookingOrderRepository, times(1)).delete(bookingOrder);
    }


}
