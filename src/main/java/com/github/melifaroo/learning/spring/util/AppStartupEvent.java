package com.github.melifaroo.learning.spring.util;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.github.melifaroo.learning.spring.business.ReservationService;
import com.github.melifaroo.learning.spring.business.RoomReservation;
// import com.github.melifaroo.learning.spring.data.Guest;
// import com.github.melifaroo.learning.spring.data.GuestRepository;
// import com.github.melifaroo.learning.spring.data.Reservation;
// import com.github.melifaroo.learning.spring.data.ReservationRepository;
// import com.github.melifaroo.learning.spring.data.Room;
// import com.github.melifaroo.learning.spring.data.RoomRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{

    // private final RoomRepository roomRepository;
    // private final GuestRepository guestRepository;
    // private final ReservationRepository reservationRepository;

    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    // public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
    //     this.roomRepository = roomRepository;
    //     this.guestRepository = guestRepository;
    //     this.reservationRepository = reservationRepository;
    // }

    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // Iterable<Room> rooms = this.roomRepository.findAll();
        // rooms.forEach(System.out::println);
        // Iterable<Guest> guests = this.guestRepository.findAll();
        // guests.forEach(System.out::println);
        // Iterable<Reservation> reservations = this.reservationRepository.findAll();
        // reservations.forEach(System.out::println);

        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
        reservations.forEach(System.out::println);

    }
    
}
