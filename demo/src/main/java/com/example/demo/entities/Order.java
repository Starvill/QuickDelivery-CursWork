package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "order")
public class Order {
    public Order(String name, String date, String addressFrom, String addressTo, String orderPhoneNumber, String type) {
        this.name = name;
        this.date = date;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.orderPhoneNumber = orderPhoneNumber;
        this.type = type;
    }
    public Order() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String date;
    private String addressFrom;
    private String addressTo;
    private String type;
    private String info;
    private String orderPhoneNumber;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
}
