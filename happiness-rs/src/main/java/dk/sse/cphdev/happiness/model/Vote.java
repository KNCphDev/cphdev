package dk.sse.cphdev.happiness.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

@Entity
public class Vote {
    private int voteValue;
    private Date created;
    @Id
    private ObjectId id;
    public Vote() {

    }

    public Vote(int voteValue) {
        this.voteValue = voteValue;
        this.created = new Date();
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