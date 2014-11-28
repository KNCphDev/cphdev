package dk.sse.cphdev.happiness;

import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertTrue;

public class VoteResourceTest {

    @Test
    public void testVoteResponse() throws Exception {
        HttpServer server = App.startServer();

        WebTarget target = ClientBuilder.newClient().target(App.getBaseURI() + "happiness/vote");

        String response = target.request().post(Entity.entity("{\"voteValue\":1}", MediaType.APPLICATION_JSON), String.class);
        assertTrue(response.contains("vote"));
        assertTrue(response.contains("created"));

        server.stop(0);
    }
}
