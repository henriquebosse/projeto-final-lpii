package br.edu.usj.ads.lpii.ProjetoFinalLpii.Repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.edu.usj.ads.lpii.ProjetoFinalLpii.Classe.Produtos;

public interface ProdutosRepository extends PagingAndSortingRepository <Produtos, Long> {
    List<Produtos> findAll(); 
    List<Produtos> findByDescricao(String descricao);
    List<Produtos> findByDescricaoContainingIgnoreCase(String descricao);
    
}