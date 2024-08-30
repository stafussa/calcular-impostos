package br.senac.sp.impostos.application.service;

import br.senac.sp.impostos.application.dto.ImpostosRequest;

public interface CalcularImpostosService {

    Double calcularImpostos(ImpostosRequest impostosRequest);
}
