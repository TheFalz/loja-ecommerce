package br.edu.unifacisa.lojaecommerce.repositorios;

import br.edu.unifacisa.lojaecommerce.entidades.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
    Cadastro findByCadastroNome(String login);
}
