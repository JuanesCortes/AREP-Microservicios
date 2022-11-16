package edu.eci.arep.arepmicroservicioslogin.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.eci.arep.arepmicroservicioslogin.model.User;
import org.bson.Document;
import java.util.ArrayList;



public class MongoDB {

    MongoClientURI uri;
    MongoClient mongoCliente;

    public MongoDB() {
        uri=new MongoClientURI("mongodb+srv://user:arep@tweet.dxwm2io.mongodb.net/?retryWrites=true&w=majority");
        mongoCliente=new MongoClient(uri);
    }

    public ArrayList<User> getUsers(){
        MongoDatabase db =mongoCliente.getDatabase("tweet");
        MongoCollection<Document> collection=db.getCollection("login");
        FindIterable findIterable=collection.find();
        ArrayList<Document> listDocument=new ArrayList<Document>();
        ArrayList<User> users =new ArrayList<User>();
        findIterable.into(listDocument);

        for (Document doc : listDocument){
            users.add(new User((String) doc.get("name"),(String) doc.get("pswd")));
            
        }

        return users;
    }

}
