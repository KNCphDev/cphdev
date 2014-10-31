package org.glassfish.jersey.examples.helloworld.jaxrs;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.sun.net.httpserver.HttpServer;

public class HelloWorldTest {

    @Test
    public void testVoteResponse() throws Exception {
        HttpServer server = App.startServer();

        WebTarget target = ClientBuilder.newClient().target(App.getBaseURI() + "happiness/vote");
        String response = target.request(MediaType.APPLICATION_JSON).post(Entity.text(""), String.class);
        assertTrue(response.contains("vote"));
        assertTrue(response.contains("created"));

        server.stop(0);
    }
}
