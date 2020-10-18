package com.restaurant.exercise.contoller;

import com.restaurant.exercise.domain.request.SaleRequest;
import com.restaurant.exercise.domain.response.SaleResponse;
import com.restaurant.exercise.error.RestaurantException;
import com.restaurant.exercise.service.SaleService;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller sale of the restaurant
 */
@RestController
@RequestMapping("/sale")
public class SaleController {
    private SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    /**
     * add new sale
     *
     * @param saleRequest data sale
     * @return new sale
     */
    @PostMapping("/new")
    public ResponseEntity<SaleResponse> newSale(@Valid @RequestBody SaleRequest saleRequest)throws RestaurantException {
        return new ResponseEntity<>(saleService.newSale(saleRequest), HttpStatus.CREATED);
    }

    /**
     * get all day of sale of the restaurant
     *
     * @return list all day of sale
     */
    @GetMapping("/day")
    public ResponseEntity<List<SaleResponse>> getSales() throws RestaurantException {
        return new ResponseEntity<>(saleService.getSales(), HttpStatus.OK);
    }

}
