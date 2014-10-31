package org.glassfish.jersey.examples.helloworld.jaxrs;

import java.util.ArrayList;
import java.util.List;

public class VoteModel {
    private final List<Vote> votes = new ArrayList<Vote>();

    public Vote addVote() {
        Vote vote = new Vote(1);
        votes.add(vote);
        return vote;
    }

    public int getNumberOfVotes() {
        return votes.size();
    }
}
