package br.com.marinas.cliente;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Cliente extends PanacheEntity{
    //panache gerencia ID no PanacheEntity
    public String nome;

}
