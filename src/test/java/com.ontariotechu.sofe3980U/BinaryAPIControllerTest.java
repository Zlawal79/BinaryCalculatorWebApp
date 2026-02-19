package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddValid() throws Exception {
        mockMvc.perform(get("/add")
                .param("operand1", "10")
                .param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(content().string("101"));
    }

    @Test
    public void testAddInvalidInput() throws Exception {
        mockMvc.perform(get("/add")
                .param("operand1", "2")
                .param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(content().string("11"));
    }

    @Test
    public void testAddJson() throws Exception {
        mockMvc.perform(get("/add_json")
                .param("operand1", "1")
                .param("operand2", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operand1").value("1"))
                .andExpect(jsonPath("$.operand2").value("1"))
                .andExpect(jsonPath("$.result").value("10"));
    }

   

    @Test
    public void testMultiplyAPI() throws Exception {
        mockMvc.perform(get("/multiply")
                .param("operand1", "101")
                .param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(content().string("1111"));
    }

    @Test
    public void testAndAPI() throws Exception {
        mockMvc.perform(get("/and")
                .param("operand1", "1101")
                .param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(content().string("1001"));
    }

    @Test
    public void testOrAPI() throws Exception {
        mockMvc.perform(get("/or")
                .param("operand1", "1101")
                .param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(content().string("1111"));
    }
}
