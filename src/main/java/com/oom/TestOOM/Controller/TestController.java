package com.oom.TestOOM.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.oom.TestOOM.Repository.ReservationRepository;
import com.oom.TestOOM.Repository.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/v1/oom")
public class TestController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/{name}")
    public String tryIt(@PathVariable String name) throws Exception {

        // update
        long[][] ary = new long[Integer.MAX_VALUE][Integer.MAX_VALUE];
        return "Hello, " + name + "\n";
    }

    @PostMapping("/reserve")
    public @ResponseBody String reserve(@RequestParam String name, @RequestParam String date,
            @RequestParam Boolean hasCard) {
        Reservation reservation = new Reservation();
        reservation.setName(name);
        reservation.setDate(date);
        reservation.setHasCard(hasCard);
        reservationRepository.save(reservation);
        return "done";
    }

    @GetMapping("/good")
    public String normal() {
        return "A good call...\n";
    }
}
