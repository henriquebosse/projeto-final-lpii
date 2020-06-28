package br.edu.usj.ads.lpii.ProjetoFinalLpii.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.edu.usj.ads.lpii.ProjetoFinalLpii.Classe.Produtos;
import br.edu.usj.ads.lpii.ProjetoFinalLpii.Repository.ProdutosRepository;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    ProdutosRepository produtosRepository;

    @GetMapping(value="/")
    public ModelAndView getListar() {
        //Irá listar todos os produtos
        List<Produtos> lista = produtosRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("produtos");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    @GetMapping(value="/produtos-exibir/{id}")
    public ModelAndView getExibir(@PathVariable long id) {
        // Irá exibir os produtos de determinado ID
        Produtos produtos = produtosRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("exibir");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }
    
    @GetMapping(value="/produtos-cadastrar")
    public ModelAndView getCadastrar() {
        // Retorna o Formulário para o Usuário Preencher
        Produtos produtos = new Produtos();
        ModelAndView modelAndView = new ModelAndView("produtos-cadastrar");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

    @PostMapping(value="/produtos-cadastrar")
    public ModelAndView postCadastrar(Produtos produtos) {
        //recebe as informações do produtos preenchido no formulário e grava no Banco
        produtosRepository.save(produtos);
        ModelAndView modelAndView = new ModelAndView("produtos-exibir");
        modelAndView.addObject("produtos", produtos);

        return modelAndView;
    }
    
    @DeleteMapping(value="/{id}")
    public ModelAndView getDeletarMap(@PathVariable long id) {
        // Remove o Produto selecionado
        produtosRepository.deleteById(id);

        List<Produtos> lista = produtosRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("produtos");        
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    @GetMapping(value="/deletar/{id}")
    public ModelAndView getDeletar(@PathVariable long id) {
        // Remove o Produto selecionado
        produtosRepository.deleteById(id);

        List<Produtos> lista = produtosRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("produtos");        
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
    
    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable long id) {
        // Retorna o Formulário de Cadastro com as informações preenchidas referentes ao ID
        Produtos produtos = produtosRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("produtos-cadastrar");        
        modelAndView.addObject("produtos", produtos);

        return modelAndView;
    }
}