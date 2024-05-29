package com.os.servico.dto;

import java.time.LocalDateTime;
import java.util.Random;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.os.entidade.Os;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OsDto {
  
	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime abertura = LocalDateTime.now();
	private int ordem = new Random().nextInt(1000 + 1);
	private String nome;
	private String telefone;
	private String email;
	private String equipamento;
	private String defeito;
	private double total;
	private String obs;
	
	  public OsDto(Os cadastrarOs) {
			this.id = cadastrarOs.getId();
		    this.abertura  = cadastrarOs.getAbertura();
			this.ordem = cadastrarOs.getOrdem();
			this.nome = cadastrarOs.getNome();
			this.telefone = cadastrarOs.getTelefone();
			this.email = cadastrarOs.getEmail();
			this.equipamento = cadastrarOs.getEquipamento();
			this.defeito = cadastrarOs.getDefeito();
			this.total = cadastrarOs.getTotal();
			this.obs = cadastrarOs.getObs();
		}
}
