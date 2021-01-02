package br.com.zup.ZupAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.ZupAPI.models.Pessoa;
import br.com.zup.ZupAPI.services.PessoaService;

@RequestMapping(value = "/pessoas")
@RestController
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Pessoa pessoa) {
		pessoa = service.insert(pessoa);
		return (pessoa == null) 
				?  ResponseEntity.status(412).body("Pessoa já cadastrada")
				:  ResponseEntity.ok().body(pessoa);
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> consulta() { 
		List<Pessoa> pessoas = service.findAll();
		return ResponseEntity.ok().body(pessoas);
	}
}
