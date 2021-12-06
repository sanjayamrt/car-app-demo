package com.example.car.app.demo.carappdemo;

import com.example.car.app.demo.carappdemo.controller.CarController;
import com.example.car.app.demo.carappdemo.dto.CarRequestDTO;
import com.example.car.app.demo.carappdemo.dto.CarResponseDTO;
import com.example.car.app.demo.carappdemo.exception.CarNotFoundException;
import com.example.car.app.demo.carappdemo.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.*;

@WebMvcTest(CarController.class)
class CarAppDemoApplicationTests {

    private static final String MAKE = "Toyota";

    private static final String MODEL = "Axio";

    private static final int YEAR = 2007;

    private static final long ID = 1l;

    private static final String COLOR = "White";

    private static final String MODEL_DESCRIPTION = "";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CarService carService;

    @Test
    public void addNewCarToTheDatabaseSucessfully() throws Exception {

        CarResponseDTO carResponseDTO = new CarResponseDTO(ID, MAKE, MODEL, YEAR, COLOR);


        CarRequestDTO carRequestDTO = new CarRequestDTO(MAKE, MODEL, YEAR,COLOR);

        ObjectMapper objectMapper = new ObjectMapper();

        String requestJson = objectMapper.writeValueAsString(carRequestDTO);

        Mockito.when(carService.addNewCar(Mockito.eq(carRequestDTO)))
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

        CarRequestDTO carRequestDTO = new CarRequestDTO(null, MODEL, YEAR,COLOR);

        ObjectMapper objectMapper = new ObjectMapper();

        String requestJson = objectMapper.writeValueAsString(carRequestDTO);

        MvcResult result = mockMvc.perform(post("/cars")
                        .content(requestJson).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isBadRequest())
                .andReturn();
        String resultJson = result.getResponse().getContentAsString();

        assertThat(resultJson).contains("make' is a mandatory parameter");
    }

    @Test
    public void testGetCarDetailsWithIdRegisteredWithTheApplication() throws Exception {

        CarResponseDTO carResponseDTO = new CarResponseDTO(ID, MAKE, MODEL, YEAR, COLOR);

        when(carService.getCarDetails(eq(1l)))
                .thenReturn(carResponseDTO);

        MvcResult result = mockMvc.perform(get("/cars/" + ID)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();

        String resultJson = result.getResponse().getContentAsString();

        String jsonDto = objectMapper.writeValueAsString(carResponseDTO);

        assertThat(resultJson).isEqualToIgnoringWhitespace(jsonDto);

    }

    @Test
    public void testGetCarDetailsWithIdNotRegisteredWithTheApplication() throws Exception {

        CarResponseDTO carResponseDTO = new CarResponseDTO(ID, MAKE, MODEL, YEAR, COLOR);

        when(carService.getCarDetails(eq(ID)))
                .thenThrow(new CarNotFoundException(ID));

        MvcResult result = mockMvc.perform(get("/cars/" + ID).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isNotFound())
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();

        String resultJson = result.getResponse().getContentAsString();

        assertThat(resultJson).contains("Could not found car with specified ID : " + ID);

    }

    @Test
    public void testDeleteCarWithIdRegisteredWithTheApplication() throws Exception {

        Mockito.doNothing().when(carService).delete(ID);

        MvcResult result = mockMvc.perform(delete("/cars/" + ID).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testDeleteCarWithIdNOTRegisteredWithTheApplication() throws Exception {

        Mockito.doThrow(new EmptyResultDataAccessException(1)).when(carService).delete(ID);

        MvcResult result = mockMvc.perform(delete("/cars/" + ID).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isNotFound())
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();

        String resultJson = result.getResponse().getContentAsString();

        assertThat(resultJson).contains("Incorrect result size: expected 1, actual 0");
    }




}