package br.com.julio.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.julio.springmvc.model.Festa;

@Repository
public interface FestaRepository extends JpaRepository<Festa, Integer>
{
  public Festa findByNome(String paramString);
}
