package com.os.controle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.os.servico.OsServico;
import com.os.servico.dto.OsDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("os")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OsControle {
	
	private final OsServico osServico;
    
	@PostMapping
	public ResponseEntity<OsDto>cadastrarOs(@RequestBody OsDto os){
		var cadastrarOs = osServico.cadastrarOs(os);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("os/{id}")
		.buildAndExpand(cadastrarOs.getId()).toUri();
		return ResponseEntity.created(uri).body(new OsDto(cadastrarOs));
	}
	
	@GetMapping
	public ResponseEntity<List<OsDto>>buscarTodos(){
		var lista = osServico.ListarOs().stream().map(OsDto::new).toList();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<OsDto>buscarPorid(@PathVariable Long id){
		var busca = osServico.buscarPorId(id);
		return ResponseEntity.ok(new OsDto(busca));
	}
	
	@PutMapping
	public ResponseEntity<OsDto>autalizarDto(@RequestBody OsDto os){
		var atualize = osServico.AtualizarOs(os);
		return ResponseEntity.ok().body(new OsDto(atualize));
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void>excluir(@PathVariable Long id){
		osServico.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
