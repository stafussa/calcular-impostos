package br.senac.sp.impostos.presentation.rest;


import br.senac.sp.impostos.application.dto.ImpostosRequest;
import br.senac.sp.impostos.application.service.CalcularImpostosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("/api/impostos")
public class ImpostosController {

    private final CalcularImpostosService calcularImpostosService;

    public ImpostosController(CalcularImpostosService calcularImpostosService){
        this.calcularImpostosService = calcularImpostosService;
    }

    @PostMapping
    public ResponseEntity<?> calcularImpostos(@RequestBody ImpostosRequest request){
        Double impostoCalculado = calcularImpostosService.calcularImpostos(request);
        return ResponseEntity.ok(BigDecimal.valueOf(impostoCalculado).setScale(2, RoundingMode.HALF_UP).doubleValue());
    }

}
