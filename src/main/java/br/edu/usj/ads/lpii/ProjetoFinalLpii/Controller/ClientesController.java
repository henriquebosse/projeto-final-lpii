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

import br.edu.usj.ads.lpii.ProjetoFinalLpii.Classe.Clientes;
import br.edu.usj.ads.lpii.ProjetoFinalLpii.Repository.ClientesRepository;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    ClientesRepository clientesRepository;

    @GetMapping(value="/")
    public ModelAndView getListar() {
        //Irá listar todos os clientes
        List<Clientes> lista = clientesRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("clientes");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    @GetMapping(value="/clientes-exibir/{id}")
    public ModelAndView getExibir(@PathVariable long id) {
        // Irá exibir os clientes de determinado ID
        Clientes clientes = clientesRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("clientes-exibir");
        modelAndView.addObject("clientes", clientes);
        return modelAndView;
    }
    
    @GetMapping(value="/clientes-cadastrar")
    public ModelAndView getCadastrar() {
        // Retorna o Formulário para o Usuário Preencher
        Clientes clientes = new Clientes();
        ModelAndView modelAndView = new ModelAndView("clientes-cadastrar");
        modelAndView.addObject("clientes", clientes);
        return modelAndView;
    }

    @PostMapping(value="/clientes-cadastrar")
    public ModelAndView postCadastrar(Clientes clientes) {
        //recebe as informações do clientes preenchido no formulário e grava no Banco
        clientesRepository.save(clientes);
        ModelAndView modelAndView = new ModelAndView("clientes-exibir");
        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }
    
    @DeleteMapping(value="/{id}")
    public ModelAndView getDeletarMap(@PathVariable long id) {
        // Remove o clientes selecionado
        clientesRepository.deleteById(id);

        List<Clientes> lista = clientesRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("clientes");        
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    @GetMapping(value="/deletar/{id}")
    public ModelAndView getDeletar(@PathVariable long id) {
        // Remove o clientes selecionado
        clientesRepository.deleteById(id);

        List<Clientes> lista = clientesRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("clientes");        
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
    
    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable long id) {
        // Retorna o Formulário de Cadastro com as informações preenchidas referentes ao ID
        Clientes clientes = clientesRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("clientes-cadastrar");        
        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }
}