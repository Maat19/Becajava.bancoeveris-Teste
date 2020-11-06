package br.bancoeveris.app.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.bancoeveris.app.model.Operacao;
import br.bancoeveris.app.repository.OperacaoRepository;

@Service
public class OperacaoService {

	final OperacaoRepository _repository;

	public OperacaoService(OperacaoRepository repository) {
		_repository = repository;
	}

	// Inserir
	public void criar(Operacao operacao) {
		operacao.setId(0L);
		_repository.save(operacao);
	}


}
