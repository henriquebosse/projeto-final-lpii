package br.edu.usj.ads.lpii.ProjetoFinalLpii.Clientes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientesRepository extends PagingAndSortingRepository <Clientes, Long> {
    List<Clientes> findAll();
    List<Clientes> findByNomeCliente(String nomeCliente);
}