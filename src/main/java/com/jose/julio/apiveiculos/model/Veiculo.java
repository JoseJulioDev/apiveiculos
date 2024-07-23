package com.jose.julio.apiveiculos.model;

import com.jose.julio.apiveiculos.dto.VeiculoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marca;
    private String modelo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private Integer ano;

    @Column(nullable = false)
    private Boolean vendido;

    @Column(nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime updated;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        created = now;
        updated = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now();
    }

    // Construtor que aceita um VeiculoDTO para transformação em Veiculo
    public Veiculo(VeiculoDTO veiculoDTO) {
        this.marca = veiculoDTO.getMarca();
        this.modelo = veiculoDTO.getModelo();
        this.descricao = veiculoDTO.getDescricao();
        this.ano = veiculoDTO.getAno();
        this.vendido = veiculoDTO.getVendido();
        this.id = veiculoDTO.getId();
    }

}
