package com.softcars.mx.service;

import com.google.gson.Gson;
import com.softcars.mx.core.UsuarioController;
import com.softcars.mx.model.Usuario;
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

    @Path("insertUser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertUser(@FormParam("UserData") String userData) {
        String out = null;
        Gson gson = new Gson();
        Usuario u = null;
        UsuarioController uc = new UsuarioController();
        try {
            uc.sigin(u);
            u = gson.fromJson(userData, Usuario.class);
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"error\":\"Error en base de datos :(\"}\n";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
