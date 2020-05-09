package ProducerConsumer;

public class ProducerThread extends Thread{
	PacketQueue pc;
	public ProducerThread(PacketQueue pc) {
		this.pc=pc;
	}
	@Override
	public void run() 
	{ 
	    try
	    { 
	    	pc.produce(); 
	    } 
	    catch(InterruptedException e) 
	    { 
	        e.printStackTrace(); 
	    } 
	} 
}
