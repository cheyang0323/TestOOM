package com.oom.readapp.ReadApp.Controller;

import com.oom.readapp.ReadApp.Repository.Reservation;
import com.oom.readapp.ReadApp.Repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/read")
public class ReadController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Reservation> getAll() {
        return reservationRepository.findAll();
    }

}
