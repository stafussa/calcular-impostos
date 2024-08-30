package br.senac.sp.impostos.application.usecase.impl;

import br.senac.sp.impostos.application.dto.ImpostosRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcularImpostosUseCaseImplTest {

    private CalcularImpostosUseCaseImpl calcularImpostosUseCase;

    @BeforeEach
    void setUp() {
        calcularImpostosUseCase = new CalcularImpostosUseCaseImpl();
    }

    @Test
    void calcularImpostos_salarioNaFaixaDe7_5PorCento() {
        ImpostosRequest request = new ImpostosRequest(2500.00);
        Double imposto = calcularImpostosUseCase.calcularImpostos(request);
        assertEquals(187.5, imposto, 0.001);
    }

    @Test
    void calcularImpostos_salarioNaFaixaDe15PorCento() {
        ImpostosRequest request = new ImpostosRequest(3000.00);
        Double imposto = calcularImpostosUseCase.calcularImpostos(request);
        assertEquals(450.0, imposto, 0.001);
    }

    @Test
    void calcularImpostos_salarioNaFaixaDe22_5PorCento() {
        ImpostosRequest request = new ImpostosRequest(4000.00);
        Double imposto = calcularImpostosUseCase.calcularImpostos(request);
        assertEquals(900.0, imposto, 0.001);
    }

    @Test
    void calcularImpostos_salarioNaFaixaDe27_5PorCento() {
        ImpostosRequest request = new ImpostosRequest(5000.00);
        Double imposto = calcularImpostosUseCase.calcularImpostos(request);
        assertEquals(1375.0, imposto, 0.001);
    }

    @Test
    void calcularImpostos_salarioNegativo() {
        ImpostosRequest request = new ImpostosRequest(-1000.00);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            calcularImpostosUseCase.calcularImpostos(request);
        });
        assertEquals("Salario nao pode ser negativo", exception.getMessage());
    }

    @Test
    void calcularImpostos_salarioForaDasFaixasDeImposto() {
        ImpostosRequest request = new ImpostosRequest(2000.00);
        Double imposto = calcularImpostosUseCase.calcularImpostos(request);
        assertEquals(0.0, imposto, 0.001);
    }
}
