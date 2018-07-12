package br.com.julio.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.julio.springmvc.repository.FestaRepository;

@Controller
public class HomeController {

	@Autowired
	private FestaRepository festaRepository;
	/*@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;*/

	@GetMapping(value = "/home")
	public ModelAndView exibirHome() {
		return new ModelAndView("home");
	}
	
	/*@GetMapping(value = "/login")
	public ModelAndView exibirLogin() {
		return new ModelAndView("login");
	}*/

	@RequestMapping(value = { "/index" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("festas", festaRepository.findAll());
		return mv;
	}

	/*
	 * @RequestMapping(value={"/enviar-interesse"},
	 * method={org.springframework.web.bind.annotation.RequestMethod.POST}) public
	 * ModelAndView submit(@Valid @ModelAttribute("interesseClienteFesta")
	 * InteresseClienteFesta interesseClienteFesta, BindingResult result, ModelMap
	 * model) { ModelAndView mv = new ModelAndView("index"); Pedido pedido = new
	 * Pedido(); Cliente c =
	 * clienteRepository.findByEmail(interesseClienteFesta.getEmail());
	 * 
	 * mv.addObject("nomeCliente", interesseClienteFesta.getNomeCliente());
	 * mv.addObject("emailCliente", interesseClienteFesta.getEmail());
	 * mv.addObject("celularCliente", interesseClienteFesta.getCelular());
	 * 
	 * 
	 * if (c == null) { Cliente cliente = new Cliente();
	 * cliente.setEmail(interesseClienteFesta.getEmail());
	 * cliente.setCelular(interesseClienteFesta.getCelular());
	 * cliente.setNome(interesseClienteFesta.getNomeCliente());
	 * cliente.setSenha(interesseClienteFesta.getEmail());
	 * pedido.setNomeDaFesta(interesseClienteFesta.getNomeFesta());
	 * pedido.setCliente(cliente);
	 * 
	 * clienteRepository.save(cliente); pedidoRepository.save(pedido); } else {
	 * pedido.setNomeDaFesta(interesseClienteFesta.getNomeFesta());
	 * pedido.setCliente(c); pedidoRepository.save(pedido); }
	 * 
	 * 
	 * if (result.hasErrors()) { return null; }
	 * 
	 * mv.setViewName("redirect:index#" + interesseClienteFesta.getNomeFesta());
	 * 
	 * return mv; }
	 */

}