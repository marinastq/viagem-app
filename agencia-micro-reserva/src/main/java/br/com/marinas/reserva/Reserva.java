package br.com.marinas.reserva;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Reserva extends PanacheEntity{
    
    public long idCliente;

}
