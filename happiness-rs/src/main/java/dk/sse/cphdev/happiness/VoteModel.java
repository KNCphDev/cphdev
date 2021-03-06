package dk.sse.cphdev.happiness;

import dk.sse.cphdev.happiness.model.Vote;

import java.util.ArrayList;
import java.util.List;

public class VoteModel {
    private final List<Vote> votes = new ArrayList<Vote>();

    public Vote addVote(Vote vote) {
        votes.add(vote);
        return vote;
    }

    public int getNumberOfVotes() {
        return votes.size();
    }
}
