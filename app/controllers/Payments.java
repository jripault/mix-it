package controllers;

import com.paypal.adaptive.core.APICredential;
import play.mvc.Controller;
import com.paypal.adaptive.core.ClientDetails;

import java.io.IOException;

public class Payments extends Controller
{

  //Initialise the credential object with the Auctioneers API details
  protected static APICredential credentialObj = new APICredential();

  static
  {
    credentialObj.setAPIUsername("auct_1283803076_biz_api1gmail.com");
    credentialObj.setAPIPassword("1283803087");
    credentialObj.setSignature("A1ThkyYkfv73y1-pkHvwYb5lApH2AUmLylw849xAj9D3khBx7X3GlnAN");
    credentialObj.setAppId("APP-80W284485P519543T");
    credentialObj.setAccountEmail("auct_1283803076_biz@gmail.com");
  }

  public static void doPay(Long purchaseId) throws IOException
  {
    String senderEmail = "buy_1283807604_per@gmail.com";
  }
}