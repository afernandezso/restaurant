package com.restaurant.exercise.componet;

import com.restaurant.exercise.domain.response.SaleResponse;
import com.restaurant.exercise.repository.hsql.SaleRepository;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * class jms mock
 */
@Component
public class JmsMock {
    private final Queue<LocalDate> jmsMock = new ArrayDeque<>();
    private SaleRepository saleRepository;

    @Autowired
    public void JmsMock(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    /**
     * @param date add jms
     */
    public void addJmdMock(LocalDate date) {
        jmsMock.add(date);
    }

    /**
     * pool jms mock
     */
    public List<SaleResponse> poolJmsMock() {
        jmsMock.poll();
        return getSales();
    }

    /**
     * getSaleDay jms mock
     * @return List SaleResponse
     */
    private List<SaleResponse> getSales() {
        return saleRepository.findAllByDate(LocalDate.now())
                .stream()
                .map(sale -> new SaleResponse(sale))
                .collect(Collectors.toList());
    }


}
