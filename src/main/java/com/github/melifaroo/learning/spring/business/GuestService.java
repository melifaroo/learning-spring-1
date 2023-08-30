package com.github.melifaroo.learning.spring.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.melifaroo.learning.spring.data.Guest;
import com.github.melifaroo.learning.spring.data.GuestRepository;

@Service
public class GuestService {
    
    private final GuestRepository guestRepository;

    public GuestService( GuestRepository guestRepository ) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuests() {            
        List<Guest> guests = new ArrayList<>();        
        guests = guestRepository.findAll();
        return guests;    
    }

}
