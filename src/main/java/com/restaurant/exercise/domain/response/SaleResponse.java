package com.restaurant.exercise.domain.response;

import com.restaurant.exercise.repository.model.Sale;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;

public class SaleResponse implements Serializable {

    private static final long serialVersionUID = -2212695041860915879L;
    @ApiModelProperty("auto-generated id of the sale")
    private int id;
    @ApiModelProperty("restaurant salesman")
    private String seller;
    @ApiModelProperty("price of a sale")
    private Integer price;
    @ApiModelProperty("Creation date")
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
