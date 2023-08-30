package com.github.melifaroo.learning.spring.webservice;

import java.util.Date;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.melifaroo.learning.spring.business.ReservationService;
import com.github.melifaroo.learning.spring.business.RoomReservation;
import com.github.melifaroo.learning.spring.util.DateUtils;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    
    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    public WebserviceController(ReservationService reservationService, DateUtils dateUtils) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }
    
    @RequestMapping(path="/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String dateString){
        Date date = dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = reservationService.getRoomReservationsForDate(date);        
        return roomReservations;
    }

}
