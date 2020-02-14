
public class IP {
	
	private String ip;
	//latency in milliseconds
	private String latency;
	
	public IP(String ip)
	{
		this.ip = ip;
		this.latency = "n/a";
	}
	
	public String getIP()
	{
		return ip;
	}
	public String getLatency()
	{
		return latency;
	}
	public void setLatency(String latency)
	{
		this.latency = latency;
	}
	
}
