package br.com.julio.springmvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Cliente")
public class Cliente implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  private String email;
  
  @Temporal(TemporalType.DATE)
  private Calendar dataDaFesta = Calendar.getInstance();
  
  private String celular;
  private String nome;
  private String senha;
  private boolean fezContato;
  private boolean fezContrato;
  private String telefone;
  
  @OneToMany(fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL}, mappedBy="cliente")
  private List<Pedido> pedidos = new ArrayList();
  
  public Cliente() {}
  
  public Integer getId() { return id; }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getEmail() { return email; }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public Calendar getDataDaFesta() { return dataDaFesta; }
  
  public void setDataDaFesta(Calendar dataDaFesta) {
    this.dataDaFesta = dataDaFesta;
  }
  
  public String getNome() { return nome; }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public String getSenha() { return senha; }
  
  public void setSenha(String senha) {
    this.senha = senha;
  }
  
  public boolean isFezContato() { return fezContato; }
  
  public void setFezContato(boolean fezContato) {
    this.fezContato = fezContato;
  }
  
  public boolean isFezContrato() { return fezContrato; }
  
  public void setFezContrato(boolean fezContrato) {
    this.fezContrato = fezContrato;
  }
  
  public List<Pedido> getPedidos() { return pedidos; }
  
  public void setPedidos(List<Pedido> pedidos) {
    this.pedidos = pedidos;
  }
  
  public String getTelefone() { return telefone; }
  
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
  
  public String getCelular() { return celular; }
  
  public void setCelular(String celular) {
    this.celular = celular;
  }
}
