package br.edu.usj.ads.lpii.ProjetoFinalLpii.Clientes;

import java.sql.Date;

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
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String nomeCliente;
    String endereco;
    String numero;
    String bairro;
    String cidade;
    Date dtCadastro;
}