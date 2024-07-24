package com.jose.julio.apiveiculos.controller;

import com.jose.julio.apiveiculos.dto.ConsultaVeiculoDTO;
import com.jose.julio.apiveiculos.dto.VeiculoDTO;
import com.jose.julio.apiveiculos.model.Veiculo;
import com.jose.julio.apiveiculos.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody VeiculoDTO veiculoDTO) {
        Veiculo novoVeiculo = veiculoService.cadastrarVeiculo(veiculoDTO);
        return ResponseEntity.ok(novoVeiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> alterarVeiculo(@PathVariable Long id, @RequestBody VeiculoDTO veiculoDTO) {
        veiculoDTO.setId(id); // Definir o id no VeiculoDTO
        Veiculo veiculoAlterado = veiculoService.atualizarVeiculo(veiculoDTO);
        return ResponseEntity.ok(veiculoAlterado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVeiculo(@PathVariable Long id) {
        if (veiculoService.excluirVeiculo(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> obterVeiculoPorId(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.obterVeiculoPorId(id);
        if (veiculo.isPresent()) {
            return ResponseEntity.ok(veiculo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(description = "Retorna todos os Veículos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todos Veículos")
    })
    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodosVeiculos() {
        List<Veiculo> veiculos = veiculoService.listarTodosVeiculos();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/nao-vendidos")
    public ResponseEntity<Long> listarVeiculosNaoVendidos() {
        Long veiculos = veiculoService.qtdVeiculosNaoVendidos();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/por-decada")
    public ResponseEntity<List<ConsultaVeiculoDTO>> listarQtdVeiculosPorDecada() {
        List<ConsultaVeiculoDTO> veiculos = veiculoService.qtdVeiculosAgrupadosPorDecada();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/por-fabricante")
    public ResponseEntity<List<ConsultaVeiculoDTO>> listarQtdVeiculosPorMarca() {
        List<ConsultaVeiculoDTO> qtdVeiculosPorMarca = veiculoService.qtdVeiculosAgrupadosPorFabricante();
        return ResponseEntity.ok(qtdVeiculosPorMarca);
    }

    @GetMapping("/registrados-ultima-semana")
    public ResponseEntity<List<Veiculo>> listarVeiculosRegistradosNaUltimaSemana() {
        List<Veiculo> veiculos = veiculoService.listarVeiculosRegistradosNaUltimaSemana();
        return ResponseEntity.ok(veiculos);
    }
}
