package br.com.marinas.reserva;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/reserva")
public class ReservaResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reserva> get(){
        return Reserva.listAll();
    } 

}
