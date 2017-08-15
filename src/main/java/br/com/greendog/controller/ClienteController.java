package br.com.greendog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.greendog.model.Cliente;
import br.com.greendog.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;
	private static final String LAYOUT_CLIENTE = "clientes/";
	
	@GetMapping
	public ModelAndView list() {
		List<Cliente> clientes = repository.findAll();
		return new ModelAndView(LAYOUT_CLIENTE+"list", "clientes", clientes);
	}
	
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Cliente cliente) {
		return new ModelAndView(LAYOUT_CLIENTE+"view", "cliente", cliente);
	}

	@GetMapping("/novo")
	public String createForm(@ModelAttribute Cliente cliente) {
		return LAYOUT_CLIENTE+"form";
	}
	
}
