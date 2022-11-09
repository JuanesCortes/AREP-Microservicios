package edu.eci.arep.arepmicroservicios;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.eci.arep.arepmicroservicios.model.Tweet;
import org.bson.Document;
import java.util.ArrayList;



public class MongoDB {

    MongoClientURI uri;
    MongoClient mongoCliente;

    public MongoDB() {
        uri=new MongoClientURI("mongodb+srv://user:arep@tweet.dxwm2io.mongodb.net/?retryWrites=true&w=majority");
        mongoCliente=new MongoClient(uri);
    }

    public void insertTweet(Tweet tweet){

        MongoDatabase db =mongoCliente.getDatabase("tweet");
        MongoCollection<Document> collection=db.getCollection("tweet");
        Document document=new Document();
        document.put("username",tweet.getUsername());
        document.put("tweet",tweet.getMensaje());
        document.put("fecha",tweet.getFecha());
        collection.insertOne(document);
    }

    public ArrayList<Tweet> getTweets(){
        MongoDatabase db =mongoCliente.getDatabase("tweet");
        MongoCollection<Document> collection=db.getCollection("tweet");
        FindIterable findIterable=collection.find();
        ArrayList<Document> listDocument=new ArrayList<Document>();
        ArrayList<Tweet> listTweets =new ArrayList<Tweet>();
        findIterable.into(listDocument);

        for (Document doc : listDocument){
            if(doc.get("username")!=null && doc.get("tweet")!=null && doc.get("fecha")!=null ){
                listTweets.add(new Tweet((String) doc.get("tweet"),(String) doc.get("fecha"),(String) doc.get("username")));
            }
        }

        return listTweets;
    }

}
