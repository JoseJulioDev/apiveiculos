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

    List<Veiculo> findByVendidoFalse();

    @Query("SELECT NEW com.jose.julio.apiveiculos.dto.ConsultaVeiculoDTO('marca', v.marca, COUNT(v)) FROM Veiculo v GROUP BY v.marca")
    List<ConsultaVeiculoDTO> qtdVeiculosAgrupadosPorMarca();

    @Query("SELECT NEW com.jose.julio.apiveiculos.dto.ConsultaVeiculoDTO('decada', CONCAT(CAST(FLOOR(v.ano / 10) AS string), '0s'), COUNT(v)) FROM Veiculo v GROUP BY FLOOR(v.ano / 10)")
    List<ConsultaVeiculoDTO> qtdVeiculosAgrupadosPorDecada();


    @Query("SELECT v FROM Veiculo v WHERE v.created >= :dataInicial AND v.created <= :dataFinal")
    List<Veiculo> findRegistradosUltimaSemana(LocalDateTime dataInicial, LocalDateTime dataFinal);

}