package com.itemapi.apiItems.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itemapi.apiItems.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
    /*
     * Você precisa de um repository para acessar
     * e gerenciar os dados do banco de dados.
     * Repository é uma interface que oferecem métodos
     * para realizar operações de CRUD
     */
}
