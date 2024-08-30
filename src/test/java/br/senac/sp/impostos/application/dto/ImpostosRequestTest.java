package br.senac.sp.impostos.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImpostosRequestTest {

    @Test
    void testConstructorAndGetSalarioBruto() {
        Double salarioBruto = 3000.0;
        ImpostosRequest request = new ImpostosRequest(salarioBruto);
        assertEquals(salarioBruto, request.getSalarioBruto());
    }

    @Test
    void testSetSalarioBruto() {
        ImpostosRequest request = new ImpostosRequest(2000.0);
        Double newSalarioBruto = 4000.0;
        request.setSalarioBruto(newSalarioBruto);
        assertEquals(newSalarioBruto, request.getSalarioBruto());
    }

    @Test
    void testEquals() {
        ImpostosRequest request1 = new ImpostosRequest(3000.0);
        ImpostosRequest request2 = new ImpostosRequest(3000.0);
        ImpostosRequest request3 = new ImpostosRequest(4000.0);

        assertEquals(request1, request2); // Deve ser igual
        assertNotEquals(request1, request3); // Deve ser diferente
    }

    @Test
    void testHashCode() {
        ImpostosRequest request1 = new ImpostosRequest(3000.0);
        ImpostosRequest request2 = new ImpostosRequest(3000.0);

        assertEquals(request1.hashCode(), request2.hashCode()); // HashCode deve ser igual para objetos iguais
    }

    @Test
    void testNotEqualsDifferentClass() {
        ImpostosRequest request = new ImpostosRequest(3000.0);
        String differentClassObject = "Not an ImpostosRequest";

        assertNotEquals(request, differentClassObject); // Deve ser diferente pois é de uma classe diferente
    }

    @Test
    void testEqualsSameInstance() {
        ImpostosRequest request = new ImpostosRequest(3000.0);
        assertEquals(request, request); // Deve ser igual para a mesma instância
    }

    @Test
    void testEqualsNull() {
        ImpostosRequest request = new ImpostosRequest(3000.0);
        assertNotEquals(null, request); // Deve ser diferente de null
    }
}
