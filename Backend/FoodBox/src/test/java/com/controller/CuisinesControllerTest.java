package com.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.bean.Cuisines;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.CuisinesService;

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

@ContextConfiguration(classes = {CuisinesController.class})
@ExtendWith(SpringExtension.class)
class CuisinesControllerTest {
    @Autowired
    private CuisinesController cuisinesController;

    @MockBean
    private CuisinesService cuisinesService;

    
    @Test
    void testDeleteCuisineUsingId() throws Exception {
        when(cuisinesService.deleteCuisines(anyInt())).thenReturn("Delete Cuisines");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/cuisines/deleteCuisine/{id}", 1);
        MockMvcBuilders.standaloneSetup(cuisinesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete Cuisines"));
    }

   
    @Test
    void testFindAllCuisines() throws Exception {
        when(cuisinesService.findAllCuisines()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cuisines/findAllCuisines");
        MockMvcBuilders.standaloneSetup(cuisinesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

  
   
    @Test
    void testStoreProduct() throws Exception {
        when(cuisinesService.storeCuisines((Cuisines) any())).thenReturn("Store Cuisines");

        Cuisines cuisines = new Cuisines();
        cuisines.setId(1);
        cuisines.setListOfFood(new ArrayList<>());
        cuisines.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(cuisines);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/cuisines/storeCuisines")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(cuisinesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Store Cuisines"));
    }
}

