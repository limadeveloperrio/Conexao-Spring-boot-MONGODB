package br.com.briuno.service;

import java.util.List;

import br.com.briuno.model.Funcionario;

public interface FuncionarioService {
	
	public List<Funcionario> ObterTodos();

	public Funcionario obterPorCodigo(String codigo);

	public Funcionario criar(Funcionario funcionario);
	
	public List<Funcionario> obterFuncPorRangeIdade(Integer de, Integer ate);
	
	public List<Funcionario> obterFuncPorNome(String nome); 
}
