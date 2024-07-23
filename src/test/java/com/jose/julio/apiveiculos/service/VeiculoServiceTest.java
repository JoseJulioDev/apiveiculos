package com.jose.julio.apiveiculos.service;

import com.jose.julio.apiveiculos.dto.ConsultaVeiculoDTO;
import com.jose.julio.apiveiculos.dto.VeiculoDTO;
import com.jose.julio.apiveiculos.model.Veiculo;
import com.jose.julio.apiveiculos.repository.VeiculoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class VeiculoServiceTest {

    @Mock
    private VeiculoRepository veiculoRepository;

    @InjectMocks
    private VeiculoService veiculoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarVeiculo() {
        VeiculoDTO veiculoDTO = new VeiculoDTO();
        veiculoDTO.setId(1L);
        veiculoDTO.setAno(2022);
        veiculoDTO.setDescricao("1.0 completo");
        veiculoDTO.setMarca("Ford");
        veiculoDTO.setModelo("Fiesta");
        veiculoDTO.setVendido(true);
        Veiculo veiculo = new Veiculo(veiculoDTO);

        when(veiculoRepository.save(any(Veiculo.class))).thenReturn(veiculo);

        Veiculo savedVeiculo = veiculoService.cadastrarVeiculo(veiculoDTO);

        assertNotNull(savedVeiculo);
    }

    @Test
    public void testAtualizarVeiculo() {
        VeiculoDTO veiculoDTO = new VeiculoDTO();
        veiculoDTO.setId(1L);
        veiculoDTO.setAno(2024);
        veiculoDTO.setDescricao("1.6 completo em otimo estado");
        veiculoDTO.setMarca("Ford");
        veiculoDTO.setModelo("Fiesta");
        veiculoDTO.setVendido(false);
        Veiculo veiculo = new Veiculo(veiculoDTO);

        when(veiculoRepository.findById(1L)).thenReturn(Optional.of(new Veiculo()));
        when(veiculoRepository.save(any(Veiculo.class))).thenReturn(veiculo);

        Veiculo updatedVeiculo = veiculoService.atualizarVeiculo(veiculoDTO);

        assertNotNull(updatedVeiculo);
    }

    @Test
    public void testAtualizarVeiculoNotFound() {
        VeiculoDTO veiculoDTO = new VeiculoDTO();
        veiculoDTO.setId(1L);

        when(veiculoRepository.findById(1L)).thenReturn(Optional.empty());

        Veiculo updatedVeiculo = veiculoService.atualizarVeiculo(veiculoDTO);

        assertNull(updatedVeiculo);
    }

    @Test
    public void testExcluirVeiculo() {
        when(veiculoRepository.existsById(anyLong())).thenReturn(true);

        boolean isDeleted = veiculoService.excluirVeiculo(1L);

        assertTrue(isDeleted);
        verify(veiculoRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testExcluirVeiculoNotFound() {
        when(veiculoRepository.existsById(anyLong())).thenReturn(false);

        boolean isDeleted = veiculoService.excluirVeiculo(1L);

        assertFalse(isDeleted);
        verify(veiculoRepository, times(0)).deleteById(anyLong());
    }

    @Test
    public void testObterVeiculoPorId() {
        Veiculo veiculo = new Veiculo();
        veiculo.setId(1L);

        when(veiculoRepository.findById(1L)).thenReturn(Optional.of(veiculo));

        Optional<Veiculo> foundVeiculo = veiculoService.obterVeiculoPorId(1L);

        assertTrue(foundVeiculo.isPresent());
        assertEquals(1L, foundVeiculo.get().getId());
    }

    @Test
    public void testListarTodosVeiculos() {
        Veiculo veiculo1 = new Veiculo();
        Veiculo veiculo2 = new Veiculo();

        when(veiculoRepository.findAll()).thenReturn(Arrays.asList(veiculo1, veiculo2));

        List<Veiculo> veiculos = veiculoService.listarTodosVeiculos();

        assertEquals(2, veiculos.size());
    }

    @Test
    public void testListarVeiculosNaoVendidos() {
        Veiculo veiculo1 = new Veiculo();
        Veiculo veiculo2 = new Veiculo();

        when(veiculoRepository.findByVendidoFalse()).thenReturn(Arrays.asList(veiculo1, veiculo2));

        List<Veiculo> veiculosNaoVendidos = veiculoService.listarVeiculosNaoVendidos();

        assertEquals(2, veiculosNaoVendidos.size());
    }

    @Test
    public void testQtdVeiculosAgrupadosPorDecada() {
        ConsultaVeiculoDTO dto1 = new ConsultaVeiculoDTO();
        ConsultaVeiculoDTO dto2 = new ConsultaVeiculoDTO();

        when(veiculoRepository.qtdVeiculosAgrupadosPorDecada()).thenReturn(Arrays.asList(dto1, dto2));

        List<ConsultaVeiculoDTO> veiculosPorDecada = veiculoService.qtdVeiculosAgrupadosPorDecada();

        assertEquals(2, veiculosPorDecada.size());
    }

    @Test
    public void testQtdVeiculosAgrupadosPorMarca() {
        ConsultaVeiculoDTO dto1 = new ConsultaVeiculoDTO();
        ConsultaVeiculoDTO dto2 = new ConsultaVeiculoDTO();

        when(veiculoRepository.qtdVeiculosAgrupadosPorMarca()).thenReturn(Arrays.asList(dto1, dto2));

        List<ConsultaVeiculoDTO> veiculosPorMarca = veiculoService.qtdVeiculosAgrupadosPorMarca();

        assertEquals(2, veiculosPorMarca.size());
    }

    @Test
    public void testListarVeiculosRegistradosNaUltimaSemana() {
        Veiculo veiculo1 = new Veiculo();
        Veiculo veiculo2 = new Veiculo();

        when(veiculoRepository.findRegistradosUltimaSemana(any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(Arrays.asList(veiculo1, veiculo2));

        List<Veiculo> veiculosUltimaSemana = veiculoService.listarVeiculosRegistradosNaUltimaSemana();

        assertEquals(2, veiculosUltimaSemana.size());
    }
}
