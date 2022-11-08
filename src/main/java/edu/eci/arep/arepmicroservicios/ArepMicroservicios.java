package edu.eci.arep.arepmicroservicios;

import edu.eci.arep.arepmicroservicios.model.Tweet;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.google.gson.Gson;
import edu.eci.arep.arepmicroservicios.model.makeTweet;
import edu.eci.arep.arepmicroservicios.persistance.TweetPersistance;

import java.util.ArrayList;


import static spark.Spark.*;


//co.edu.escuelaing.sparkdockerdemolive.SparkWebServer.java
public class ArepMicroservicios {

    //
    //server.port=8081
    //
    //mongodb.database=tasks
    //mongodb.connection.string=mongodb://localhost:27017
    
    private static TweetPersistance twPersistance = new TweetPersistance();

    public static void main(String... args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        port(getPort());
        staticFiles.location("/files");
        get("/showWords", (req,res) -> {
            String gson = new Gson().toJson(twPersistance.getAllTweets());
            return gson;
        });
        post("/addWord", (req, res) -> {
            res.status(200);
            twPersistance.addTweet(req.body());
            return twPersistance.getAllTweets();
        });
    }


    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
