package br.senac.sp.impostos.application.service.impl;

import br.senac.sp.impostos.application.dto.ImpostosRequest;
import br.senac.sp.impostos.application.service.CalcularImpostosService;
import br.senac.sp.impostos.application.usecase.CalcularImpostosUseCase;
import org.springframework.stereotype.Service;

@Service
public class CalcularImpostosServiceImpl implements CalcularImpostosService {

    private final CalcularImpostosUseCase calcularImpostosUseCase;

    public CalcularImpostosServiceImpl(CalcularImpostosUseCase calcularImpostosUseCase){
        this.calcularImpostosUseCase = calcularImpostosUseCase;
    }

    @Override
    public Double calcularImpostos(ImpostosRequest impostosRequest) {
        return calcularImpostosUseCase.calcularImpostos(impostosRequest);
    }

}
