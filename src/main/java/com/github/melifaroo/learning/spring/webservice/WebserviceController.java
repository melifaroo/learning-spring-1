package com.github.melifaroo.learning.spring.webservice;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.melifaroo.learning.spring.business.ReservationService;
import com.github.melifaroo.learning.spring.business.RoomReservation;
import com.github.melifaroo.learning.spring.data.Guest;
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
        return reservationService.getRoomReservationsForDate(date);
    }

    //curl http://localhost:8080/api/guests 
    @GetMapping(path="/guests")
    public List<Guest> getAllGuests(){
        return reservationService.getAllGuests();
    }

    //curl -d "{\"firstName\":\"John\", \"lastName\":\"Doe\"}" -H "Content-Type: application/json" -X POST http://localhost:8080/api/guests
    @PostMapping(path="/guests")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addGuest( @RequestBody Guest guest ){
        reservationService.addGuest(guest);       
    }
}
