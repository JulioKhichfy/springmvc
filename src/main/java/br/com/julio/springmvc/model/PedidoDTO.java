package br.com.julio.springmvc.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

//import org.hibernate.validator.constraints.NotEmpty;

public class PedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotEmpty(message = "Selecione pelo menos 1 festa.")
	private String[] festas;
	@NotEmpty(message = "Informe o Nome.")
	private String nome;
	@NotEmpty(message = "Informe seu email.")
	private String email;
	@NotEmpty(message = "informe seu celular.")
	private String cel;

	public String[] getFestas() {
		return festas;
	}

	public void setFestas(String[] festas) {
		this.festas = festas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

}
