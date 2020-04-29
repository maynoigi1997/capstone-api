/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.repositories;

import com.capstone.userapi.dtos.ShortestRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hoang
 */
public interface ShortestRouteRepository extends JpaRepository<ShortestRoute, Long>{
    @Query("SELECT Case when COUNT(e)>0 then true else false end from ShortestRoute e where e.start_node=?1 and e.end_node=?2")
    public Boolean checkExistByUV(String u, String v);
    
    @Modifying
    @Transactional
    @Query("update ShortestRoute p set p.meta_data =?1,p.qlearning_data=?2 where p.start_node=?3 and p.end_node=?4 ")
    public int updateData(String meta_data,String qlearning_data,String u, String v);
}
