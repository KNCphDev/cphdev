package com.systematic.cphdev.happiness.persistence;

import com.mongodb.MongoClient;
import com.systematic.cphdev.happiness.model.Vote;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;

public class DBConnectionManager {

    private static final DBConnectionManager instance = new DBConnectionManager();

    private static final String DBNAME = "happiness";
    private final Datastore datastore;

    public static DBConnectionManager getInstance() {
        return instance;
    }

    private DBConnectionManager() {
        try {
            MongoClient mongoClient = new MongoClient();
            mongoClient.getDB(DBNAME);

            Morphia morphia = new Morphia();
            morphia.map(Vote.class);
            datastore = morphia.createDatastore(mongoClient, DBNAME);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public Datastore getDatastore() {
        return datastore;
    }
}