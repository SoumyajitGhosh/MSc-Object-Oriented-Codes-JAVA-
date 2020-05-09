package LeakyBucket;

public class LeakyBucketTest 
	{
	public static void main(String[] args) throws InterruptedException 
		{ 
			final PacketQueue pc = new PacketQueue(); 
			
			//Create Network thread 
			NetworkThread NT = new NetworkThread(pc); 
		
			//Create Application thread 
			ApplicationThread AT = new ApplicationThread(pc); 
		
			
			//Start both threads 
			NT.start(); 
			AT.start(); 
		}
	}
