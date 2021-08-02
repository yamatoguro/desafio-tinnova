package io.c99.desafiotinnova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.c99.desafiotinnova.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query(value = "SELECT v FROM Veiculo v WHERE v.veiculo LIKE %?1% OR v.marca LIKE %?1% OR v.descricao LIKE %?1%")
    List<Veiculo> filtrar(String termo);

}
