package io.c99.desafiotinnova.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.c99.desafiotinnova.model.Veiculo;
import io.c99.desafiotinnova.service.VeiculoService;

@RestController
@RequestMapping(path = "/veiculo", produces = "application/json")
public class VeiculoController {
    
    @Autowired
    private VeiculoService service;

    @GetMapping
    @ResponseBody
    public List<Veiculo> getVeiculos() {
        return service.getVeiculos();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Veiculo getVeiculos(@PathVariable long id) {
        return service.getVeiculoById(id);
    }
}
