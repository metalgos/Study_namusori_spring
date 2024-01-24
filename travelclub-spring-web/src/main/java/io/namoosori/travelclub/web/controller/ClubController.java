package io.namoosori.travelclub.web.controller;

import io.namoosori.travelclub.web.service.ClubService;
import io.namoosori.travelclub.web.service.sdo.TravelClubCdo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClubController {

    private ClubService clubService;

    public ClubController(ClubService clubService){
        this.clubService = clubService;
    }

    @PostMapping("/club") //
    public String register(@RequestBody TravelClubCdo travelClubCdo){

        return clubService.registerClub(travelClubCdo);
    }
}
