
package edu.eci.arep.arepmicroservicioslogin;


import edu.eci.arep.arepmicroservicioslogin.login.Login;
import static spark.Spark.*;
/**
 *
 * @author juane
 */
public class ArepMicroserviciosLogin {
    
    private static Login login = new Login();

    public static void main(String[] args) {
        port(getPort());
        get("/login", (req,res) -> {
            return "{ \"name\" :\""+req.queryParams("name")+"\", \"status\" : \" "+login.loggear(req.queryParams("name"), req.queryParams("pswd"))+"\"}";
        });
    }
    
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }
}
