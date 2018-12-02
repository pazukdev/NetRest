package com.rest.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/users")
public class UserResource {

    private UserDAO dao = new UserDAO();

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String findAll() throws SQLException {
        return "<html>" + dao.findAll() + "</html>" + "<p/>"
                + "<button onclick=\"location.href='../../'\">Back</button>";
    }

    @GET
    @Path("search/{query}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_HTML })
    public String findByName(@PathParam("query") String query) throws SQLException {
        return "<html>" + dao.findByName(query) + "</html>" + "<p/>"
                + "<button onclick=\"location.href='../../../'\">Back</button>";
    }


}