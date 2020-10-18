package com.restaurant.exercise.service.impl;

import com.restaurant.exercise.componet.JmsMock;
import com.restaurant.exercise.domain.request.SaleRequest;
import com.restaurant.exercise.domain.response.SaleResponse;
import com.restaurant.exercise.error.RestaurantException;
import com.restaurant.exercise.repository.hsql.SaleRepository;
import com.restaurant.exercise.repository.model.Sale;
import com.restaurant.exercise.service.SaleService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final JmsMock jmsMock;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, JmsMock jmsMock) {
        this.saleRepository = saleRepository;
        this.jmsMock = jmsMock;
    }

    @Override
    public SaleResponse newSale(SaleRequest saleRequest) throws RestaurantException {
        try {
            return new SaleResponse(saleRepository.save(getSale(saleRequest)));
        } catch (Exception err) {
            throw new RestaurantException("error", err);
        }
    }

    @Override
    public List<SaleResponse> getSales() throws RestaurantException {
        try {
        jmsMock.addJmdMock(LocalDate.now());
        return jmsMock.poolJmsMock();
        } catch (Exception err) {
            throw new RestaurantException("error", err);
        }
    }

    private Sale getSale(SaleRequest saleRequest) {
        return new Sale(saleRequest.getSeller(), saleRequest.getPrice(), LocalDate.now());
    }
}
