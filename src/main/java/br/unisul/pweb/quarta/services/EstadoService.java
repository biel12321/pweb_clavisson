package br.unisul.pweb.quarta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.quarta.domain.Categoria;
import br.unisul.pweb.quarta.domain.Estado;
import br.unisul.pweb.quarta.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired //Injetor de variavel para quando for usado.
	private EstadoRepository rep;
	
	//BUSCA POR NOME
	public List<Estado> buscaPorNome(String nome){
		return rep.findDistinctByNomeContainingOrderByNome(nome);
	}
	
	//BUSCAR POR ID
	public Estado find (Integer id) {
		Optional<Estado> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	//INSERIR
	public Estado insert (Estado obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	//ATUALIZAR
	public Estado update (Estado obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	//DELETAR
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	//LISTAR TODAS
	public List<Estado> findAll(){
		return rep.findAllByOrderByNome();
	}
}
