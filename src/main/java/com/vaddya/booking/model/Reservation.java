package com.vaddya.booking.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

@Entity
@Data
public class Reservation {

    public enum Status {
        PENDING,
        PAYMENT,
        CONFIRMED,
        CANCELLED
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "reservation_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "`from`")
    private Date from;

    @Column(name = "`to`")
    private Date to;

    @Column(columnDefinition = "money")
    @ColumnTransformer(read = "price::money::numeric", write = "?::numeric::money")
    private BigDecimal price;

    @Column(name = "is_paid")
    private Boolean isPaid;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Set<Guest> guests;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Set<Payment> payments;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Review review;
}