
package edu.eci.arep.arepmicroservicioslogin.login;

import edu.eci.arep.arepmicroservicioslogin.database.MongoDB;
import edu.eci.arep.arepmicroservicioslogin.model.User;

/**
 *
 * @author juane
 */
public class Login {
    
    private static MongoDB db = new MongoDB();
    
    public boolean loggear(String user, String pswd){
        boolean valid = false;
        for (User i :db.getUsers()){
            if(i.getName().equals(user) && i.getPswd().equals(pswd)){
                valid = true;
            }
        }
        return valid;
    }
}
