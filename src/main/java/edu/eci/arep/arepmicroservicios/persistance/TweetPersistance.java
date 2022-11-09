package edu.eci.arep.arepmicroservicios.persistance;

import edu.eci.arep.arepmicroservicios.model.Tweet;
import edu.eci.arep.arepmicroservicios.model.makeTweet;
import spark.Response;

import java.util.ArrayList;

/**
 *
 * @author juane
 */
public class TweetPersistance {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    
    
    public void addTweet(String tw){

        addTweet(makeTweet.createTweet(tw));
    }
    
    public void addTweet(Tweet tw){
        tweets.add(tw);
    }
    
    public ArrayList<Tweet> getAllTweets(){

        return this.tweets;
    }
}
