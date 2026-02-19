package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidAddition() throws Exception {
        mockMvc.perform(post("/")
                .param("operand1", "10")
                .param("operator", "+")
                .param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "101"));
    }

    @Test
    public void testInvalidOperator() throws Exception {
        mockMvc.perform(post("/")
                .param("operand1", "10")
                .param("operator", "%")
                .param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }

    @Test
    public void testEmptyOperand() throws Exception {
        mockMvc.perform(post("/")
                .param("operand1", "")
                .param("operator", "+")
                .param("operand2", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1"));
    }

   
    @Test
    public void testMultiplication() throws Exception {
        mockMvc.perform(post("/")
                .param("operand1", "10")
                .param("operator", "*")
                .param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "110"));
    }

    @Test
    public void testAndOperation() throws Exception {
        mockMvc.perform(post("/")
                .param("operand1", "1101")
                .param("operator", "&")
                .param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1001"));
    }

    @Test
    public void testOrOperation() throws Exception {
        mockMvc.perform(post("/")
                .param("operand1", "1101")
                .param("operator", "|")
                .param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1111"));
    }
}
