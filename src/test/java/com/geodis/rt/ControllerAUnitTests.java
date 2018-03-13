package com.geodis.rt;

import com.geodis.rt.controller.ControllerA;
import com.geodis.rt.service.ServiceA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ControllerA.class)
public class ControllerAUnitTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceA serviceA;

    @Test
    public void test() throws Exception {
        doReturn("a").when(serviceA).getAString();
        mockMvc.perform(get("/a"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("aview"))
                .andExpect(content().string("a"));
    }
}
