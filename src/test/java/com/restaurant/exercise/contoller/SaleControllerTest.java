package com.restaurant.exercise.contoller;


import com.restaurant.exercise.domain.request.SaleRequest;
import com.restaurant.exercise.domain.response.SaleResponse;
import com.restaurant.exercise.repository.model.Sale;
import com.restaurant.exercise.service.SaleService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class SaleControllerTest {

    @MockBean
    private SaleService saleService;

    @Autowired
    private SaleController saleController;

    @Test
    void newSale() throws Exception {
        LocalDate date = LocalDate.now();
        SaleRequest saleRequest = new SaleRequest();
        when(saleService.newSale(saleRequest)).thenReturn(new SaleResponse(new Sale("afernandez", 10000, date)));
        ResponseEntity<SaleResponse> result = saleController.newSale(saleRequest);
        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
        Assertions.assertEquals("afernandez", result.getBody().getSeller());
        Assertions.assertEquals(date, result.getBody().getDate());
        Assertions.assertEquals(10000, result.getBody().getPrice());
    }

    @Test
    void getSales()  throws Exception{
        LocalDate date = LocalDate.now();
        List<SaleResponse> list = new ArrayList<>();
        list.add(new SaleResponse(new Sale("afernandez", 10000, date)));
        when(saleService.getSales()).thenReturn(list);
        ResponseEntity<List<SaleResponse>> result = saleController.getSales();
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals("afernandez", result.getBody().get(0).getSeller());
        Assertions.assertEquals(date, result.getBody().get(0).getDate());
        Assertions.assertEquals(10000, result.getBody().get(0).getPrice());
    }
}
