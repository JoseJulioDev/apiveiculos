package com.jose.julio.apiveiculos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ConsultaVeiculoDTO {
    private String chave; // Pode ser 'fabricante' ou 'decada'
    private String descricao;
    private Long quantidade;
}
