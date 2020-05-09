package ProducerConsumer;

public class ConsumerThread extends Thread {
	PacketQueue pc;
	public ConsumerThread(PacketQueue pc) {
		this.pc=pc;
	}
	@Override
	public void run() 
	{ 
	    try
	    { 
	    	pc.consume(); 
	    } 
	    catch(InterruptedException e) 
	    { 
	        e.printStackTrace(); 
	    } 
	} 
}
