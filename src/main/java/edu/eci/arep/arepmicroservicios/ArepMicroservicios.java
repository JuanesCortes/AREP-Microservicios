package edu.eci.arep.arepmicroservicios;

import edu.eci.arep.arepmicroservicios.connection.HttpConnectionA;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;




import static spark.Spark.*;


public class ArepMicroservicios {



    public static void main(String... args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        port(getPort());
        staticFiles.location("/files");
        get("/login", (req,res) -> {

            return HttpConnectionA.consultar("http://ec2-54-226-72-113.compute-1.amazonaws.com:4568/login?name="+req.queryParams("name")+"&pswd="+req.queryParams("pswd"));
        });
        get("/showWords", (req,res) -> {

            return HttpConnectionA.consultar("http://ec2-3-84-5-27.compute-1.amazonaws.com:4567/showWords");
        });
        post("/addWord", (req, res) -> {
            res.status(200);

            return HttpConnectionA.consultar("http://ec2-3-84-5-27.compute-1.amazonaws.com:4567/addWords");
        });
    }


    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
