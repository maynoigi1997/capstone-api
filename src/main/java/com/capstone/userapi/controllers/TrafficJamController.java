/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.controllers;

import com.capstone.userapi.dtos.TrafficJam;
import com.capstone.userapi.repositories.TrafficJamRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hoang
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/traffic")
public class TrafficJamController {

    @Autowired
    TrafficJamRepository trafficJamRepository;

    @GetMapping(value = "/roads")
    public List<TrafficJam> getAllTraffic(@RequestParam(value = "status", required = false) Integer status) {
        if (status != null) {
            return trafficJamRepository.getTrafficByStatus(status);
        } else {
            return trafficJamRepository.findAll();
        }
    }

    @PostMapping("/roads")
    TrafficJam createTraffic(@RequestBody TrafficJam trafficJam) {
        return trafficJamRepository.save(trafficJam);
    }

    @DeleteMapping("/roads/{id}")
    void deleteTraffic(@PathVariable Long id) {
        trafficJamRepository.deleteById(id);
    }

    @DeleteMapping("/roads")
    void deleteTrafficAll() {
        trafficJamRepository.deleteAll();
    }

    @PutMapping("/roads/{id}")
    TrafficJam updateUsers(@RequestBody TrafficJam newTraffic, @PathVariable Long id) {
        Optional<TrafficJam> u = trafficJamRepository.findById(id);
        u.get().setStatus(newTraffic.getStatus());
        return trafficJamRepository.save(u.get());
    }
}
