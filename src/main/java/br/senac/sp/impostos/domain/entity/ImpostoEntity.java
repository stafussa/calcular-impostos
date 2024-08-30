package br.senac.sp.impostos.domain.entity;

import java.util.Objects;

public class ImpostoEntity {

    private Double salarioBruto;
    private Double porcentagemImposto;

    public ImpostoEntity(Double salarioBruto, Double porcentagemImposto){
        this.salarioBruto = salarioBruto;
        this.porcentagemImposto = porcentagemImposto;
    }

    public Double calcularImpostoDevido(){
        return salarioBruto * (porcentagemImposto / 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImpostoEntity that = (ImpostoEntity) o;
        return Objects.equals(salarioBruto, that.salarioBruto) && Objects.equals(porcentagemImposto, that.porcentagemImposto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salarioBruto, porcentagemImposto);
    }

}