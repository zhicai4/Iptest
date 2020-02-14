import java.io. *;
import java.util.ArrayList;

public class IParray{

	
	private static IP[] myArray = new IP[20];
	private static int size = 0;
	private static int numThreads = 5;
	
	public IParray()
	{
		
	}
	public void addIP(String ip)
	{
		myArray[size] = new IP(ip);
		size ++;
	}
	public void printArray()
	{
		for(int i = 0; i<size; i++)
		{
			System.out.println( myArray[i].getIP() + " \t" + myArray[i].getLatency());
			
		}
		
	}
	public void setThreads(int i)
	{
		numThreads = i;
	}
	
	public void multiPing() throws InterruptedException
	{
		
		//allocating threads if equal or more tasks than threads
		int Perthread = size/ numThreads;
		int remainder = size % numThreads;
		System.out.println("size " + size + " threads " + numThreads);
		System.out.println("Perthread " + Perthread + " remainder " + remainder);
		int currentindex = 0;
		Threads object = null;
		ArrayList<Threads> myThreads = new ArrayList<Threads>();
        for (int i=0; i<numThreads; i++) 
        { 
        	//more threads than tasks
        	if(i>size) break;
        	
        	
        	if(remainder >0 )
        	{
        		object = new Threads(currentindex, currentindex + Perthread +1,myArray);
        		remainder --;
        		currentindex +=  Perthread + 1;
        		myThreads.add(object);
        	}
        	else
        	{
        		//remainder is 0
        		object = new Threads(currentindex, currentindex + Perthread, myArray );
        		currentindex +=  Perthread;
        		myThreads.add(object);
        	}

            object.start(); 
        } 
        for(Threads Thread:myThreads)
    	{
    		Thread.join();
    	}
	}
	
	



}
