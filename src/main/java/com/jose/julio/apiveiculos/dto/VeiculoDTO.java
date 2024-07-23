package com.jose.julio.apiveiculos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class VeiculoDTO {

    private Long id;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String descricao;

    @NotNull
    private Integer ano;

    @NotNull
    private Boolean vendido;

}
