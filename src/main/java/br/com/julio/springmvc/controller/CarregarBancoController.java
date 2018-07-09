package br.com.julio.springmvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.julio.springmvc.model.Festa;
import br.com.julio.springmvc.model.Foto;
import br.com.julio.springmvc.model.Tema;
import br.com.julio.springmvc.repository.FestaRepository;
import br.com.julio.springmvc.repository.FotoRepository;
import br.com.julio.springmvc.repository.TemaRepository;

@RestController
public class CarregarBancoController
{
  @Autowired
  private ServletContext servletContext;
  private static final String menina = "menina";
  private static final String menino = "menino";
  private static final String unisex = "unisex";
  private static final String adulto = "adulto";
  List<Festa> festasNovas;
  List<Festa> festasExistentes;
  private String sexo;
  private boolean flag_is_boy = false;
  private boolean flag_is_girl = false;
  private boolean flag_is_unisex = false;
  private boolean flag_is_old = false;
  
  @Autowired
  private FestaRepository festaRepository;
  
  @Autowired
  private FotoRepository fotoRepository;
  
  @Autowired
  private TemaRepository temaRepository;
  
  //public CarregarBancoController() {}
  
  @RequestMapping(value="/loadbase", method=RequestMethod.GET)
  public ModelAndView save()
  {
    ModelAndView mv = new ModelAndView("carregarbanco");
    
    festasNovas = new ArrayList();
    festasExistentes = new ArrayList();
    
    try
    {
      System.out.println(servletContext.getContextPath());
      
      Set<String> paths = servletContext.getResourcePaths("/WEB-INF/images/festas/");
      System.out.println("numero de festas: " + paths.size());
      if (paths != null) {
        for (String p : paths) {
          String[] festas = p.split("/");
          System.out.println(">>>>>>>>>>>>>>>>> " + festas[(festas.length - 1)]);
          
          String nomeFesta = festas[(festas.length - 1)];
          

          Festa fst = festaRepository.findByNome(nomeFesta);
          if (fst == null)
          {
            Set<String> fotos = servletContext.getResourcePaths("/WEB-INF/images/festas/" + festas[(festas.length - 1)]);
            List<Foto> nomesFotos = new ArrayList();
            for (String f : fotos) {
              String[] foto = f.split("/");
              System.out.println(">>>>>> " + foto[(foto.length - 1)]);
              String nomeFoto = foto[(foto.length - 1)];
              
              if (nomeFoto.equals("unisex")) {
                flag_is_unisex = true;
              } else if (nomeFoto.equals("menina")) {
                flag_is_girl = true;
              } else if (nomeFoto.equals("menino")) {
                flag_is_boy = true;
              } else if (nomeFoto.equals("adulto")) {
                flag_is_old = true;
              } else {
                Foto fotoSalva = saveFoto(nomeFoto);
                nomesFotos.add(fotoSalva);
              }
            }
            Tema temaSalvo = saveTema(nomesFotos, nomeFesta);
            
            if (flag_is_unisex) {
              sexo = "U";
              System.out.println(nomeFesta + " eh " + sexo);
            }
            else if (flag_is_girl) {
              sexo = "F";
              System.out.println(nomeFesta + " eh " + sexo);
            }
            else if (flag_is_boy) {
              sexo = "M";
              System.out.println(nomeFesta + " eh " + sexo);
            }
            else if (flag_is_old) {
              sexo = "A";
              System.out.println(nomeFesta + " eh " + sexo);
            }
            
            Festa festaSalva = saveFesta(temaSalvo, nomeFesta, sexo);
            
            festasNovas.add(festaSalva);
            flag_is_unisex = false;
            flag_is_boy = false;
            flag_is_girl = false;
            flag_is_old = false;
          }
          else {
            festasExistentes.add(fst);
          }
        }
      }
    } catch (Exception e) {
      return null;
    }
    mv.addObject("festasExistentes", festasExistentes);
    mv.addObject("festasNovas", festasNovas);
    return mv;
  }
  
  private Festa saveFesta(Tema tema, String nomeFesta, String sexo)
  {
    Festa festa = new Festa();
    festa.setNome(nomeFesta);
    festa.setTema(tema);
    festa.setSexo(sexo);
    festaRepository.save(festa);
    return festa;
  }
  
  private Tema saveTema(List<Foto> fotos, String nomeFesta)
  {
    Tema tema = new Tema();
    tema.setNome(nomeFesta);
    tema.setFotos(fotos);
    temaRepository.save(tema);
    return tema;
  }
  
  private Foto saveFoto(String nomeFoto) {
    Foto foto = new Foto();
    foto.setNomeFoto(nomeFoto);
    fotoRepository.save(foto);
    return foto;
  }
  
  public List<Festa> getFestasExistentes()
  {
    return festasExistentes;
  }
  
  public void setFestasExistentes(List<Festa> festasExistentes) {
    this.festasExistentes = festasExistentes;
  }
  
  public List<Festa> getFestasNovas() {
    return festasNovas;
  }
  
  public void setFestasNovas(List<Festa> festasNovas) {
    this.festasNovas = festasNovas;
  }
}
