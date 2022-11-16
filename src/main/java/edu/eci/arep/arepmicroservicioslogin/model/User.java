
package edu.eci.arep.arepmicroservicioslogin.model;

/**
 *
 * @author juane
 */
public class User {
    private String name;
    private String pswd;
    
    public User(String name, String pswd){
        this.name = name;
        this.pswd = pswd;
    }

    public String getName() {
        return name;
    }

    public String getPswd() {
        return pswd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
    
}
