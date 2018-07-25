package br.com.julio.springmvc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.julio.springmvc.model.Festa;
import br.com.julio.springmvc.model.PedidoDTO;
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
	@GetMapping(value = "/admin")
	public ModelAndView exibirAdmin() {
		return new ModelAndView("admin");
	}
	
	/*@GetMapping(value = "/login")
	public ModelAndView exibirLogin() {
		return new ModelAndView("login");
	}*/

	@RequestMapping(value = { "/index" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView index() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mv = new ModelAndView("index");
		List<Festa> festas = festaRepository.findAll();
		for(Festa f : festas) {
			
			//Tema t = f.getTema();
			//List<Foto> fs = t.getFotos();
			System.out.println("festas no controller " +f.getNome());
		}
		mv.addObject("festas", festas);
		return mv;
	}
	/*@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}*/

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
	@PostMapping(value = "/pedido")
	@ResponseBody
	public void savePedido(@ModelAttribute @Valid PedidoDTO pedido, BindingResult result) {

	     
	     System.out.println("cheguei"); 
	     
	     if(result.hasErrors()){
	         
	         //Get error message
	         Map<String, String> errors = result.getFieldErrors().stream()
	               .collect(
	                     Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
	                 );
	         
	         //respone.setValidated(false);
	         //respone.setErrorMessages(errors);
	      }else{
	         // Implement business logic to save employee into database
	         //..
	         //respone.setValidated(true);
	         //respone.setEmployee(employee);
	    	  System.out.println("ok");
	      }
	     
	     
	}
}