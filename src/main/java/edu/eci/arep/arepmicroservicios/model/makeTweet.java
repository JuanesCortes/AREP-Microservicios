
package edu.eci.arep.arepmicroservicios.model;

/**
 *
 * @author juane
 */
public class makeTweet {
    public static Tweet createTweet(String json) {
        System.out.println(json);
        String user = "unknown";//json.replace("{\"username\":", "").replace("}", "");
        String tweetMessage = json.replace("{\"tweet\":", "").replace("}", "");
        Tweet tweet = new Tweet(tweetMessage, java.time.LocalDate.now().toString(), user);
        return tweet;
    }
}
