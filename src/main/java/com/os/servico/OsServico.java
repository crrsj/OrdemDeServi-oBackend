package com.os.servico;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.os.entidade.Os;
import com.os.repositorio.OsRepositorio;
import com.os.servico.dto.OsDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OsServico {
	
	private final OsRepositorio osRepositorio;

	public Os cadastrarOs(OsDto os){
		var cadastre = new Os(os);
		return osRepositorio.save(cadastre);
	}
	
	public List<Os>ListarOs(){
		return osRepositorio.findAll();
	}
	
	public Os buscarPorId(Long id) {
		Optional<Os> buscar = osRepositorio.findById(id);
		return buscar.get();
	}
	
	public Os AtualizarOs(OsDto os) {
		var atualize = new Os(os);
		if(atualize.getId() == null) {
			throw new NoSuchElementException();
		}
		return osRepositorio.save(atualize);
	}
	
	public void excluir(Long id) {
		osRepositorio.findById(id);
		osRepositorio.deleteById(id);
	}
}
