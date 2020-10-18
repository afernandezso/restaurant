package com.restaurant.exercise.service.impl;

import com.restaurant.exercise.componet.JmsMock;
import com.restaurant.exercise.domain.request.SaleRequest;
import com.restaurant.exercise.domain.response.SaleResponse;
import com.restaurant.exercise.error.RestaurantException;
import com.restaurant.exercise.repository.hsql.SaleRepository;
import com.restaurant.exercise.repository.model.Sale;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class SaleServiceImplTest {

    @Autowired
    private SaleServiceImpl saleService;

    @MockBean
    private SaleRepository saleRepository;

    @MockBean
    private JmsMock jmsMock;

    private static Sale sale = new Sale("afernandez", 10000,  LocalDate.now());
    @Test
    void newSale() throws Exception {

        when(saleRepository.save(any(Sale.class))).thenReturn(sale);
        SaleResponse response = saleService.newSale(new SaleRequest());
        Assertions.assertEquals("afernandez", response.getSeller());
        Assertions.assertEquals(LocalDate.now(), response.getDate());
        Assertions.assertEquals(10000, response.getPrice());
    }

    @Test
    void newSaleError() {
        reset(saleRepository);
        Throwable exception = assertThrows(RestaurantException.class, () -> saleService.newSale(new SaleRequest()));
        Assertions.assertEquals("error", exception.getMessage());

    }

    @Test
    void getSales() throws RestaurantException {
        List<SaleResponse> list = new ArrayList<>();
        list.add(new SaleResponse(sale));
        doNothing().when(jmsMock).addJmdMock(any(LocalDate.class));
        when(jmsMock.poolJmsMock()).thenReturn(list);

        List<SaleResponse> responseList = saleService.getSales();

        Assertions.assertEquals(1,responseList.size());
        Assertions.assertEquals(LocalDate.now(), responseList.get(0).getDate());
        Assertions.assertEquals(10000, responseList.get(0).getPrice());
        Assertions.assertEquals("afernandez", responseList.get(0).getSeller());
    }

    @Test
    void getSalesError() throws RestaurantException {
        List<SaleResponse> list = new ArrayList<>();
        list.add(new SaleResponse(sale));
        doThrow(new RuntimeException()).when(jmsMock).addJmdMock(any(LocalDate.class));
        when(jmsMock.poolJmsMock()).thenReturn(list);
        assertThrows(RestaurantException.class, () ->  saleService.getSales());
    }
}
