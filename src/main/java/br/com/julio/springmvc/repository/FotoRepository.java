package br.com.julio.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julio.springmvc.model.Festa;
import br.com.julio.springmvc.model.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer> {
	public Festa findByNomeFoto(String paramString);
}
