/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.dtos;

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
@Table(name = "Notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "content", length = 4000)
    private String content;
    @Column(name = "receiver", length = 4000)
    private String receiver;
    @Column(name = "method", length = 4000)
    private String method;
    @Column(name = "type", length = 4000)
    private String type;
    @Column(name = "extra", length = 4000)
    private String extra;
    @Column(name = "created_date")
    private Date created_date;
    @ManyToOne
    @JoinColumn(name = "trafficID", referencedColumnName = "id")
    private TrafficJam trafficJam;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public TrafficJam getTrafficJam() {
        return trafficJam;
    }

    public void setTrafficJam(TrafficJam trafficJam) {
        this.trafficJam = trafficJam;
    }
    
    
}
