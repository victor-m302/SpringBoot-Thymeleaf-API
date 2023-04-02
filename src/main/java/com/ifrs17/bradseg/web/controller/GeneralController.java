package com.ifrs17.bradseg.web.controller;

import com.ifrs17.bradseg.dominio.General;
import com.ifrs17.bradseg.service.GeneralService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "API rodando...";
    }

    @RequestMapping(value = "info/createusuario", method = RequestMethod.POST)
    public String createUsuario(@RequestBody General general){
        return generalService.createUsuario(general);
    }

    @RequestMapping(value = "info/readusuario", method = RequestMethod.GET)
    public List<General> readUsuario(){
        return generalService.readUsuario();
    }

    @RequestMapping(value = "info/updateusuario", method = RequestMethod.PUT)
    public String updateUsuario(@RequestBody General general){
        return generalService.updateUsuario(general);
    }

    @RequestMapping(value = "info/deleteusuario", method = RequestMethod.DELETE)
    public String deleteUsuario(@RequestBody General general){
        return generalService.deleteUsuario(general);
    }
}
