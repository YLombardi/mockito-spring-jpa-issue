package com.geodis.rt;

import com.geodis.rt.controller.ControllerB;
import com.geodis.rt.repo.JpaRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ControllerB.class)
public class ControllerBUnitTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JpaRepo jpaRepo;

    @Test
    public void test() throws Exception {
        doReturn("b").when(jpaRepo).findStringById(anyString());

        mockMvc.perform(get("/b"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("b"));
    }
}
