package br.com.julio.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity(name="Foto")
public class Foto
{
  @javax.persistence.Id
  @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
  private Integer id;
  private String nomeFoto;
  
  public Foto() {}
  
  public String getNomeFoto()
  {
    return nomeFoto;
  }
  
  public void setNomeFoto(String nomeFoto) {
    this.nomeFoto = nomeFoto;
  }
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
}
