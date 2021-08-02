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
        List<Veiculo> resultado = repository.findAll();
        return resultado;
    }

    public Veiculo getVeiculoById(long id) {
        Veiculo resultado = repository.findById(id).get();
        return resultado;
    }

    public Veiculo newVeiculo(Veiculo veiculo) {
        Veiculo v = repository.save(veiculo);
        return v;
    }

    public Veiculo patchVeiculo (long id, String veiculo, String marca, String anoString, String descricao, String vendidoString) {
        Integer ano = (anoString != null) ? Integer.valueOf(anoString) : Integer.valueOf(0);
        Boolean vendido = (vendidoString != null) ? Boolean.parseBoolean(vendidoString) : false;
        Veiculo old = repository.getById(id);
        if (veiculo != null && veiculo != old.getVeiculo()) {
            old.setVeiculo(veiculo);
        }
        if (marca != null && marca != old.getMarca()) {
            old.setMarca(marca);
        }
        if (ano > 0 && ano != old.getAno()) {
            old.setAno(ano);
        }
        if (descricao != null && descricao != old.getDescricao()) {
            old.setDescricao(descricao);
        }
        if (vendido != old.isVendido()) {
            old.setVendido(vendido);
        }
        Veiculo v = repository.save(old);
        return v;
    }

    public void deleteVeiculo(long id) {
        this.repository.deleteById(id);
    }

    public List<Veiculo> pesquisaVeiculo(String termo) {
        List<Veiculo> list = this.repository.filtrar(termo);
        return list;
    }
}
