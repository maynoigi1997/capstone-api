/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.controllers;

import com.capstone.userapi.dtos.Edge;
import com.capstone.userapi.repositories.PendingRoadRepository;
import com.capstone.userapi.repositories.ShortestRouteRepository;
import com.capstone.userapi.repositories.TrafficJamRepository;
import com.capstone.userapi.repositories.UsersRepository;
import com.capstone.userapi.services.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@RequestMapping(value = "/pending-road", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PendingRoadController {

    @Autowired
    PendingRoadRepository pendingRoadRepository;
    @Autowired
    UsersRepository userRepository;
    @Autowired
    TrafficJamRepository trafficJamRepository;
    @Autowired
    ShortestRouteRepository shortestRouteRepository;

//     @PreAuthorize("hasAuthority('ADMIN')")
//    @PostMapping("/roads")
//    Edge createRoad(@RequestBody Edge newRoad) {
//        return pendingRoadRepository.save(newRoad);
//    }
  
    @PostMapping("/roads/{id}")
    Edge createTrackingRoad(@PathVariable Long id, @RequestBody Edge tRoad) throws ResourceNotFoundException {
        return userRepository.findById(id).map(userid -> {
            tRoad.setUser(userid);
            return pendingRoadRepository.save(tRoad);
        }).orElseThrow(() -> new ResourceNotFoundException("User id not found"));
    }

    @GetMapping(value = "/roads")   
    public List<Edge> getAllRoads(@RequestParam(value = "status", required = false) Integer shareStatus) {       
        if (shareStatus != null) {
            return pendingRoadRepository.getRoadByShare(shareStatus);
        } else {
            return pendingRoadRepository.findAll();
        }
    }

    
    @DeleteMapping("/roads/{id}")
    void deleteRoads(@PathVariable Long id) {     
        pendingRoadRepository.deleteById(id);

    }  
    

   
    @PutMapping("/roads/{id}")
    Edge updateUsers(@RequestBody Edge newPendingRoad, @PathVariable Long id) {
        Optional<Edge> u = pendingRoadRepository.findById(id);
        u.get().setStatus(newPendingRoad.getStatus());
        u.get().setsRoute(newPendingRoad.getsRoute());
        u.get().setTrafficJam(newPendingRoad.getTrafficJam());
//         trafficJamRepository.findById(new).map(trafficID -> {
//                newPendingRoad.setTrafficJam(trafficID);
//                return pendingRoadRepository.save(newPendingRoad);
//            }).orElseThrow(() -> new ResourceNotFoundException("Traffic ID not found"));
        return pendingRoadRepository.save(u.get());
    }
}
