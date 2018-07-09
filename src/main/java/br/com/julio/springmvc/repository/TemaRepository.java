package br.com.julio.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julio.springmvc.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Integer> {
	public Tema findByNome(String paramString);
}
