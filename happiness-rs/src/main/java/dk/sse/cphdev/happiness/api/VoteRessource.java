package dk.sse.cphdev.happiness.api;

import dk.sse.cphdev.happiness.VoteModel;
import dk.sse.cphdev.happiness.model.Vote;
import dk.sse.cphdev.happiness.persistence.MongoConnectionManager;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("happiness")
public class VoteRessource {

    private VoteModel happyModel = new VoteModel();

    @POST
    @Path("vote")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Vote addVote(Vote vote) {
        MongoConnectionManager.getInstance().getDatastore().save(vote);

        System.out.println("Number of votes: " + getVotecount());
        System.out.println("Vote accepted: " + vote.getVoteValue());
        System.out.println("Vote created: " + vote.getCreated());

        return vote;
    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Vote> getAll() {
        return MongoConnectionManager.getInstance().getDatastore().find(Vote.class).asList();
    }

    public  long getVotecount() {
        return MongoConnectionManager.getInstance().getDatastore().getCount(Vote.class);
    }
}