package br.unisul.pweb.quarta.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.quarta.domain.Categoria;
import br.unisul.pweb.quarta.domain.Estado;
import br.unisul.pweb.quarta.repositories.CategoriaRepository;
import br.unisul.pweb.quarta.repositories.EstadoRepository;

@Service
public class DbService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Decoração");
		Estado est1 = new Estado(null, "Florianopolis");
		Estado est2 = new Estado(null, "Blumenal");
		Estado est3 = new Estado(null, "Jardin dourado");
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		estadoRepository.saveAll(Arrays.asList( est1, est2, est3));
		
	}
}
