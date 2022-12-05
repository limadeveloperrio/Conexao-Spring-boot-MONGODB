package br.com.briuno.service.impl;

import java.nio.channels.IllegalChannelGroupException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.briuno.model.Funcionario;
import br.com.briuno.repository.FuncionarioRepository;
import br.com.briuno.service.FuncionarioService;

@Service
public class FuncionarioServicoImpl implements FuncionarioService{

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public List<Funcionario> ObterTodos() {
		return this.funcionarioRepository.findAll();
	}

	@Override
	public Funcionario obterPorCodigo(String codigo) {
		return this.funcionarioRepository.findById(codigo)
				.orElseThrow(() 
						-> new IllegalArgumentException("Funcionário não existe."));
	}

	@Override
	public Funcionario criar(Funcionario funcionario) {
		Funcionario chefe = this.funcionarioRepository.
				findById(funcionario.getChefe().getCodigo())
				.orElseThrow( ()
						-> new IllegalArgumentException("Chefe não localizado."));
		funcionario.setChefe(chefe);
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public List<Funcionario> obterFuncPorRangeIdade(Integer de, Integer ate) {
		return funcionarioRepository.obterFuncPorRangeIdade(de, ate);
	}

	@Override
	public List<Funcionario> obterFuncPorNome(String nome) {
		return funcionarioRepository.findByNome(nome);
	}

}
