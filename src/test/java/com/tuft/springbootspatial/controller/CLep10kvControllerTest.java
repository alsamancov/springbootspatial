package com.tuft.springbootspatial.controller;

import com.tuft.springbootspatial.SpringbootspatialApplication;
import com.tuft.springbootspatial.entity.CLep10kv;
import com.tuft.springbootspatial.entity.RoughData;
import com.tuft.springbootspatial.service.CLep10kvService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootspatialApplication.class)
@WebAppConfiguration
public class CLep10kvControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private List<CLep10kv> list;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CLep10kvService cLep10kvService;

    @Before
    public void setup(){
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        list = cLep10kvService.getAll();
    }

    @Test
    public void readAllData() throws Exception{
        mockMvc.perform(get("/clep10kv/all"))
                .andExpect(status().isOk());
    }

}