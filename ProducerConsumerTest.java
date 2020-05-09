package ProducerConsumer;

class ProducerConsumerTest
{
	public static void main(String[] args) throws InterruptedException 
	{ 
		final PacketQueue pc = new PacketQueue(); 
		
		//Create producer thread 
		ProducerThread PT = new ProducerThread(pc); 
		
		//Create consumer thread 
		ConsumerThread CT = new ConsumerThread(pc); 
		
		//Start both threads 
		PT.start(); 
		CT.start(); 
	}
}

