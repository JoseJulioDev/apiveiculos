package com.jose.julio.apiveiculos.service;

import com.jose.julio.apiveiculos.dto.ConsultaVeiculoDTO;
import com.jose.julio.apiveiculos.dto.VeiculoDTO;
import com.jose.julio.apiveiculos.model.Veiculo;
import com.jose.julio.apiveiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo cadastrarVeiculo(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = new Veiculo(veiculoDTO);
        return veiculoRepository.save(veiculo);
    }

    public Veiculo atualizarVeiculo(VeiculoDTO veiculoDTO) {
        Optional<Veiculo> optionalVeiculo = veiculoRepository.findById(veiculoDTO.getId());
        if (optionalVeiculo.isPresent()) {
            Veiculo veiculo = new Veiculo(veiculoDTO);
            return veiculoRepository.save(veiculo);
        } else {
            return null;
        }
    }

    public boolean excluirVeiculo(Long id) {
        if (veiculoRepository.existsById(id)) {
            veiculoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Veiculo> obterVeiculoPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public List<Veiculo> listarTodosVeiculos() {
        return (List<Veiculo>) veiculoRepository.findAll();
    }

    public List<Veiculo> listarVeiculosNaoVendidos() {
        return veiculoRepository.findByVendidoFalse();
    }

    public List<ConsultaVeiculoDTO> qtdVeiculosAgrupadosPorDecada() {
        return veiculoRepository.qtdVeiculosAgrupadosPorDecada();
    }

    public List<ConsultaVeiculoDTO> qtdVeiculosAgrupadosPorMarca() {
        return veiculoRepository.qtdVeiculosAgrupadosPorMarca();
    }

    public List<Veiculo> listarVeiculosRegistradosNaUltimaSemana() {
        LocalDateTime semanaAtual = LocalDateTime.now();
        LocalDateTime umaSemanaAtras = semanaAtual.minusWeeks(1);

        return veiculoRepository.findRegistradosUltimaSemana(umaSemanaAtras, semanaAtual);
    }


}