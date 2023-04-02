package com.ifrs17.bradseg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifrs17.bradseg.dominio.General;
import com.ifrs17.bradseg.repository.GeneralRepository;


@Service
public class GeneralService {

    @Autowired
    private GeneralRepository generalRepository;

    @Transactional
    public String createUsuario(General general){
        try {
            if (!generalRepository.existsByEmail(general.getEmail())){
            	general.setId(null == generalRepository.findMaxId()? 0 : generalRepository.findMaxId() + 1);
                generalRepository.save(general);
                return "Usuario inserido com sucesso.";
            }else {
                return "Usuario já existe na base de dados.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<General> readUsuario(){
        return generalRepository.findAll();
    }

    @Transactional
    public String updateUsuario(General general){
        if (generalRepository.existsByEmail(general.getEmail())){
            try {
                List<General> usuarios = generalRepository.findByEmail(general.getEmail());
                usuarios.stream().forEach(s -> {
                	General studentToBeUpdate = generalRepository.findById(s.getId()).get();
                    studentToBeUpdate.setName(general.getName());
                    studentToBeUpdate.setEmail(general.getEmail());
                    generalRepository.save(studentToBeUpdate);
                });
                return "Usuario atualizado.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Usuario não existe na base de dados.";
        }
    }

    @Transactional
    public String deleteUsuario(General general){
        if (generalRepository.existsByEmail(general.getEmail())){
            try {
                List<General> usuarios = generalRepository.findByEmail(general.getEmail());
                usuarios.stream().forEach(s -> {
                	generalRepository.delete(s);
                });
                return "General removido com sucesso.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "General não existe";
        }
    }
}
