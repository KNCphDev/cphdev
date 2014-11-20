package com.systematic.cphdev.happiness.api;


import com.systematic.cphdev.happiness.model.Vote;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class VoteRessourceTest {

    private VoteRessource voteRessource;

    @Before
    public void setup() {
        voteRessource = new VoteRessource();
    }

    @Test
    public void testAddVote() {
        voteRessource.addVote(new Vote(1));
    }

    @Test
    public void testGetAllVote() {
        List<Vote> all = voteRessource.all();

        Assert.assertThat(all.size(), CoreMatchers.not(0));
    }
}