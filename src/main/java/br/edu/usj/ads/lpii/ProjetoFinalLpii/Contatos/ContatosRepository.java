package br.edu.usj.ads.lpii.ProjetoFinalLpii.Contatos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContatosRepository extends PagingAndSortingRepository <Contatos, Long> {
    List<Contatos> findAll();
    List<Contatos> findByNome(String nome);
    List<Contatos> findByNomeContainingIgnoreCase(String nome);
    List<Contatos> findByNomeContainingIgnoreCaseOrderByNome(String nome);

    @Query(value = "select from contatos where nome like (%eise%)", nativeQuery = true)
    String verificaNome();
}