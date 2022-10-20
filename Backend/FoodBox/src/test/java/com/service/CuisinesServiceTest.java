package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bean.Cuisines;
import com.repository.CuisinesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CuisinesService.class})
@ExtendWith(SpringExtension.class)
class CuisinesServiceTest {
    @MockBean
    private CuisinesRepository cuisinesRepository;

    @Autowired
    private CuisinesService cuisinesService;

 
    @Test
    void testStoreCuisines() {
        Cuisines cuisines = new Cuisines();
        cuisines.setId(1);
        cuisines.setListOfFood(new ArrayList<>());
        cuisines.setName("Name");
        when(cuisinesRepository.save((Cuisines) any())).thenReturn(cuisines);

        Cuisines cuisines1 = new Cuisines();
        cuisines1.setId(1);
        cuisines1.setListOfFood(new ArrayList<>());
        cuisines1.setName("Name");
        assertEquals("cuisines added successfully", cuisinesService.storeCuisines(cuisines1));
        verify(cuisinesRepository).save((Cuisines) any());
    }

   
    @Test
    void testDeleteCuisines() {
        Cuisines cuisines = new Cuisines();
        cuisines.setId(1);
        cuisines.setListOfFood(new ArrayList<>());
        cuisines.setName("Name");
        Optional<Cuisines> ofResult = Optional.of(cuisines);
        doNothing().when(cuisinesRepository).delete((Cuisines) any());
        when(cuisinesRepository.findById((Integer) any())).thenReturn(ofResult);
        assertEquals("Cuisine deleted successfully", cuisinesService.deleteCuisines(1));
        verify(cuisinesRepository).findById((Integer) any());
        verify(cuisinesRepository).delete((Cuisines) any());
    }

    
   
    @Test
    void testFindAllCuisines() {
        ArrayList<Cuisines> cuisinesList = new ArrayList<>();
        when(cuisinesRepository.findAll()).thenReturn(cuisinesList);
        List<Cuisines> actualFindAllCuisinesResult = cuisinesService.findAllCuisines();
        assertSame(cuisinesList, actualFindAllCuisinesResult);
        assertTrue(actualFindAllCuisinesResult.isEmpty());
        verify(cuisinesRepository).findAll();
    }
}

