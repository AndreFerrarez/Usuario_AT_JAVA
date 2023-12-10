package org.example.dto.input;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTOInput {

    private int id;
    private String nome;
    private String senha;

    public UsuarioDTOInput(String nome, String senha) {
    }

//    @Override
//    public String toString() {
//        return "UsuarioDTOOutput{" +
//                "nome='" + nome + '\'' +
//                ", senha='" + senha + '\'' +
//                '}';
//    }
}
