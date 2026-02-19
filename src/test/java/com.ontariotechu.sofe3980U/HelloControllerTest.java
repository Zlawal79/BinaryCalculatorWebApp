package com.ontariotechu.sofe3980U; 
import org.junit.Test; 
import org.junit.runner.RunWith; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; 
import org.springframework.test.context.junit4.SpringRunner; 
import org.springframework.test.web.servlet.MockMvc; 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model; 
@RunWith(SpringRunner.class) 
@WebMvcTest(HelloController.class) 
public class HelloControllerTest { 
    @Autowired 
    private MockMvc mockMvc; 
    @Test 
    public void testHelloDefaultName() throws Exception { 
        mockMvc.perform(get("/hello")) 
                .andExpect(status().isOk()) 
                .andExpect(view().name("hello")) 
                .andExpect(model().attribute("name", "World")); 
    } 
} 
