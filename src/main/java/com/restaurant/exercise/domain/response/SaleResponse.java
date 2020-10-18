package com.restaurant.exercise.domain.response;

import com.restaurant.exercise.repository.model.Sale;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class SaleResponse implements Serializable {

    private static final long serialVersionUID = -2212695041860915879L;

    private int id;
    private String seller;
    private Integer price;
    private LocalDate date;

    public SaleResponse(Sale sale) {
        this.id = sale.getId();
        this.seller = sale.getSeller();
        this.price = sale.getPrice();
        this.date = sale.getDate();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
