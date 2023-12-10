package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.UsuarioController;
import org.example.service.UsuarioService;
public class UsuarioMain {
    public static void main(String[] args)  {

        new UsuarioController(new UsuarioService(), new ObjectMapper()).respostasRequisicoes();
    }

}