package com.softcars.mx.services;

import com.google.gson.Gson;
import com.softcars.mx.core.UsuarioController;
import com.softcars.mx.model.Usuario;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author DarkAlekxx20
 * @Desc: Servicio para acceder a ellos por url.
 * @Date: 03/10/2024
 */
@Path("username")
public class UsuarioREST {

    @Path("sign-in")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertUser(@FormParam("userData") String userData) {
        String out = null;
        Gson gson = new Gson();
        Usuario u = null;
        UsuarioController uc = new UsuarioController();
        try {
            u = gson.fromJson(userData, Usuario.class);
            uc.sigin(u);
            out = "{\"Success\":\"Se guardo correctamente el usuario!\"}\n";
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"error\":\"Error en base de datos :(\"}\n";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("userData") @DefaultValue("") String userData) throws Exception {
        String out = null;
        Gson gson = new Gson();
        Usuario u = null;
        UsuarioController uc = new UsuarioController();
        try {
            u = gson.fromJson(userData, Usuario.class);
            u = uc.login(u.getUsername(), u.getPassword());
            if (u == null) {
                out = "{\"error\":\"Datos de credencial incorrectos!\"}\n";
            } else if (u != null && u.getEstatus() == 1) {
                out = "{\"success\":\"Bienvendio a SoftCars: " + u.getUsername() + "!\"}\n";
            } else if (u.getEstatus() != 1) {
                out = "{\"error\":\"El usuario esta con estatus inactivo!\"}\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"error\":\"Error en base de datos :(\"}\n";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
