package br.edu.usj.ads.lpii.ProjetoFinalLpii.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.edu.usj.ads.lpii.ProjetoFinalLpii.Classe.Contatos;

public interface ContatosRepository extends PagingAndSortingRepository <Contatos, Long> {
    List<Contatos> findAll();
    List<Contatos> findByNome(String nome);
    List<Contatos> findByNomeContainingIgnoreCase(String nome);
    List<Contatos> findByNomeContainingIgnoreCaseOrderByNome(String nome);

    @Query(value = "select from contatos where nome like (%eise%)", nativeQuery = true)
    String verificaNome();
}