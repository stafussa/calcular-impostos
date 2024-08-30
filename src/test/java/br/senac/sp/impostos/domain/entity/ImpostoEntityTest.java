package br.senac.sp.impostos.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImpostoEntityTest {

    @Test
    void calcularImpostoDevido_deveCalcularCorretamente() {
        ImpostoEntity impostoEntity = new ImpostoEntity(3000.0, 15.0);
        Double expectedImposto = 450.0;

        Double actualImposto = impostoEntity.calcularImpostoDevido();

        assertEquals(expectedImposto, actualImposto);
    }

    @Test
    void calcularImpostoDevido_impostoZeroQuandoPorcentagemZero() {
        ImpostoEntity impostoEntity = new ImpostoEntity(3000.0, 0.0);
        Double expectedImposto = 0.0;

        Double actualImposto = impostoEntity.calcularImpostoDevido();

        assertEquals(expectedImposto, actualImposto);
    }

    @Test
    void calcularImpostoDevido_impostoZeroQuandoSalarioBrutoZero() {
        ImpostoEntity impostoEntity = new ImpostoEntity(0.0, 15.0);
        Double expectedImposto = 0.0;

        Double actualImposto = impostoEntity.calcularImpostoDevido();

        assertEquals(expectedImposto, actualImposto);
    }

    @Test
    void equals_deveSerIgualParaObjetosComMesmosValores() {
        ImpostoEntity imposto1 = new ImpostoEntity(3000.0, 15.0);
        ImpostoEntity imposto2 = new ImpostoEntity(3000.0, 15.0);

        assertEquals(imposto1, imposto2);
    }

    @Test
    void equals_deveSerDiferenteParaObjetosComValoresDiferentes() {
        ImpostoEntity imposto1 = new ImpostoEntity(3000.0, 15.0);
        ImpostoEntity imposto2 = new ImpostoEntity(4000.0, 15.0);

        assertNotEquals(imposto1, imposto2);
    }

    @Test
    void hashCode_deveSerIgualParaObjetosComMesmosValores() {
        ImpostoEntity imposto1 = new ImpostoEntity(3000.0, 15.0);
        ImpostoEntity imposto2 = new ImpostoEntity(3000.0, 15.0);

        assertEquals(imposto1.hashCode(), imposto2.hashCode());
    }

    @Test
    void hashCode_deveSerDiferenteParaObjetosComValoresDiferentes() {
        ImpostoEntity imposto1 = new ImpostoEntity(3000.0, 15.0);
        ImpostoEntity imposto2 = new ImpostoEntity(4000.0, 15.0);

        assertNotEquals(imposto1.hashCode(), imposto2.hashCode());
    }

    @Test
    void equals_deveSerDiferenteParaNull() {
        ImpostoEntity imposto = new ImpostoEntity(3000.0, 15.0);
        assertNotEquals(imposto, null);
    }

    @Test
    void equals_deveSerDiferenteParaOutraClasse() {
        ImpostoEntity imposto = new ImpostoEntity(3000.0, 15.0);
        String outraClasse = "string";

        assertNotEquals(imposto, outraClasse);
    }

    @Test
    void equals_deveSerIgualParaMesmaInstancia() {
        ImpostoEntity imposto = new ImpostoEntity(3000.0, 15.0);
        assertEquals(imposto, imposto);
    }
}
