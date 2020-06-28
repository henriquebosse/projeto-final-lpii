package br.edu.usj.ads.lpii.ProjetoFinalLpii.Repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.edu.usj.ads.lpii.ProjetoFinalLpii.Classe.Clientes;

public interface ClientesRepository extends PagingAndSortingRepository <Clientes, Long> {
    List<Clientes> findAll();
    List<Clientes> findByNomeCliente(String nomeCliente);
}