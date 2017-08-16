package br.com.greendog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@PostMapping(params="form")
	public ModelAndView create(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			return new ModelAndView(LAYOUT_CLIENTE+"form", "formErrors", result.getAllErrors());
		}
		
		repository.save(cliente);
		redirect.addFlashAttribute("globalMessage", "Cliente gravado com sucesso");
		return new ModelAndView("redirect:/" + LAYOUT_CLIENTE + "{cliente.id}", "cliente.id", cliente.getId());
	}
	
	@GetMapping("alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Cliente cliente) {
		return new ModelAndView(LAYOUT_CLIENTE + "form", "cliente", cliente);
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id, RedirectAttributes redirect) {
		repository.delete(id);
		List<Cliente> clientes = repository.findAll();
		
		ModelAndView modelAndView = new ModelAndView(LAYOUT_CLIENTE + "list", "clientes", clientes);
		modelAndView.addObject("globalMessage", "Cliente removido com sucesso!");
		return modelAndView;		
	}
}
