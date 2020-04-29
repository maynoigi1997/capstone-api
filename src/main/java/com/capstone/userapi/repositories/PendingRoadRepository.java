/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.repositories;

import com.capstone.userapi.dtos.Edge;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author hoang
 */
public interface PendingRoadRepository extends JpaRepository<Edge, Long> {
    @Query("select p from Edge p where p.status = ?1")
    public List<Edge> getRoadByShare(int shareStatus);
    
   @Query("select p from Edge p ORDER by p.created_date ASC ")
    public List<Edge> getRoadOrderByDate();
}
