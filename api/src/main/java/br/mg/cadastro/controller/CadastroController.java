package br.mg.cadastro.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.mg.cadastro.dtos.CadastroDTO;
import br.mg.cadastro.entities.CadastroInsert;
import br.mg.cadastro.responses.CadastroResponse;
import br.mg.cadastro.services.CadastroServices;


@RestController
@RequestMapping("/testes/teste-api-tests")
public class CadastroController {

	@Autowired
	private CadastroServices cadastroService;

	@PostMapping(path = "/new")
	public ResponseEntity<CadastroResponse<CadastroInsert>> cadastrar(@Valid @RequestBody CadastroDTO cadastroDto, BindingResult result) {
		CadastroResponse<CadastroInsert> response = new CadastroResponse<CadastroInsert>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		CadastroInsert cadastroSalvo = this.cadastroService.salvar(cadastroDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cadastroDto.getId())
				.toUri();
		response.setString(cadastroSalvo);
		return ResponseEntity.created(location).body(response);
	}

	@GetMapping
	public ResponseEntity<List<CadastroInsert>> listar() {
		List<CadastroInsert> viagens = cadastroService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(cadastro);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<CadastroResponse<CadastroInsert>> buscar(@PathVariable("id") Long id) {
  
		CadastroInsert cadastro = cadastroService.buscar(id);
		CadastroResponse<CadastroInsert> response = new CadastroResponse<CadastroInsert>();
		response.setString(cadastro);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
