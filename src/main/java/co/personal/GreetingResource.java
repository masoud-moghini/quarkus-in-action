package co.personal;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.security.Principal;
import java.util.Objects;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "greetings")
    String greeting;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greeting;
    }




    @GET
    @Path("/whoami")
    @Produces(MediaType.TEXT_PLAIN)
    public String whoAmI(@Context SecurityContext securityContext){
        Principal userPrincipal = securityContext.getUserPrincipal();
        if (Objects.nonNull(userPrincipal))
            return userPrincipal.getName();
        else
            return "ananymous";
    }

}
