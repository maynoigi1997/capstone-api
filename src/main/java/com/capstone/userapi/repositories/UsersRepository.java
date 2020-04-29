/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.repositories;


import com.capstone.userapi.dtos.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hoang
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String username);
}
