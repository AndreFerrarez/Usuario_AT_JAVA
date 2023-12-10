package org.example.service;

import org.example.dto.output.UsuarioDTOOutput;
import org.example.dto.input.UsuarioDTOInput;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



public class UsuarioService {

    private final List<UsuarioDTOOutput> listaUsuarios = new ArrayList<>();
    private final ModelMapper modelMapper = new ModelMapper();

    public Collection<UsuarioDTOOutput> listarUsuarios() {
        Collection<UsuarioDTOOutput> listaUsuarioDTOOutputs = modelMapper.map(listaUsuarios, List.class);
        return listaUsuarioDTOOutputs;
    }

    public UsuarioDTOOutput obterUsuario(long id) {
        UsuarioDTOOutput usuarioDTOOutput = modelMapper.map(encontrarUsuarioPorId(id), UsuarioDTOOutput.class);
        return usuarioDTOOutput;
    }

    public void adicionarUsuario(UsuarioDTOInput usuarioDTOInput) {
        UsuarioDTOOutput usuarioDTOOutput = modelMapper.map(usuarioDTOInput, UsuarioDTOOutput.class);
        listaUsuarios.add(usuarioDTOOutput);
    }

    public void alterarUsuario(UsuarioDTOInput usuarioDTOInput) {
        int index = encontrarIndexUsuarioPorId(usuarioDTOInput.getId());
        if (index != -1) {
            UsuarioDTOOutput usuarioExistente = listaUsuarios.get(index);
            modelMapper.map(usuarioDTOInput, usuarioExistente);
        }
    }

    public void removerUsuario(long id) {
        int index = encontrarIndexUsuarioPorId(id);
        if (index != -1) {
            listaUsuarios.remove(index);
        }
    }

    private UsuarioDTOOutput encontrarUsuarioPorId(long id) {
        for (UsuarioDTOOutput usuario : listaUsuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    private int encontrarIndexUsuarioPorId(long id) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
