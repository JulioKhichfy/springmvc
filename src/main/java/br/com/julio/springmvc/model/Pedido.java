package br.com.julio.springmvc.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Pedido")
public class Pedido
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Id
  private Integer id;
  @Temporal(TemporalType.DATE)
  private Calendar dataDoPedido = Calendar.getInstance();
  private String pacote;
  private String nomeDaFesta;
  
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="pedido_id")
  private Cliente cliente;
  
  public Pedido() {}
  
  public Integer getId()
  {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public Calendar getDataDoPedido() {
    return dataDoPedido;
  }
  
  public void setDataDoPedido(Calendar dataDoPedido) {
    this.dataDoPedido = dataDoPedido;
  }
  
  public String getPacote() {
    return pacote;
  }
  
  public void setPacote(String pacote) {
    this.pacote = pacote;
  }
  
  public Cliente getCliente() {
    return cliente;
  }
  
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
  
  public String getNomeDaFesta() {
    return nomeDaFesta;
  }
  
  public void setNomeDaFesta(String nomeDaFesta) {
    this.nomeDaFesta = nomeDaFesta;
  }
}