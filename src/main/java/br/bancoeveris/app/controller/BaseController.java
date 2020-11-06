package br.bancoeveris.app.controller;

import br.bancoeveris.app.model.BaseResponse;

public class BaseController {

public BaseResponse error = new BaseResponse();
	
	public BaseController() {
		error.StatusCode = 500;
		error.Message = "Ocorreu um erro inesperado.Contate o administrador";
	}
}
