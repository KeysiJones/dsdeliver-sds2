package com.devsuperior.dsdeliver.repositories;

import java.util.List;

import com.devsuperior.dsdeliver.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //Método para retornar os pedidos com status pendente e que sejam ordenados pelo momento,
    //do mais antigo para o mais recente.

    //obj é um apelido. Order precisa ser exatamente igual ao nome da classe.
    //obj == Order neste caso

    @Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products "
    + "WHERE obj.status = 0 ORDER BY obj.moment ASC")
    List<Order> findOrdersWithProducts();
}
