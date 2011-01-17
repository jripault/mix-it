package controllers;


public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        /*User user = User.find("byEmail", username).first();
        return user != null && user.password.equals(password);*/
      return "admin".equals(username) && "!JsLm2p2m0".equals(password);
    }


}