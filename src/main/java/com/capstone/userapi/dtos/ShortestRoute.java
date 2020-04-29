/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author hoang
 */
@Entity
@Table(name = "Shortest_Route")
public class ShortestRoute implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
     @Column(name="start_node",length = 4000)
    private String start_node;
    @Column(name="end_node",length = 4000)
    private String end_node;
    @Column(name="meta_data",length = 4000)
    private String meta_data;
    @Column(name="qlearning_data",length = 4000)
    private String qlearning_data;
    @JsonIgnoreProperties({"road", "password", "role", "trafficJam","sRoute","user","start_node","end_node","status","start_address","end_address","geometry","created_date"})
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sRoute")
    private Set<Edge> listMap;

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
   

    public String getMeta_data() {
        return meta_data;
    }

    public void setMeta_data(String meta_data) {
        this.meta_data = meta_data;
    }

    public String getQlearning_data() {
        return qlearning_data;
    }

    public void setQlearning_data(String qlearning_data) {
        this.qlearning_data = qlearning_data;
    }

    public Set<Edge> getListMap() {
        return listMap;
    }

    public void setListMap(Set<Edge> listMap) {
        this.listMap = listMap;
    }

  
   

 

}
