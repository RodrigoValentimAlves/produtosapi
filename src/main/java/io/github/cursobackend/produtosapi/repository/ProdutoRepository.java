package io.github.cursobackend.produtosapi.repository;

import io.github.cursobackend.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

}
