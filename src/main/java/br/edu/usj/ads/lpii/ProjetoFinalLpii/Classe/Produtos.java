package br.edu.usj.ads.lpii.ProjetoFinalLpii.Classe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String descricao;
    String grupo;
    String aliquota;
    Double precoCusto;
    Double precoVenda;

}