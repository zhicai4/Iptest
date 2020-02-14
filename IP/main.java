

public class main {
	static int count = 0;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			IParray IPs = new IParray();
			IPs.setThreads(3);
			
			IPs.addIP("google.com");
			IPs.addIP("youtube.com");
			IPs.addIP("facebook.com");
			IPs.addIP("127.0.0.1");
			IPs.addIP("Yahoo.com");
			IPs.addIP("Bing.com");
			
			IPs.multiPing();
			IPs.printArray();
	}

}
