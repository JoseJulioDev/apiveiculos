package com.jose.julio.apiveiculos.repository;

import com.jose.julio.apiveiculos.dto.ConsultaVeiculoDTO;
import com.jose.julio.apiveiculos.model.Veiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

    @Query("SELECT COUNT(v) FROM Veiculo v WHERE v.vendido = false")
    Long qtdVeiculosNaoVendidos();

    @Query("SELECT NEW com.jose.julio.apiveiculos.dto.ConsultaVeiculoDTO('fabricante', v.marca, COUNT(v)) FROM Veiculo v GROUP BY v.marca")
    List<ConsultaVeiculoDTO> qtdVeiculosAgrupadosPorFabricante();

    @Query("SELECT NEW com.jose.julio.apiveiculos.dto.ConsultaVeiculoDTO('década', CONCAT(CAST(FLOOR(v.ano / 10) * 10 AS string)), COUNT(v)) FROM Veiculo v GROUP BY FLOOR(v.ano / 10) ORDER BY FLOOR(v.ano / 10)")
    List<ConsultaVeiculoDTO> qtdVeiculosAgrupadosPorDecada();


    @Query("SELECT v FROM Veiculo v WHERE v.created >= :dataInicial AND v.created <= :dataFinal")
    List<Veiculo> findRegistradosUltimaSemana(LocalDateTime dataInicial, LocalDateTime dataFinal);

}