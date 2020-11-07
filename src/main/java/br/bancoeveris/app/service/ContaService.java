package br.bancoeveris.app.service;

import br.bancoeveris.app.repository.*;
import br.bancoeveris.app.spec.ContaList;
import br.bancoeveris.app.spec.ContaSpec;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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
	public BaseResponse inserir(ContaSpec contaSpec) {
		Conta conta = new Conta();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if (contaSpec.getHash() == "") {
			base.Message = ("Hash não preenchido");
			return base;
		}

		if (contaSpec.getHash() == null) {
			base.Message = ("Hash não preenchido");
			return base;
		}
		
		
		conta.setHash(contaSpec.getHash());
		_repository.save(conta);
		base.StatusCode = 201;
		base.Message = "Conta criada com sucesso.";
		return base;
	}

	
		public List<Conta>listar (String hash){
			
			List<Conta>lista = _repository.findByHash(hash);
			
			return lista;
		}
	
	public ContaList listar() {

		List<Conta> lista = _repository.findAll();

		ContaList response = new ContaList();
		response.setClientes(lista);
		response.StatusCode = 200;
		response.Message = "Hash obtidos com sucesso.";

		return response;
	}
	
	public BaseResponse atualizar(Long id, ContaSpec contaSpec) {
		Conta conta = new Conta();		
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if (contaSpec.getHash() == "") {			
			base.Message = "O número do Hash não foi preenchido.";
			return base;
		}
		
		
		conta.setId(id);
		conta.setHash(contaSpec.getHash());
		
		_repository.save(conta);
		base.StatusCode = 200;
		base.Message = "Número do Hash atualizado com sucesso.";
		return base;		
	}
	
	
	public BaseResponse deletar(Long id) {
		BaseResponse response = new BaseResponse();
		
		if (id == null || id == 0) {
			response.StatusCode = 400;
			return response;
		}
		
		_repository.deleteById(id);
		response.StatusCode = 200;
		return response;
	}
	
	
	
	
	

}
