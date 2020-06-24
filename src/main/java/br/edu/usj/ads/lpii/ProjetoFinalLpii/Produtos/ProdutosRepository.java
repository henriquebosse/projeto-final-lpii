package br.edu.usj.ads.lpii.ProjetoFinalLpii.Produtos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutosRepository extends PagingAndSortingRepository <Produtos, Long> {
    List<Produtos> findAll(); 
    List<Produtos> findByDescricao(String descricao);
    List<Produtos> findByDescricaoContainingIgnoreCase(String descricao);
    
}