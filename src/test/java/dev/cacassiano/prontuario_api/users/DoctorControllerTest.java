package dev.cacassiano.prontuario_api.users;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.cacassiano.prontuario_api.dtos.DoctorRequestDTO;
import dev.cacassiano.prontuario_api.dtos.DoctorResponseDTO;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DoctorControllerTest {
    @Autowired
    MockMvc mockMvc;
    private final String baseUrl= "/api/v1/doctors";
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("Can register the doctor sucefully")
    public void RegisterDoctorCase1() throws Exception{
        DoctorRequestDTO doctorReq = mapper.readValue(
            "{\"username\":\"testeDoctor\", \"password\": \"password123\", \"email\": \"testeDoctor@email.com\", \"crm\": \"1234\", \"specialtys\":[\"Fisioterapia\", \"Quiropraquicia\"]}",
            DoctorRequestDTO.class
        );
        MvcResult resp = this.mockMvc.perform(
            post(baseUrl+"/register")
                .contentType("application/json")
                .content(mapper.writeValueAsString(doctorReq))
        ).andDo(print())
        .andExpect(status().isCreated())
        .andExpect(content().contentType("application/json"))
        .andReturn();

        DoctorResponseDTO doctor = new DoctorResponseDTO(
            null,
            doctorReq.username(),
            doctorReq.email(),
            doctorReq.telephone(),
            doctorReq.crm(),
            doctorReq.specialtys()
        );
        DoctorResponseDTO responseDTO = mapper.readValue(resp.getResponse().getContentAsString(), DoctorResponseDTO.class);
        assertEquals(doctor.username(), responseDTO.username());
        assertEquals(doctor.email(), responseDTO.email());
        assertEquals(doctor.crm(), responseDTO.crm());
        assertArrayEquals(doctor.specialtys(), responseDTO.specialtys());
        assertEquals(doctor.telephone(), responseDTO.telephone());
        
    }

    @Test
    @DisplayName("Can't register the doctor sucefully - Missing info")
    public void RegisterDoctorCase2() throws Exception{
        // No username
        DoctorRequestDTO doctorReq = mapper.readValue(
            "{\"password\": \"password123\", \"email\": \"testeDoctor@email.com\", \"crm\": \"1234\", \"specialtys\":[\"Fisioterapia\", \"Quiropraquicia\"]}",
            DoctorRequestDTO.class
        );

        this.mockMvc.perform(
            post(baseUrl+"/register")
                .contentType("application/json")
                .content(mapper.writeValueAsString(doctorReq))
        ).andDo(print())
        .andExpect(status().isBadRequest());  
    }
}

