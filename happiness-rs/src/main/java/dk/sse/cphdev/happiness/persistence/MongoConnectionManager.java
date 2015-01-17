package dk.sse.cphdev.happiness.persistence;

import com.mongodb.MongoClient;
import dk.sse.cphdev.happiness.model.Vote;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;

/**
 * Created by meg on 28-11-2014.
 */
public class MongoConnectionManager {
    private static final MongoConnectionManager instance = new MongoConnectionManager();
    private Datastore datastore;
    private static final String DB_NAME = "happiness";

    public static MongoConnectionManager getInstance() {
        return instance;
    }

    private MongoConnectionManager() {
        try {
            MongoClient mongoClient = new MongoClient();
            mongoClient.getDB(DB_NAME);
            Morphia morphia = new Morphia();
            morphia.map(Vote.class);
            datastore = morphia.createDatastore(mongoClient, DB_NAME);
        } catch (UnknownHostException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Datastore getDatastore() {

        return datastore;
    }
}
