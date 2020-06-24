package br.edu.usj.ads.lpii.ProjetoFinalLpii.Contatos;

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


@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/contatos")
public class ContatosController {
    
    @Autowired
    ContatosRepository contatosRepository;

    @GetMapping(value="/")
    public ModelAndView getListar() {
        //Irá listar todos os contatos
        List<Contatos> lista = contatosRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("contatos");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    @GetMapping(value="/contatos-exibir/{id}")
    public ModelAndView getExibir(@PathVariable long id) {
        // Irá exibir os contatos de determinado ID
        Contatos contatos = contatosRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("exibir");
        modelAndView.addObject("contatos", contatos);
        return modelAndView;
    }
    
    @GetMapping(value="/contatos-cadastrar")
    public ModelAndView getCadastrar() {
        // Retorna o Formulário para o Usuário Preencher
        Contatos contatos = new Contatos();
        ModelAndView modelAndView = new ModelAndView("contatos-cadastrar");
        modelAndView.addObject("contatos", contatos);
        return modelAndView;
    }

    @PostMapping(value="/contatos-cadastrar")
    public ModelAndView postCadastrar(Contatos contatos) {
        //recebe as informações do contato preenchido no formulário e grava no Banco
        contatosRepository.save(contatos);
        ModelAndView modelAndView = new ModelAndView("contatos-exibir");
        modelAndView.addObject("contatos", contatos);

        return modelAndView;
    }
    
    @DeleteMapping(value="/{id}")
    public ModelAndView getDeletarMap(@PathVariable long id) {
        // Remove o Contato selecionado
        contatosRepository.deleteById(id);

        List<Contatos> lista = contatosRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("contatos");        
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    @GetMapping(value="/deletar/{id}")
    public ModelAndView getDeletar(@PathVariable long id) {
        // Remove o Contato selecionado
        contatosRepository.deleteById(id);

        List<Contatos> lista = contatosRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("contatos");        
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
    
    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable long id) {
        // Retorna o Formulário de Cadastro com as informações preenchidas referentes ao ID
        Contatos contatos = contatosRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("contatos-cadastrar");        
        modelAndView.addObject("contatos", contatos);

        return modelAndView;
    }
    
    @GetMapping(value="/pesquisar/{nome}")
    public List<Contatos> getPesquisaNome(@PathVariable String nome) {
        List<Contatos> lista = contatosRepository.findByNomeContainingIgnoreCaseOrderByNome(nome);
        
        return lista;
    }

    @GetMapping(value="/obterNome")
    public String getNomeNativo() {
        String nomeNativo = contatosRepository.verificaNome();
        
        return nomeNativo;
    }
    
}