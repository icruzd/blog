/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jugareto.blog.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 *
 * @author icruz
 */
@Controller
@RequestMapping("/")
public class InicioController {
    private static final Logger log= LoggerFactory.getLogger(InicioController.class);
    
    @RequestMapping
    public String inicio(Model model){
        log.info("Mostrando pagina de inicio");
        model.addAttribute("mensaje", "Hola desde inicio controller");
    return "inicio/index";
    }
}
