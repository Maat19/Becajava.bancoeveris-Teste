package br.bancoeveris.app.controller;

import br.bancoeveris.app.model.BaseResponse;

public class BaseController {

public BaseResponse errorbase = new BaseResponse();
	
	public BaseController() {
		errorbase.StatusCode = 500;
		errorbase.Message = "Ocorreu um erro inesperado.Contate o administrador";
	}
}
