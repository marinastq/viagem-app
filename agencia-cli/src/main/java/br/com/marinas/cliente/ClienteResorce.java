package br.com.marinas.cliente;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente-cli")
public class ClienteResorce {
    
    @Inject
    @RestClient
    ClienteService clienteservice;
    
    @GET
    @Path("newCliente")
    public Response newCliente(){
        Cliente cliente = Cliente.of("Remoto");

        Response response = clienteservice.newCliente(cliente);

        return response;
    }

    @GET
    public List<Cliente> listAll(){
        return clienteservice.listAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findById")
    public Cliente findById(@QueryParam("id") long id){
        return clienteservice.findById(id);
    }
}
