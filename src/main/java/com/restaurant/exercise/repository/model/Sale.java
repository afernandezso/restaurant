package com.restaurant.exercise.repository.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Sale implements Serializable {

    private static final long serialVersionUID = 246251072460886478L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String seller;

    @NotNull
    private Integer price;

    @Column(columnDefinition = "DATE")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate date;

    public Sale() {
    }

    public Sale(String seller, Integer price, LocalDate date) {
        this.seller = seller;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getSeller() {
        return seller;
    }

    public Integer getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", seller='" + seller + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
