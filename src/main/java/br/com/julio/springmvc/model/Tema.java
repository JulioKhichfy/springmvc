package br.com.julio.springmvc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="Tema")
/*@NamedQuery(name = "Tema.findByFotos",
query = "select t from Tema t where t.id = ?1")*/
public class Tema
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String descricao;
  @OneToMany(fetch=FetchType.EAGER)
  private List<Foto> fotos;
  
  public Tema() {}
  
  public String getNome()
  {
    return nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public String getDescricao() {
    return descricao;
  }
  
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  
  public List<Foto> getFotos() {
    System.out.println("pegando fotos em tema " + fotos.size());
    return fotos;
  }
  
  public void setFotos(List<Foto> fotos) {
    this.fotos = fotos;
  }
}