/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author hoang
 */
@Entity
@Table(name = "TrafficJam")
public class TrafficJam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "start_node", length = 4000)
    private String start_node;
    @Column(name = "end_node", length = 4000)
    private String end_node;
    @Column(name = "status")
    private int status;
    @Column(name = "apply_time")
    private Date apply_time;
    @Column(name = "end_time")
    private Date end_time;
    @JsonIgnore()
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "trafficJam")
    private Set<Edge> Map;
    @JsonIgnore()
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "trafficJam")
    private Set<Notification> Noti;
    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "id")
    @JsonIgnoreProperties({"road", "password", "role", "listMap"})
    private Users user;
    public TrafficJam() {
    }

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
  

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getApply_time() {
        return apply_time;
    }

    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
