package br.senac.sp.impostos.application.service.impl;

import br.senac.sp.impostos.application.dto.ImpostosRequest;
import br.senac.sp.impostos.application.usecase.CalcularImpostosUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CalcularImpostosServiceImplTest {

    private CalcularImpostosUseCase calcularImpostosUseCase;
    private CalcularImpostosServiceImpl calcularImpostosService;

    @BeforeEach
    void setUp() {
        calcularImpostosUseCase = Mockito.mock(CalcularImpostosUseCase.class);
        calcularImpostosService = new CalcularImpostosServiceImpl(calcularImpostosUseCase);
    }

    @Test
    void calcularImpostos_deveDelegarParaUseCase() {
        ImpostosRequest request = new ImpostosRequest(3000.0);
        Double expectedImposto = 450.0;

        // Configurando o mock para retornar um valor específico
        when(calcularImpostosUseCase.calcularImpostos(any(ImpostosRequest.class))).thenReturn(expectedImposto);

        // Chamando o método real
        Double actualImposto = calcularImpostosService.calcularImpostos(request);

        // Verificando se o resultado é o esperado
        assertEquals(expectedImposto, actualImposto);

        // Verificando se o método do mock foi chamado exatamente uma vez com os argumentos corretos
        verify(calcularImpostosUseCase, times(1)).calcularImpostos(request);
    }

    @Test
    void calcularImpostos_deveRetornarValorCorreto() {
        ImpostosRequest request = new ImpostosRequest(4000.0);
        Double expectedImposto = 900.0;

        when(calcularImpostosUseCase.calcularImpostos(request)).thenReturn(expectedImposto);

        Double actualImposto = calcularImpostosService.calcularImpostos(request);

        assertEquals(expectedImposto, actualImposto);
    }
}
