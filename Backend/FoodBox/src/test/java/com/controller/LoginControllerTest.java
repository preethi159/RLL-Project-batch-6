package com.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.bean.Login;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.LoginService;
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

@ContextConfiguration(classes = {LoginController.class})
@ExtendWith(SpringExtension.class)
class LoginControllerTest {
    @Autowired
    private LoginController loginController;

    @MockBean
    private LoginService loginService;

    @Test
    void testSignIn() throws Exception {
        when(loginService.signIn((Login) any())).thenReturn("Sign In");

        Login login = new Login();
        login.setAddress("42 Main St");
        login.setEmailid("jane.doe@example.org");
        login.setName("Name");
        login.setPassword("welcome");
        login.setPhno(1);
        login.setTypeOfUser("Type Of User");
        String content = (new ObjectMapper()).writeValueAsString(login);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/login/signIn")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Sign In"));
    }

  
    @Test
    void testSignUp() throws Exception {
        when(loginService.signUp((Login) any())).thenReturn("Sign Up");

        Login login = new Login();
        login.setAddress("42 Main St");
        login.setEmailid("jane.doe@example.org");
        login.setName("Name");
        login.setPassword("welcome");
        login.setPhno(1);
        login.setTypeOfUser("Type Of User");
        String content = (new ObjectMapper()).writeValueAsString(login);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/login/signUp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Sign Up"));
    }

    
    @Test
    void testUpdatepwd() throws Exception {
        when(loginService.updatepwd((Login) any())).thenReturn("2020-03-01");

        Login login = new Login();
        login.setAddress("42 Main St");
        login.setEmailid("jane.doe@example.org");
        login.setName("Name");
        login.setPassword("welcome");
        login.setPhno(1);
        login.setTypeOfUser("Type Of User");
        String content = (new ObjectMapper()).writeValueAsString(login);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/login/updatepwd")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("2020-03-01"));
    }

   
    @Test
    void testUpdateprofile() throws Exception {
        when(loginService.updateProfile((Login) any())).thenReturn("2020-03-01");

        Login login = new Login();
        login.setAddress("42 Main St");
        login.setEmailid("jane.doe@example.org");
        login.setName("Name");
        login.setPassword("welcome");
        login.setPhno(1);
        login.setTypeOfUser("Type Of User");
        String content = (new ObjectMapper()).writeValueAsString(login);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/login/updateprofile")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("2020-03-01"));
    }
}

