package org.glassfish.jersey.examples.helloworld.jaxrs;

import javax.inject.Singleton;
import javax.ws.rs.*;
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
        System.out.println("Number of votes: " + happyModel.getNumberOfVotes());
        System.out.println("Vote accepted: " + vote.getVoteValue());
        return happyModel.addVote(vote);
    }
}