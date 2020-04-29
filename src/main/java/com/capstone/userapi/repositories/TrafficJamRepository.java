/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.repositories;

import com.capstone.userapi.dtos.TrafficJam;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hoang
 */
public interface TrafficJamRepository extends JpaRepository<TrafficJam, Long> {
    @Query("select t from TrafficJam t where t.status = ?1")
    public List<TrafficJam> getTrafficByStatus(int status);
    
//    @Query("SELECT Case when COUNT(e)>0 then true else false end from TrafficJam e where e.start_node=?1 and e.end_node=?2")
//    public Boolean checkExistByUV(String u, String v);
//    
//    @Modifying
//    @Transactional
//    @Query("update TrafficJam p set p.status =?1,p.center_point=?2,p.gps=?3,p.status=?4,p.apply_time=?5,p.end_time=?6 where p.start_node=?7 and p.end_node=?8 ")
//    public int updateData(int level,String center_point,String gps,int status,Date apply_time,Date end_time, int u, int v);
}
