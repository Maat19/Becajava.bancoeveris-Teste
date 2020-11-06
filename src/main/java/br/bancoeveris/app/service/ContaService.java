package br.bancoeveris.app.service;

import br.bancoeveris.app.repository.*;
import br.bancoeveris.app.spec.ContaSpec;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bancoeveris.app.model.BaseResponse;
import br.bancoeveris.app.model.Conta;

@Service
public class ContaService {

	final ContaRepository _repository;

	@Autowired
	public ContaService(ContaRepository repository) {
		_repository = repository;
	}

	// Inserir
	public BaseResponse inserir (ContaSpec contaSpec) {
		Conta conta = new Conta();
		BaseResponse base = new BaseResponse();
		base.StatusCode =400;
		
		
		if (contaSpec.getHash() == conta.getHash()) {
			base.Message = "Número de Hash já existente!";
			return base;
		}
		
		conta.setHash(contaSpec.getHash());
		base.StatusCode = 201;
		base.Message = "Conta criada com sucesso.";
		return base;
	}

	

}


