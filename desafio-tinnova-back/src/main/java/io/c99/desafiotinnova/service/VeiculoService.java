package io.c99.desafiotinnova.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.c99.desafiotinnova.model.Veiculo;
import io.c99.desafiotinnova.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    public List<Veiculo> getVeiculos() {
        List<Veiculo> resultado = repository.getVeiculos();
        return resultado;
    }

    public Veiculo getVeiculoById(long id) {
        Veiculo resultado = repository.getVeiculoById(id);
        return resultado;
    }
}
