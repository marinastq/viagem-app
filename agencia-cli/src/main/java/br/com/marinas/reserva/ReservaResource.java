package br.com.marinas.reserva;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.marinas.cliente.Cliente;
import br.com.marinas.cliente.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/reserva-cli")
public class ReservaResource {
    
    @Inject
    @RestClient
    ReservaService reservaService;

    @Inject
    @RestClient
    ClienteService clienteService;

    @GET
    @Path("newReserva")
    public Response newReserva(){

        Cliente cliente = clienteService.findById(1);
        //Cliente cliente = Cliente.of(1, "Remoto");
        Reserva reserva = Reserva.of(cliente.getId());

        return reservaService.newReserva(reserva);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reserva> getAll(){
        return reservaService.get();
    }
}
