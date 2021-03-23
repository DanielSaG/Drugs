package com.danielsg.drugs;

import com.danielsg.drugs.controller.DrugsController;
import com.danielsg.drugs.dto.DrugRequest;
import com.danielsg.drugs.service.DrugService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DrugsController.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class DrugsApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DrugService drugService;
    
    public static String asJsonString(Object obj){
        try{
            final ObjectMapper mapper= new ObjectMapper();
            final String jsonContent=mapper.writeValueAsString(obj);
            return jsonContent;
        }catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("test application")
    public void testCreate() throws Exception{
        System.out.println("test application");
        DrugRequest dReq=new DrugRequest();
        Mockito.when(drugService.createDrug(dReq)).thenReturn(2L);
        mockMvc.perform(MockMvcRequestBuilders.post("/drugs/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(dReq))
                ).andDo(print()).andExpect(status().isCreated());
    }

}
