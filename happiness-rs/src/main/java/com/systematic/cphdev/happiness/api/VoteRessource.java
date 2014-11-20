package com.systematic.cphdev.happiness.api;

import com.systematic.cphdev.happiness.model.Vote;
import com.systematic.cphdev.happiness.persistence.DBConnectionManager;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("happiness")
public class VoteRessource {

    @POST
    @Path("vote")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Vote addVote(Vote vote) {
        DBConnectionManager.getInstance().getDatastore().save(vote);

        System.out.println("Number of votes: " + getVoteCount());
        System.out.println("Vote accepted: " + vote.getVoteValue());

        return vote;
    }

    @GET
    @Path("votes")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Vote> all() {
        return DBConnectionManager.getInstance().getDatastore().find(Vote.class).asList();
    }

    public long getVoteCount() {
        return DBConnectionManager.getInstance().getDatastore().getCount(Vote.class);
    }

}