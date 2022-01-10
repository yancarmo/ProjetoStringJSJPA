package br.com.vasco.gama.ws.service;

import br.com.vasco.gama.ws.model.Cliente;
import br.com.vasco.gama.ws.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    Map<Integer, Cliente> clientes = new HashMap<>();
    Integer geradorId = 1;

    //Simulação Banco de Dados
    public Cliente preencherCliente(Cliente cliente) {
        cliente.setId((int) clientRepository.count() + 1);
        return cliente;
    }

    public Collection<Cliente> listaClientes() {
        return clientRepository.findAll();
    }

    public void remover(Cliente cliente) {
        clientRepository.delete(cliente);
    }

    public Cliente buscaPorId(Integer id) {
        return clientRepository.getById(id);
    }

    public Cliente alterar(Cliente cliente) {
        clientRepository.save(cliente);
        return cliente;
    }

}
