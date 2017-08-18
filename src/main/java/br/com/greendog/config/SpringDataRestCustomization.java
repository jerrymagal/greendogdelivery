package br.com.greendog.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import br.com.greendog.model.Item;
import br.com.greendog.repository.ClienteRepository;

public class SpringDataRestCustomization extends RepositoryRestConfigurerAdapter {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Item.class, ClienteRepository.class);
	}
	
	
}
