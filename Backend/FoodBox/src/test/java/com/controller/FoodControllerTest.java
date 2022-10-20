package com.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.bean.Food;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.FoodService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {FoodController.class})
@ExtendWith(SpringExtension.class)
class FoodControllerTest {
    @Autowired
    private FoodController foodController;

    @MockBean
    private FoodService foodService;

   
    @Test
    void testGetAllFood() throws Exception {
        when(foodService.getAllFood()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/food/findAllFood");
        MockMvcBuilders.standaloneSetup(foodController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

   
  
    @Test
    void testUpdateFood() throws Exception {
        when(foodService.updateFood((Food) any())).thenReturn("2020-03-01");

        Food food = new Food();
        food.setDescription("The characteristics of someone or something");
        food.setFid(1);
        food.setId(1);
        food.setName("Name");
        food.setOffer(1);
        food.setPrice(10.0f);
        food.setUrl("https://example.org/example");
        String content = (new ObjectMapper()).writeValueAsString(food);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/food/updateFood")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("2020-03-01"));
    }

   
    @Test
    void testFindFoodByCuisine() throws Exception {
        when(foodService.findFoodByCuisine((Integer) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/food/findFoodByCuisine/{fid}", 1);
        MockMvcBuilders.standaloneSetup(foodController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

   
  

   
    @Test
    void testDeleteFoodUsingCuisine() throws Exception {
        when(foodService.deleteFoodByCuisine(anyInt())).thenReturn("Delete Food By Cuisine");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/food/deleteFoodByCuisine/{fid}",
                1);
        MockMvcBuilders.standaloneSetup(foodController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete Food By Cuisine"));
    }

    
    
   
    @Test
    void testDeleteFoodUsingId() throws Exception {
        when(foodService.deleteFood(anyInt())).thenReturn("Delete Food");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/food/deleteFood/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete Food"));
    }

    
   

    
    @Test
    void testFindFoodByName() throws Exception {
        when(foodService.findFoodName((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/food/findFoodByName/{name}", "Name");
        MockMvcBuilders.standaloneSetup(foodController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

   
   

    
    @Test
    void testHello() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/food/");
        MockMvcBuilders.standaloneSetup(foodController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("hi"));
    }

   
  
    @Test
    void testStoreProduct() throws Exception {
        when(foodService.storeFood((Food) any())).thenReturn("Store Food");

        Food food = new Food();
        food.setDescription("The characteristics of someone or something");
        food.setFid(1);
        food.setId(1);
        food.setName("Name");
        food.setOffer(1);
        food.setPrice(10.0f);
        food.setUrl("https://example.org/example");
        String content = (new ObjectMapper()).writeValueAsString(food);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/food/storeFood")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Store Food"));
    }
}

