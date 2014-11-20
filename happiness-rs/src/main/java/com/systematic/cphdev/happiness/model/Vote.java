package com.systematic.cphdev.happiness.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

@Entity
public class Vote {

    @Id
    private ObjectId id;
    private int voteValue;
    private Date created;

    public Vote() {
    }

    public Vote(int voteValue) {
        this.voteValue = voteValue;
        this.created = new Date();
    }

    public int getVoteValue() {
        return voteValue;
    }
}