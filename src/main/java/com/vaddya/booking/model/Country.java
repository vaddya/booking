package com.vaddya.booking.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Country {

    @Id
    private String id;

    private String name;
}
