import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Threads extends Thread{

	int start;
	int end;
	IP [] myArray;
	public Threads(int start, int end, IP [] myArray)
	{
		this.start = start;
		this.end = end;
		this.myArray = myArray;
	}
	@Override
	public void run() 
    { 
		for(int i = start; i < end; i++) {
			   
	        String pingCmd = "ping " + myArray[i].getIP();
	        System.out.println ("Thread " + Thread.currentThread().getId() + ": " + pingCmd); 
	        try {
	            Runtime r = Runtime.getRuntime();
	            Process p = r.exec(pingCmd);
	
	            BufferedReader in = new BufferedReader(new
	            InputStreamReader(p.getInputStream()));
	            String inputLine;
	            while ((inputLine = in.readLine()) != null) {     
	                if( inputLine.indexOf("Average = ") != -1)
	                myArray[i].setLatency(inputLine.substring(inputLine.indexOf("Average = ") + 10)); 
	            }
	            in.close();
	
	        } catch (IOException e) {
	            System.out.println(e);
	        }	 
		}
    } 
	
}
