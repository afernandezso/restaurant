package com.restaurant.exercise.domain.request;
import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class SaleRequest implements Serializable {

    private static final long serialVersionUID = -2212695041860915879L;
    @NotBlank(message = "seller is mandatory")
    private String seller;
    @Min(1)
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
