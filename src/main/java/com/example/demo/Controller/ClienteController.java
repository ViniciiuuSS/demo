package com.example.demo.Controller;

import com.example.demo.Repository.ClienteRepository;
import com.example.demo.Model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
    @Autowired 
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/clientes/{cpf}")
    public Cliente getClienteByCpf(@PathVariable String cpf) {
        if(cpf == null || cpf.isEmpty()) {
            return null;
        }
        return clienteRepository.findByCpf(cpf);
    }

    @PostMapping("/clientes")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        if(cliente == null || cliente.getCpf() == null || cliente.getCpf().isEmpty() || cliente.getNome() == null || cliente.getNome().isEmpty()) {
            return null;
        }
        Cliente existingCliente = clienteRepository.findByCpf(cliente.getCpf());
        if(existingCliente != null) {
            return null;
        }
        return clienteRepository.save(cliente);
    }

    @PutMapping("/clientes/{clicod}")
    public Cliente updateCliente(@PathVariable Long clicod, @RequestBody Cliente cliente) {
        if(cliente.getCpf() == null || cliente.getCpf().isEmpty() || cliente == null || cliente.getNome() == null || cliente.getNome().isEmpty()) {
            return null;
        }
        Cliente existingCliente = clienteRepository.findById(clicod).orElse(null);
        if(existingCliente == null) {
            return null;
        }
        existingCliente.setNome(cliente.getNome());
        existingCliente.setCpf(cliente.getCpf());
        return clienteRepository.save(existingCliente);
    }

    @DeleteMapping("/clientes/{cpf}")
    public String deleteCliente(@PathVariable String cpf) {
        String message = "CPF Invalido";
        if(cpf == null || cpf.isEmpty()) {
            return message;
        }
        Cliente existingCliente = clienteRepository.findByCpf(cpf);
        if(existingCliente != null) {
            clienteRepository.delete(existingCliente);
            return "Cliente deletado com sucesso";
        }
        return message;
    }
}
