package br.com.greendog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.greendog.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
