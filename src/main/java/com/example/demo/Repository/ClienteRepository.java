package com.example.demo.Repository;
import com.example.demo.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCpf(String cpf);
}
