package co.edu.escuelaing.sparkdockerdemolive;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static spark.Spark.*;


//co.edu.escuelaing.sparkdockerdemolive.SparkWebServer.java
public class SparkWebServer {

    //
    //server.port=8081
    //
    //mongodb.database=tasks
    //mongodb.connection.string=mongodb://localhost:27017
    private static ArrayList<Tweet> words;

    public static void main(String... args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        words = new ArrayList<>();
        port(getPort());
        System.out.println(getPort());
        staticFiles.location("/files");
        get("hello", (req,res) -> "Hello Docker!");
        get("/home", (req,res) -> {
            return "{\"confirm\":" + "ok" + "}";
        });
        get("/showWords", (req,res) -> {
            String gson = new Gson().toJson(words);
            return gson;
        });
        post("/addWord", (req, res) -> {
            res.status(200);
            Tweet tweet = createTweet(req.body());
            words.add(tweet);
            return words;
        });
    }

    public static Tweet createTweet(String json) {
        String user = "unknown";//json.replace("{\"username\":", "").replace("}", "");
        String tweetMessage = json.replace("{\"tweet\":", "").replace("}", "");
        Tweet tweet = new Tweet(tweetMessage, java.time.LocalDate.now().toString(), user);
        return tweet;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
