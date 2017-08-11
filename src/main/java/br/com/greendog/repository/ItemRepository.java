package br.com.greendog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.greendog.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
