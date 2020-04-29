/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.controllers;

import com.capstone.userapi.dtos.Notification;
import com.capstone.userapi.dtos.TrafficJam;
import com.capstone.userapi.repositories.NotificationRepository;
import com.capstone.userapi.repositories.TrafficJamRepository;
import com.capstone.userapi.services.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping(value = "/utils")
public class NotificationController {

    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    TrafficJamRepository trafficJamRepository;

    @PostMapping(value = "/noti")
    public Notification CreateNoti(@RequestParam(value = "t_id", required = false) long t_id, @RequestBody Notification noti) throws ResourceNotFoundException {
        if (t_id != 0) {
            TrafficJam t = trafficJamRepository.getOne(t_id);
            if (t != null) {
                return trafficJamRepository.findById(t_id).map(tID -> {
                    noti.setTrafficJam(tID);
                    return notificationRepository.save(noti);
                }).orElseThrow(() -> new ResourceNotFoundException("traffic id not found"));
            }
        } else {
            return notificationRepository.save(noti);
        }
        return null;
    }

    @GetMapping(value = "/noti")
    public List<Notification> getAllNoti() {
        return notificationRepository.findAll();
    }

    @DeleteMapping(value = "/noti/{id}")
    public void getAllNoti(@PathVariable Long id) {
        notificationRepository.deleteById(id);
    }
}
