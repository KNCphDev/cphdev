package org.glassfish.jersey.examples.helloworld.jaxrs;

import java.util.Date;

public class Vote {
    private int voteValue;
    private final Date created = new Date();

    public Vote(int voteValue) {
        this.voteValue = voteValue;
    }

    public int getVoteValue() {
        return voteValue;
    }


    public Date getCreated() {
        return created;
    }
}