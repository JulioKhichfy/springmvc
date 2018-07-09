package br.com.julio.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julio.springmvc.model.Pedido;

@Repository
public  interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	//public  Pedido findByCliente(Cliente paramCliente);
}
