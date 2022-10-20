package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bean.Login;
import com.repository.LoginRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {LoginService.class})
@ExtendWith(SpringExtension.class)
class LoginServiceTest {
    @MockBean
    private LoginRepository loginRepository;

    @Autowired
    private LoginService loginService;

    
    @Test
    void testSignIn() {
        Login login = new Login();
        login.setAddress("42 Main St");
        login.setEmailid("jane.doe@example.org");
        login.setName("Name");
        login.setPassword("welcome");
        login.setPhno(1);
        login.setTypeOfUser("Type Of User");
        Optional<Login> ofResult = Optional.of(login);
        when(loginRepository.findById((String) any())).thenReturn(ofResult);

        Login login1 = new Login();
        login1.setAddress("42 Main St");
        login1.setEmailid("jane.doe@example.org");
        login1.setName("Name");
        login1.setPassword("welcome");
        login1.setPhno(1);
        login1.setTypeOfUser("Type Of User");
        assertEquals("Invalid details", loginService.signIn(login1));
        verify(loginRepository).findById((String) any());
    }

   
    @Test
    void testSignIn2() {
        Login login = mock(Login.class);
        when(login.getTypeOfUser()).thenReturn("foo");
        when(login.getPassword()).thenReturn("welcome");
        doNothing().when(login).setAddress((String) any());
        doNothing().when(login).setEmailid((String) any());
        doNothing().when(login).setName((String) any());
        doNothing().when(login).setPassword((String) any());
        doNothing().when(login).setPhno(anyInt());
        doNothing().when(login).setTypeOfUser((String) any());
        login.setAddress("42 Main St");
        login.setEmailid("jane.doe@example.org");
        login.setName("Name");
        login.setPassword("welcome");
        login.setPhno(1);
        login.setTypeOfUser("Type Of User");
        Optional<Login> ofResult = Optional.of(login);
        when(loginRepository.findById((String) any())).thenReturn(ofResult);

        Login login1 = new Login();
        login1.setAddress("42 Main St");
        login1.setEmailid("jane.doe@example.org");
        login1.setName("Name");
        login1.setPassword("welcome");
        login1.setPhno(1);
        login1.setTypeOfUser("Type Of User");
        assertEquals("Invalid details", loginService.signIn(login1));
        verify(loginRepository).findById((String) any());
        verify(login).getPassword();
        verify(login, atLeast(1)).getTypeOfUser();
        verify(login).setAddress((String) any());
        verify(login).setEmailid((String) any());
        verify(login).setName((String) any());
        verify(login).setPassword((String) any());
        verify(login).setPhno(anyInt());
        verify(login).setTypeOfUser((String) any());
    }

    
    @Test
    void testSignIn3() {
        Login login = mock(Login.class);
        when(login.getTypeOfUser()).thenReturn("Type Of User");
        when(login.getPassword()).thenReturn("foo");
        doNothing().when(login).setAddress((String) any());
        doNothing().when(login).setEmailid((String) any());
        doNothing().when(login).setName((String) any());
        doNothing().when(login).setPassword((String) any());
        doNothing().when(login).setPhno(anyInt());
        doNothing().when(login).setTypeOfUser((String) any());
        login.setAddress("42 Main St");
        login.setEmailid("jane.doe@example.org");
        login.setName("Name");
        login.setPassword("iloveyou");
        login.setPhno(1);
        login.setTypeOfUser("Type Of User");
        Optional<Login> ofResult = Optional.of(login);
        when(loginRepository.findById((String) any())).thenReturn(ofResult);

        Login login1 = new Login();
        login1.setAddress("42 Main St");
        login1.setEmailid("jane.doe@example.org");
        login1.setName("Name");
        login1.setPassword("welcome");
        login1.setPhno(1);
        login1.setTypeOfUser("Type Of User");
        assertEquals("InValid password", loginService.signIn(login1));
        verify(loginRepository).findById((String) any());
        verify(login).getPassword();
        verify(login).setAddress((String) any());
        verify(login).setEmailid((String) any());
        verify(login).setName((String) any());
        verify(login).setPassword((String) any());
        verify(login).setPhno(anyInt());
        verify(login).setTypeOfUser((String) any());
    }

   
    @Test
    void testSignIn4() {
        when(loginRepository.findById((String) any())).thenReturn(Optional.empty());
        Login login = mock(Login.class);
        when(login.getTypeOfUser()).thenReturn("Type Of User");
        when(login.getPassword()).thenReturn("iloveyou");
        doNothing().when(login).setAddress((String) any());
        doNothing().when(login).setEmailid((String) any());
        doNothing().when(login).setName((String) any());
        doNothing().when(login).setPassword((String) any());
        doNothing().when(login).setPhno(anyInt());
        doNothing().when(login).setTypeOfUser((String) any());
        login.setAddress("42 Main St");
        login.setEmailid("jane.doe@example.org");
        login.setName("Name");
        login.setPassword("welcome");
        login.setPhno(1);
        login.setTypeOfUser("Type Of User");

        Login login1 = new Login();
        login1.setAddress("42 Main St");
        login1.setEmailid("jane.doe@example.org");
        login1.setName("Name");
        login1.setPassword("welcome");
        login1.setPhno(1);
        login1.setTypeOfUser("Type Of User");
        assertEquals("InValid emailId", loginService.signIn(login1));
        verify(loginRepository).findById((String) any());
        verify(login).setAddress((String) any());
        verify(login).setEmailid((String) any());
        verify(login).setName((String) any());
        verify(login).setPassword((String) any());
        verify(login).setPhno(anyInt());
        verify(login).setTypeOfUser((String) any());
    }
}

