package io.c99.desafiotinnova.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.c99.desafiotinnova.model.Veiculo;
import io.c99.desafiotinnova.service.VeiculoService;

@RestController
@RequestMapping(path = "/veiculos")
@CrossOrigin(origins = "http://localhost:4200")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Veiculo> getVeiculos() {
        return service.getVeiculos();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Veiculo getVeiculoById(@PathVariable long id) {
        return service.getVeiculoById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void newVeiculo(@RequestParam String veiculo, @RequestParam String marca, @RequestParam int ano,
            @RequestParam String descricao, @RequestParam boolean vendido) {
        Veiculo v = new Veiculo(veiculo, marca, ano, descricao, vendido);
        service.newVeiculo(v);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void putVeiculo(@PathVariable long id, @RequestParam String veiculo, @RequestParam String marca,
            @RequestParam int ano, @RequestParam String descricao, @RequestParam boolean vendido) {
        Veiculo v = new Veiculo(id, veiculo, marca, ano, descricao, vendido);
        service.newVeiculo(v);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void patchVeiculo(@PathVariable long id, @RequestParam(required = false) String veiculo,
            @RequestParam(required = false) String marca, @RequestParam(required = false) String ano,
            @RequestParam(required = false) String descricao, @RequestParam(required = false) String vendido) {
        service.patchVeiculo(id, veiculo, marca, ano, descricao, vendido);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteVeiculo(@PathVariable long id) {
        service.deleteVeiculo(id);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Veiculo> pesquisaVeiculo(@RequestParam String termo) {
        return service.pesquisaVeiculo(termo);
    }
}
