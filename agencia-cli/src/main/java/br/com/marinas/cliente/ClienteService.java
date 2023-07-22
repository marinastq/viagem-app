package br.com.marinas.cliente;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RegisterRestClient(baseUri = "http://localhost:8181/cliente")
public interface ClienteService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newCliente(Cliente cliente);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findById")
    @Timeout(unit = ChronoUnit.SECONDS, value = 3)
    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker(
        requestVolumeThreshold = 4,
        failureRatio = .5,
        delay = 6000,
        successThreshold = 1
    )
    public Cliente findById(@QueryParam("id") long id);
    /*CircuitBreaker
        usado na verificacao se o servico esta com problemas e impedir a espera do retorno desse servico
         requestVolumeThreshold = 4, -> em um volume de 4 requições,
         failureRatio = .5,           -> se 50% dessas requisições falharem
         delay = 6000,                -> espera 6 segundos para tentar novamente acessar o serviço e as requisições nesse tempo caem no fallback automaticamente
         successThreshold = 1         -> depois dos 6 segundos, se 1 requisição der certo, sai desse fallback automatico

    */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> listAll();

    private Cliente fallback(long id){
        return Cliente.of(0, "");
    }
    
}
