package org.glassfish.jersey.examples.helloworld.jaxrs;

import java.util.Date;

public class Vote {
    private int voteValue;
    private final Date created = new Date();

    public Vote() {
    }

    public Vote(int voteValue) {
        this.voteValue = voteValue;
    }

    public int getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(int voteValue) {
        this.voteValue = voteValue;
    }

    public Date getCreated() {
        return created;
    }
}