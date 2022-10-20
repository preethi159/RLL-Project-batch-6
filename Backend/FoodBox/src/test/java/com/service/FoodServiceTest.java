package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bean.Food;
import com.repository.FoodRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FoodService.class})
@ExtendWith(SpringExtension.class)
class FoodServiceTest {
    @MockBean
    private FoodRepository foodRepository;

    @Autowired
    private FoodService foodService;

  
    @Test
    void testStoreFood() {
        Food food = new Food();
        food.setDescription("The characteristics of someone or something");
        food.setFid(1);
        food.setId(1);
        food.setName("Name");
        food.setOffer(1);
        food.setPrice(10.0f);
        food.setUrl("https://example.org/example");
        when(foodRepository.save((Food) any())).thenReturn(food);

        Food food1 = new Food();
        food1.setDescription("The characteristics of someone or something");
        food1.setFid(1);
        food1.setId(1);
        food1.setName("Name");
        food1.setOffer(1);
        food1.setPrice(10.0f);
        food1.setUrl("https://example.org/example");
        assertEquals("food added successfully", foodService.storeFood(food1));
        verify(foodRepository).save((Food) any());
    }

    @Test
    void testGetAllFood() {
        ArrayList<Food> foodList = new ArrayList<>();
        when(foodRepository.findAll()).thenReturn(foodList);
        List<Food> actualAllFood = foodService.getAllFood();
        assertSame(foodList, actualAllFood);
        assertTrue(actualAllFood.isEmpty());
        verify(foodRepository).findAll();
    }

   
    @Test
    void testFindFoodByCuisine() {
        ArrayList<Food> foodList = new ArrayList<>();
        when(foodRepository.findFoodByCusine((Integer) any())).thenReturn(foodList);
        List<Food> actualFindFoodByCuisineResult = foodService.findFoodByCuisine(1);
        assertSame(foodList, actualFindFoodByCuisineResult);
        assertTrue(actualFindFoodByCuisineResult.isEmpty());
        verify(foodRepository).findFoodByCusine((Integer) any());
    }

    @Test
    void testFindFoodName() {
        ArrayList<Food> foodList = new ArrayList<>();
        when(foodRepository.findFoodByName((String) any())).thenReturn(foodList);
        List<Food> actualFindFoodNameResult = foodService.findFoodName("Name");
        assertSame(foodList, actualFindFoodNameResult);
        assertTrue(actualFindFoodNameResult.isEmpty());
        verify(foodRepository).findFoodByName((String) any());
    }

  
    @Test
    void testUpdateFood() {
        Food food = new Food();
        food.setDescription("The characteristics of someone or something");
        food.setFid(1);
        food.setId(1);
        food.setName("Name");
        food.setOffer(1);
        food.setPrice(10.0f);
        food.setUrl("https://example.org/example");
        Optional<Food> ofResult = Optional.of(food);

        Food food1 = new Food();
        food1.setDescription("The characteristics of someone or something");
        food1.setFid(1);
        food1.setId(1);
        food1.setName("Name");
        food1.setOffer(1);
        food1.setPrice(10.0f);
        food1.setUrl("https://example.org/example");
        when(foodRepository.saveAndFlush((Food) any())).thenReturn(food1);
        when(foodRepository.findById((Integer) any())).thenReturn(ofResult);

        Food food2 = new Food();
        food2.setDescription("The characteristics of someone or something");
        food2.setFid(1);
        food2.setId(1);
        food2.setName("Name");
        food2.setOffer(1);
        food2.setPrice(10.0f);
        food2.setUrl("https://example.org/example");
        assertEquals("Food details updated successfully", foodService.updateFood(food2));
        verify(foodRepository).saveAndFlush((Food) any());
        verify(foodRepository).findById((Integer) any());
    }

    
   

    @Test
    void testDeleteFood() {
        Food food = new Food();
        food.setDescription("The characteristics of someone or something");
        food.setFid(1);
        food.setId(1);
        food.setName("Name");
        food.setOffer(1);
        food.setPrice(10.0f);
        food.setUrl("https://example.org/example");
        Optional<Food> ofResult = Optional.of(food);
        doNothing().when(foodRepository).delete((Food) any());
        when(foodRepository.findById((Integer) any())).thenReturn(ofResult);
        assertEquals("Food deleted successfully", foodService.deleteFood(1));
        verify(foodRepository).findById((Integer) any());
        verify(foodRepository).delete((Food) any());
    }

    
   

    @Test
    void testDeleteFoodByCuisine() {
        Food food = new Food();
        food.setDescription("The characteristics of someone or something");
        food.setFid(1);
        food.setId(1);
        food.setName("Name");
        food.setOffer(1);
        food.setPrice(10.0f);
        food.setUrl("https://example.org/example");
        Optional<Food> ofResult = Optional.of(food);
        doNothing().when(foodRepository).delete((Food) any());
        when(foodRepository.findById((Integer) any())).thenReturn(ofResult);
        assertEquals("Food deleted successfully", foodService.deleteFoodByCuisine(1));
        verify(foodRepository).findById((Integer) any());
        verify(foodRepository).delete((Food) any());
    }

   
}

