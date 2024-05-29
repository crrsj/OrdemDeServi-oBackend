package com.os.entidade;


import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.os.servico.dto.OsDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Os {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private LocalDateTime abertura = LocalDateTime.now();
	private int ordem = new Random().nextInt(1000 + 1);
	private String nome;
	private String telefone;
	private String email;
	private String equipamento;
	private String defeito;
	private double total;
	private String obs;	
	public Os(Long id, LocalDateTime abertura, int ordem, String nome, String telefone,String email ,String equipamento,
			String defeito, double total, String obs) {
		super();
		this.id = id;	
		this.abertura = abertura;
		this.ordem = ordem;
		this.nome = nome;
		this.telefone = telefone;
		this.equipamento = equipamento;
		this.defeito = defeito;
		this.total = total;
		this.obs = obs;
		this.email = email;
	}
	
	
	public Os(OsDto os) {
	this.id = os.getId();
	this.abertura = os.getAbertura();
	this.nome = os.getNome();
	this.telefone = os.getTelefone();
	this.email = os.getEmail();
	this.equipamento = os.getEquipamento();
	this.defeito = os.getDefeito();
	this.total = os.getTotal();
	this.obs = os.getObs();

	}
	

	
	
	
	

}
