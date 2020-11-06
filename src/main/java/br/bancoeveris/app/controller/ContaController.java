package br.bancoeveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.bancoeveris.app.model.BaseResponse;
import br.bancoeveris.app.model.Conta;
import br.bancoeveris.app.service.ContaService;
import br.bancoeveris.app.spec.ContaSpec;


@RestController
@RequestMapping("/contas")
public class ContaController extends BaseController{

	
	private final ContaService _service;
	
	@Autowired
	public ContaController(ContaService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir (@RequestBody ContaSpec contaSpec) {

		try { 
			BaseResponse response = _service.inserir(contaSpec);
		return ResponseEntity.status(response.StatusCode).body(response);			
		} catch (Exception e) {
			return ResponseEntity.status(error.StatusCode).body(error);
		}
}
}

