package com.github.melifaroo.learning.spring.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.melifaroo.learning.spring.business.ReservationService;
import com.github.melifaroo.learning.spring.data.Guest;

@Controller
@RequestMapping("/Guests")
public class GuestController {

    private final ReservationService reservationService;
    
    public GuestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations(Model model){
        List<Guest> guests = reservationService.getAllGuests();
        model.addAttribute("guests", guests);
        return "guests";
    }


}
