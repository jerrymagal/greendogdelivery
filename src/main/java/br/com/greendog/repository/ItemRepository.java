package br.com.greendog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.greendog.model.Item;

@RepositoryRestResource(collectionResourceRel="itens", path="itens")
public interface ItemRepository extends JpaRepository<Item, Long>{

}
