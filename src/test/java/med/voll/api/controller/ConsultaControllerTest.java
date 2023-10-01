package med.voll.api.controller;


import med.voll.api.domain.DTO.DadosAgendamentoConsultaDTO;
import med.voll.api.domain.DTO.DadosDetalhamentoConsultaDTO;
import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.medico.Especialidade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosAgendamentoConsultaDTO> consultaJson;

    @MockBean
    ConsultaController consultaBean = mock(ConsultaController.class);


    @Autowired
    private JacksonTester<DadosDetalhamentoConsultaDTO> consultaRetornoJson;

    @Test
    @DisplayName("Deveria devolver código http 400 quando informações estão inválidas")
    @WithMockUser
    void agendarCenario1() throws Exception {
        var response =  mvc.perform(post("/consultas")).andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());

    }

   /* @Test
    @DisplayName("Deveria devolver código http 200 quando informações estão válidas")
    @WithMockUser
    void agendar_cenario2() throws Exception {
        var data = LocalDateTime.now().plusHours(1);
        var especialidade = Especialidade.CARDIOLOGIA;

        var retorno = new DadosDetalhamentoConsultaDTO(null, 2L, 5L, data);
        when(consultaBean.agendar(any())).thenReturn(retorno);
        var response = mvc
                .perform(
                        post("/consultas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(consultaJson.write(new DadosAgendamentoConsultaDTO(null,2L, 5L, data, especialidade))
                                        .getJson())).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonEsperado = consultaRetornoJson.write(retorno).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }*/
}