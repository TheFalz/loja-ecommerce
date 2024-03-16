package br.edu.unifacisa.lojaecommerce.repositorios;

import br.edu.unifacisa.lojaecommerce.entidades.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos,Long>{
}
