package com.restaurant.exercise.domain.request;
import java.io.Serializable;

public class SaleRequest implements Serializable {

    private static final long serialVersionUID = -2212695041860915879L;

    private String seller;
    private Integer price;

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
}
