/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hoang
 */
@Entity
@Table(name = "Edge")
public class Edge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "start_node", length = 4000)
    private String start_node;
    @Column(name = "end_node", length = 4000)
    private String end_node;
    @Column(name = "start_address")
    private String start_address;
    @Column(name = "end_address")
    private String end_address;
    @Column(name = "status")
    private int status;
    @Column(name = "created_date")
    private Date created_date;
    @JsonIgnoreProperties({"road", "password", "role", "listMap"})
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private Users user;
    @Column(name = "geometry", length = 4000)
    private String geometry;
//    @JsonIgnoreProperties({"road", "password", "role", "listMap"})
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sRoute_id", referencedColumnName = "id")
    private ShortestRoute sRoute;
//    @JsonIgnoreProperties({"road", "password", "noti", "Edge"})
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "traffic_id", referencedColumnName = "id")
    private TrafficJam trafficJam;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart_node() {
        return start_node;
    }

    public void setStart_node(String start_node) {
        this.start_node = start_node;
    }

    public String getEnd_node() {
        return end_node;
    }

    public void setEnd_node(String end_node) {
        this.end_node = end_node;
    }

    public String getStart_address() {
        return start_address;
    }

    public void setStart_address(String start_address) {
        this.start_address = start_address;
    }

    public String getEnd_address() {
        return end_address;
    }

    public void setEnd_address(String end_address) {
        this.end_address = end_address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public ShortestRoute getsRoute() {
        return sRoute;
    }

    public void setsRoute(ShortestRoute sRoute) {
        this.sRoute = sRoute;
    }

    public TrafficJam getTrafficJam() {
        return trafficJam;
    }

    public void setTrafficJam(TrafficJam trafficJam) {
        this.trafficJam = trafficJam;
    }

}
