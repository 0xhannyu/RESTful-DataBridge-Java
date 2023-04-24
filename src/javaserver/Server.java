package javaserver;

import static spark.Spark.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
    	
    	System.out.println("CONNECT YOUR PC TO MOBILE HOTSPOT\n"+
    					   "Open http://<your-ipv4>:4567/home in your mobile browser.");
    	
    	Server ob = new Server();
    	
    	get("/home", (req, res) -> "/mtc/:data - for sending data to pc, replace 'data' with your Data.<br>" +
    							   "/take - send data to phone browser." +
    							   "<br><br>To Get IPv4<br>" +
    							   "- Open terminal<br>" +
    							   "- type 'ipconfig'<br>" +
    							   "- copy the IPv4 Address!" +
    							   "<br> (ik you wont be here without it)");
    	
    	
    	
    	//RECIEVE DATA FROM MOBILE
    	
    	get("/mtc/:data", (req, res) -> {
    		
    		System.out.println(req.params(":data"));
    		return 777;
    	});
    	
    	
    	//SEND DATA FROM PC TO BROWSER (PHONE)
    	
    	get("/take", (req, res) -> {
    		
    		String data = ob.giveData();
    		res.body(data);
    		return data;
    	});
    	
    	
    }
    
    String giveData() {
    	
    	System.out.println("Provide the link for the txt file...");
    	Scanner scr = new Scanner(System.in);
    	String path = scr.nextLine().replace("\\", "\\\\").replace("\"", "");
    	String data = "";
    	
    	try {
    		
    		scr = new Scanner(new File(path));
    		
    		while(scr.hasNextLine())
    			data += scr.nextLine() + "<br>";
    		
    		scr.close();
    		
    		return data;
    		
    	} catch (Exception fnfEx) { System.out.println(fnfEx + " : Maybe path error?"); }
    	
    	return "000";
    }
}
