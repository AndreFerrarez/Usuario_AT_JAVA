package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.input.UsuarioDTOInput;
import org.example.dto.output.UsuarioDTOOutput;
import org.example.service.UsuarioService;

import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Response;
import java.util.Collection;

public class UsuarioController {

    private final UsuarioService usuarioService;
    private final ObjectMapper objectMapper;

    public UsuarioController(UsuarioService usuarioService, ObjectMapper objectMapper) {
        this.usuarioService = usuarioService;
        this.objectMapper = objectMapper;
    }
    public void respostasRequisicoes() {

        spark.Spark.get("/usuarios", (req, res) -> {
            Collection<UsuarioDTOOutput> usuarios = usuarioService.listarUsuarios();
            return toJsonResponse(res, usuarios, 200);
        }, objectMapper::writeValueAsString);


        spark.Spark.get("/usuarios/:id", (req, res) -> {
            long id = Long.parseLong(req.params(":id"));
            UsuarioDTOOutput usuario = usuarioService.obterUsuario(id);
            return toJsonResponse(res, usuario, 200);
        }, objectMapper::writeValueAsString);


        spark.Spark.delete("/usuarios/:id", (req, res) -> {
            long id = Long.parseLong(req.params(":id"));
            usuarioService.removerUsuario(id);
            return "";
        });

        spark.Spark.post("/usuarios", (req, res) -> {
            UsuarioDTOInput usuarioDTOInput = objectMapper.readValue(req.body(), UsuarioDTOInput.class);
            usuarioService.adicionarUsuario(usuarioDTOInput);
            res.status(201);
            return "";
        });

        spark.Spark.put("/usuarios", (req, res) -> {
            UsuarioDTOInput usuarioDTOInput = objectMapper.readValue(req.body(), UsuarioDTOInput.class);
            usuarioService.alterarUsuario(usuarioDTOInput);
            return "";
        });
    }
    private String toJsonResponse(Response response, Object data, int statusCode) throws JsonProcessingException {
        response.status(statusCode);
        response.type("application/json");
        return objectMapper.writeValueAsString(data);
    }
}
