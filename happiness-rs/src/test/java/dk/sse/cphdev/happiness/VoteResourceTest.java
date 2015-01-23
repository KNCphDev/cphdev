package dk.sse.cphdev.happiness;

import com.sun.net.httpserver.HttpServer;
import dk.sse.cphdev.happiness.model.Vote;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

public class VoteResourceTest {

    private HttpServer server;

    @Test
    public void testVoteResponse() throws Exception {
        String response = addVote();

        Assert.assertTrue(response.contains("vote"));
        Assert.assertTrue(response.contains("created"));
    }


    @Test
    public void testGetAllVotes() throws IOException {
        addVote();
        List<Vote> votes = getAllVotes();

        Assert.assertThat(votes.size(), CoreMatchers.not(0));
    }

    private String addVote() {
        WebTarget target = ClientBuilder.newClient().target(App.getBaseURI() + "happiness/vote");

        return target.request().post(Entity.entity("{\"voteValue\":1}", MediaType.APPLICATION_JSON), String.class);
    }

    private List<Vote> getAllVotes() {
        WebTarget target = ClientBuilder.newClient().target(App.getBaseURI() + "happiness/all");

        return (List<Vote>)target.request().get(List.class);
    }

    @Before
    public void setup() throws IOException {
        server = App.startServer();
    }

    @After
    public void teardown() {
        server.stop(0);
    }
}
