package com.bluffware;

import java.io.*;
import java.net.*;

// Pivotal Tracker api Client
public class JPiv {

  public JPiv() { }

  // add a bug to the pivotal tracker
  public void itate(String name, String description){
 
      HttpURLConnection connection = null;
      URL serverAddress = null;

      int projectnum = 90097;
      String user = "my_username";
      String token = "deadbeefcafebabe"
 
      try {
          serverAddress = new URL("http://www.pivotaltracker.com/services/v2/projects/" + projectnum + "/stories");

          connection = null;
        
          connection = (HttpURLConnection)serverAddress.openConnection();
          connection.setRequestMethod("POST");
          connection.addRequestProperty("X-Trackertoken", token);
          connection.setDoOutput(true);
          connection.setReadTimeout(10000);
                    
          connection.connect();

          PrintStream ps = new PrintStream(connection.getOutputStream());  
          ps.print("story[name]=[" + name + "]" +
                      "&story[requested_by]=" + user +
                      "&story[description]=" + description +
                      "&story[story_type]=bug");

          InputStream is = connection.getInputStream();   

      } catch (Exception e) {
        System.out.println(e);
      }
      finally {
          connection.disconnect();
          connection = null;
      }
  }
}
