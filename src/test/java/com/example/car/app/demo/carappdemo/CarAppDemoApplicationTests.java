package com.example.car.app.demo.carappdemo;

import com.example.car.app.demo.carappdemo.controller.CarController;
import com.example.car.app.demo.carappdemo.dto.CarRequestDTO;
import com.example.car.app.demo.carappdemo.dto.CarResponseDTO;
import com.example.car.app.demo.carappdemo.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.*;

@WebMvcTest(CarController.class)
class CarAppDemoApplicationTests {

    private static final String make = "Toyota";

    private static final String model = "Axio";

    private static final int year = 2007;

    private static final long id = 1l;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CarService carService;

    @Test
    public void addNewCarToTheDatabaseSucessfully() throws Exception {

        CarResponseDTO carResponseDTO = new CarResponseDTO(id, make, model, year);

        CarRequestDTO carRequestDTO = new CarRequestDTO(make, model, year);

        ObjectMapper objectMapper = new ObjectMapper();

        String requestJson = objectMapper.writeValueAsString(carRequestDTO);

        Mockito.when(carService.addNewCar(Mockito.any(CarRequestDTO.class)))
                .thenReturn(carResponseDTO);

        MvcResult result = mockMvc.perform(post("/cars")
                        .content(requestJson).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        String resultJson = result.getResponse().getContentAsString();

        String jsonDto = objectMapper.writeValueAsString(carResponseDTO);

        assertThat(resultJson).isEqualToIgnoringWhitespace(jsonDto);

    }

    @Test
    public void testAddNewCarReturnErrorWhenMandatoryParameterMakeNotPresent() throws Exception {
        String model = "Axio";
        int year = 2007;
        long id = 1l;

        CarRequestDTO carRequestDTO = new CarRequestDTO(null, model, year);

        ObjectMapper objectMapper = new ObjectMapper();

        String requestJson = objectMapper.writeValueAsString(carRequestDTO);

        MvcResult result = mockMvc.perform(post("/cars")
                        .content(requestJson).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isBadRequest())
                .andReturn();
        String resultJson = result.getResponse().getContentAsString();

        assertThat(resultJson).contains("make' is a mandatory parameter");
    }

}
