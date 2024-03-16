package br.edu.unifacisa.lojaecommerce.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import lombok.Data;

@Entity
@Data
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cadastroNome;
    private String cadastroSenha;
    private String cadastroEmail;

    public String getCadastroEmail() {
        return cadastroEmail;
    }
    public void setCadastroEmail(String cadastroEmail) {
        this.cadastroEmail = cadastroEmail;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCadastroNome() {
        return cadastroNome;
    }

    public void setCadastroNome(String cadastroNome) {
        this.cadastroNome = cadastroNome;
    }

    public String getCadastroSenha() {
        return cadastroSenha;
    }

    public void setCadastroSenha(String cadastroSenha) {
        this.cadastroSenha = cadastroSenha;
    }

}
