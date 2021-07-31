package io.c99.desafiotinnova.controller;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.c99.desafiotinnova.model.Veiculo;
import io.c99.desafiotinnova.model.dto.VeiculoDTO;
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
    public void newVeiculo(VeiculoDTO veiculo) throws ParseException {
        service.newVeiculo(VeiculoDTO.fromDTO(veiculo));
    }    

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteVeiculo(@PathVariable long id) {
        service.deleteVeiculo(id);
    }
}
