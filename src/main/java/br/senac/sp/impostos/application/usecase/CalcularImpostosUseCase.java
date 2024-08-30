package br.senac.sp.impostos.application.usecase;

import br.senac.sp.impostos.application.dto.ImpostosRequest;

public interface CalcularImpostosUseCase {

    Double calcularImpostos(ImpostosRequest request);

}