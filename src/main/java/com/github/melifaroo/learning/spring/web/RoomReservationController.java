package com.github.melifaroo.learning.spring.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.melifaroo.learning.spring.business.ReservationService;
import com.github.melifaroo.learning.spring.business.RoomReservation;
import com.github.melifaroo.learning.spring.util.DateUtils;

@Controller
@RequestMapping("/Reservations")
public class RoomReservationController {

    private final ReservationService reservationService;
    private final DateUtils dateUtils;
    
    public RoomReservationController(ReservationService reservationService, DateUtils dateUtils) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model){
        Date date = dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        return "roomres";
    }


}
