package br.bancoeveris.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.bancoeveris.app.model.Operacao;
import br.bancoeveris.app.service.OperacaoService;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController extends BaseController{

	private final OperacaoService _service;
	
	
	public OperacaoController(OperacaoService service) {
		
		_service = service;
	}
	
	@PostMapping
	public ResponseEntity criar(@RequestBody Operacao operacao) {

		try {
			_service.criar(operacao);
			return ResponseEntity.status(HttpStatus.CREATED).body("Operação inserida com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}
	
}
