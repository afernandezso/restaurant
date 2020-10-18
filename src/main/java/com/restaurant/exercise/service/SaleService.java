package com.restaurant.exercise.service;

import com.restaurant.exercise.domain.request.SaleRequest;
import com.restaurant.exercise.domain.response.SaleResponse;
import com.restaurant.exercise.error.RestaurantException;
import java.util.List;

public interface SaleService {

    /**
     * add new sale
     * @param saleRequest data sale
     * @return new sale
     */
    SaleResponse newSale(SaleRequest saleRequest) throws RestaurantException;


    /**
     * get all day of sale of the restaurant
     * @return list all day of sale
     */
    List<SaleResponse> getSales() throws RestaurantException;
}
