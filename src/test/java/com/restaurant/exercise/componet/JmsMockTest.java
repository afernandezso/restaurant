package com.restaurant.exercise.componet;


import com.restaurant.exercise.domain.response.SaleResponse;
import com.restaurant.exercise.repository.hsql.SaleRepository;
import com.restaurant.exercise.repository.model.Sale;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class JmsMockTest {

    @Autowired
    private JmsMock jmsMock;

    @MockBean
    private SaleRepository saleRepository;

    @Test
    void poolJmsMockEmpty() {
        when(saleRepository.findAllByDate(any(LocalDate.class))).thenReturn(new ArrayList<>());
        assertTrue(jmsMock.poolJmsMock().isEmpty());
    }

    @Test
    void poolJmsMock() {
        List<Sale> list = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            list.add(new Sale("afernandez", 10000, LocalDate.now()));
        }
        when(saleRepository.findAllByDate(any(LocalDate.class))).thenReturn(list);
        List<SaleResponse> response = jmsMock.poolJmsMock();
        assertFalse(response.isEmpty());
        Assertions.assertEquals(5, response.size());
        Assertions.assertEquals("afernandez", response.get(0).getSeller());
        Assertions.assertEquals(LocalDate.now(), response.get(0).getDate());
        Assertions.assertEquals(10000, response.get(0).getPrice());
    }
}
