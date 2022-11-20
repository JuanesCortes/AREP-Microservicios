package edu.eci.arep.arepmicroservicios.model;

import com.google.gson.Gson;
import java.util.Properties;

/**
 *
 * @author juane
 */
public class makeTweet {

    public static Tweet createTweet(String json) {
        final Gson gson = new Gson();
        final Properties properties = gson.fromJson(json, Properties.class);
        String user = properties.getProperty("username");
        String tweetMessage = properties.getProperty("tweet");
        Tweet tweet = new Tweet(tweetMessage, java.time.LocalDate.now().toString(), user);
        return tweet;
    }
}
