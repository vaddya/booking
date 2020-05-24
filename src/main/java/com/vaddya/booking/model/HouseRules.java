package com.vaddya.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;

import lombok.Data;

@Entity
@Table(name = "house_rules")
@Data
public class HouseRules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "checkin_from")
    private Time checkinFrom;

    @Column(name = "checkout_until")
    private Time checkoutUntil;

    @Column(name = "cancellation_policy")
    private String cancellationPolicy;
}

