package br.com.vasco.gama.ws.controller;

import br.com.vasco.gama.ws.model.Cliente;
import br.com.vasco.gama.ws.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    //End Points
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/clientes",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> cadatrar(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clientService.preencherCliente(cliente);
        return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/clientes",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> buscarTodos() {
        Collection<Cliente> clientes = null;
        try {
            clientes = clientService.listaClientes();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/clientes/{id}")
    public ResponseEntity<Cliente> excluir(@PathVariable Integer id) {
        Cliente clienteSalvo = clientService.buscaPorId(id);
        if (clienteSalvo != null && clienteSalvo.getId() > 0) {
            clientService.remover(clienteSalvo);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/clientes",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clientService.alterar(cliente);
        return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.OK);
    }

}
