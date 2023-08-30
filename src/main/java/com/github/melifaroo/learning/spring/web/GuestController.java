package com.github.melifaroo.learning.spring.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.melifaroo.learning.spring.business.GuestService;
import com.github.melifaroo.learning.spring.data.Guest;

@Controller
@RequestMapping("/Guests")
public class GuestController {

    private final GuestService guestService;
    
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations(Model model){
        List<Guest> guests = guestService.getAllGuests();
        model.addAttribute("guests", guests);
        return "guests";
    }


}
