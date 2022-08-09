package com.example.jpah2demo.controller;

import com.example.jpah2demo.model.Cliente;
import com.example.jpah2demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        cliente.getEnderecos().forEach(endereco -> endereco.setCliente(cliente));
        cliente.getTelefones().forEach(telefone -> telefone.setCliente(cliente));

        Cliente clienteAdd = this.clienteRepository.save(cliente);

        return ResponseEntity.ok(clienteAdd);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        List<Cliente> clientes = this.clienteRepository.findAll();

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/findClientById/{id}")
    public Optional<Cliente> findClientById(@PathVariable("id") Long idClient) {
        return clienteRepository.findById(idClient);
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
//        Optional<Cliente> optional = this.clienteRepository.findById(idClient);
//        optional.ifPresent(this.clienteRepository::delete);

        clienteRepository.deleteById(idClient);
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        Optional<Cliente> optional = this.clienteRepository.findById(id);

        optional.ifPresent(cli -> {
            System.err.println("update");
            this.clienteRepository.save(cliente);
        });
    }
}
