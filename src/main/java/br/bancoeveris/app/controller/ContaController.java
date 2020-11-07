package br.bancoeveris.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.bancoeveris.app.model.BaseResponse;
import br.bancoeveris.app.model.Conta;
import br.bancoeveris.app.service.ContaService;
import br.bancoeveris.app.spec.ContaList;
import br.bancoeveris.app.spec.ContaSpec;

@RestController
@RequestMapping("/contas")
public class ContaController extends BaseController {

	private final ContaService _service;

	@Autowired
	public ContaController(ContaService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody ContaSpec contaSpec) {

		try {
			BaseResponse response = _service.inserir(contaSpec);
			return ResponseEntity.status(response.StatusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorbase.StatusCode).body(errorbase);
		}
	}
	
	@GetMapping(path="/{hash}")
	
	public ResponseEntity listar(@PathVariable String hash) {
		
		List<Conta>contas = _service.listar(hash);
		
		return ResponseEntity.status(HttpStatus.OK).body(contas);
	}
	


	@GetMapping
	public ResponseEntity listar() {
		try {
			ContaList contas = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(contas);
		} catch (Exception e) {
			return ResponseEntity.status(errorbase.StatusCode).body(errorbase);
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody ContaSpec contaSpec,@PathVariable Long id) {
		try {
			BaseResponse response = _service.atualizar(id, contaSpec);
			return ResponseEntity.status(response.StatusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorbase.StatusCode).body(errorbase);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		try {
			BaseResponse response = _service.deletar(id);
			return ResponseEntity.status(response.StatusCode).build();
		} catch (Exception e) {
			return ResponseEntity.status(errorbase.StatusCode).body(errorbase);
		}
	}

}
