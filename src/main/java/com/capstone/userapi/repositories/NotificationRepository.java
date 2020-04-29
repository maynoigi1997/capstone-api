/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.repositories;

import com.capstone.userapi.dtos.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hoang
 */
public interface NotificationRepository extends JpaRepository<Notification, Long>  {
    
}
