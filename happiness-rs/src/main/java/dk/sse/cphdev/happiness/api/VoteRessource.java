package dk.sse.cphdev.happiness.api;

import dk.sse.cphdev.happiness.VoteModel;
import dk.sse.cphdev.happiness.model.Vote;
import dk.sse.cphdev.happiness.persistence.MongoConnectionManager;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
        return vote;
    }
    public  long getVotecount() {
        return MongoConnectionManager.getInstance().getDatastore().getCount(Vote.class);
    }
}