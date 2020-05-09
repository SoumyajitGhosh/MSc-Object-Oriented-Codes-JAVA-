package LeakyBucket;

public class NetworkThread extends Thread {
	PacketQueue pc;
	public NetworkThread(PacketQueue pc) {
		this.pc=pc;
	}
	
	@Override
	public void run() 
	{ 
	    try
	    { 
	    	pc.network(); 
	    } 
	    catch(InterruptedException e) 
	    { 
	        e.printStackTrace(); 
	    } 
	} 
}
