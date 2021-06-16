package br.com.alura.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alura.entidade.AgendamentoEmail;
import br.com.alura.servico.AgendamentoEmailServico;

@Path("emails")
public class AgendamentoEmailController {

	@Inject
	private AgendamentoEmailServico service;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response listar() {
		var emails = service.listar();
		return Response.ok(emails).build();
	}

	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response inserir(AgendamentoEmail agendamentoEmail) {
		service.inserir(agendamentoEmail);
		return Response.status(201).build();
	}

}