package com.github.melifaroo.learning.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long>{
    
}
