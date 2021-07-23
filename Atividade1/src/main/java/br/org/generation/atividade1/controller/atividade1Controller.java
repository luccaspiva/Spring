package br.org.generation.atividade1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping; //--> ctrl+shift+o
import org.springframework.web.bind.annotation.RestController; //--> ctrl+shift+o

@RestController
@RequestMapping("/atividade1")
public class atividade1Controller {
	
	@GetMapping
	public String atividade1() {
		return "Mentalidade: Persistencia. Habilidade: Atenção aos Detalhes.";
	}
}
