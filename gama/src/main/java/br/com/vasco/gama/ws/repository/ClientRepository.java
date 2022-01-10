package br.com.vasco.gama.ws.repository;

import br.com.vasco.gama.ws.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Integer> {

}
