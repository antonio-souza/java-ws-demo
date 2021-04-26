package br.com.aaas.jwsdemo;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.UnauthorizedException;


@Path("/mensagem")
@Produces(MediaType.APPLICATION_JSON)
@SuppressWarnings("deprecation")
public class MensagemEndPoint { 
  
  @Inject
  private MensagemService mensagemService;
  
  /**
   * Envia uma mensagem de Bom Dia para uma pessoa.
   * 
   * @return Uma lista com a mensagem.
   */
  @GET
  @Path("/bomdia")
  @Produces("application/json; charset=UTF-8")
  public Response enviarBomDia(final @QueryParam("nome") String nome) {
    
    List<String> lista = null;
    try {      
      lista = mensagemService.enviarBomDia(nome);
      
    } catch (UnauthorizedException excecao) {
      return Response.status(Response.Status.UNAUTHORIZED).build();
      
    } catch (IllegalArgumentException excecao) {
      return Response.status(Response.Status.BAD_REQUEST).build();
      
    } catch (Exception excecao) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    return Response.status(Response.Status.OK).entity(lista).build();
  }
}
