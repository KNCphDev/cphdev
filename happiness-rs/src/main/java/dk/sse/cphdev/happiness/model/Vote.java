package dk.sse.cphdev.happiness.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

@Entity
public class Vote {
    @Id
    private ObjectId id;
    private int voteValue;
    private Date created = new Date();

    public Vote() {
    }

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