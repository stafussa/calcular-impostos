package br.senac.sp.impostos.presentation.rest;

import br.senac.sp.impostos.application.dto.ImpostosRequest;
import br.senac.sp.impostos.application.service.CalcularImpostosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ImpostosController.class)
class ImpostosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalcularImpostosService calcularImpostosService;

    @BeforeEach
    void setUp() {
        // Configura o comportamento do serviço mockado
        when(calcularImpostosService.calcularImpostos(any(ImpostosRequest.class))).thenReturn(450.1234);
    }

    @Test
    void calcularImpostos_deveRetornarImpostoCalculadoArredondado() throws Exception {
        // Dados de entrada em JSON
        String requestJson = "{\"salarioBruto\":3000.00}";

        // Execução da requisição POST
        ResultActions resultActions = mockMvc.perform(post("/api/impostos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson));

        // Verificações
        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(450.12))); // Verifica o valor arredondado para 2 casas decimais
    }
}
