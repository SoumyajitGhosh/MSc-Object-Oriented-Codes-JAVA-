package LeakyBucket;

public class ApplicationThread extends Thread {
	PacketQueue pc;
	public ApplicationThread(PacketQueue pc) {
		this.pc=pc;
	}
	@Override
	public void run() 
	{ 
	    try
	    { 
	    	pc.application(); 
	    } 
	    catch(InterruptedException e) 
	    { 
	        e.printStackTrace(); 
	    } 
	} 
}
