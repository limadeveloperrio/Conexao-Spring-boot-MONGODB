package br.com.briuno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.briuno.model.Funcionario;
import br.com.briuno.service.FuncionarioService;
import br.com.briuno.service.impl.FuncionarioServicoImpl;

@RequestMapping(value = "/funcionarios")
@RestController
public class funcionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping
	public List<Funcionario> obterTodos() {
		return funcionarioService.ObterTodos();
	}
	@RequestMapping("/{codido}")
	public Funcionario obterPorCodigo(@PathVariable String codigo) {
		return this.funcionarioService.obterPorCodigo(codigo);
	}
	@PostMapping
	public Funcionario criar(@RequestBody Funcionario funcionario) {
		return this.funcionarioService.criar(funcionario);
	}
	@GetMapping("/range")
	public List<Funcionario> obterFuncPorRangeIdade(
			@RequestParam("de")Integer de,
            @RequestParam("ate") Integer ate){
		return this.funcionarioService.obterFuncPorRangeIdade(de, ate);
	}
	
	@GetMapping("/por-nome")
	public List<Funcionario> obterporNome(
			@RequestParam("nome")String nome){
		return this.funcionarioService.obterFuncPorNome(nome);
	}

}
