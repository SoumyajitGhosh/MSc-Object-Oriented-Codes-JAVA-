package ProducerConsumer;

import java.util.Arrays;

public class PacketQueue {
	int capacity=5;
	CircularQueue<Integer> cqueue = new CircularQueue<>(capacity); 

    //Producer Function
    public void produce() throws InterruptedException 
    { 
        int value = 0; 
        while (true) 
        { 
        	//Creates an atomic block
            synchronized (this) 
            { 
                //Thread waits if the buffer is full
                while (cqueue.isFull()) 
                {
                	System.out.println("Circular Queue is Full. Further production, not possible yet.");
                    wait(); 
                }
                
                System.out.println("Producer produced-"
                                              + value); 

                //adds the thread to the list
                cqueue.enqueue(value++); 

                //Notifies the consumer that it can start consuming
                notify(); 

                Thread.sleep((long)(Math.random()*2000)); 
            } 
        } 
    } 

    //Consumer Function
    public void consume() throws InterruptedException 
    { 
        while (true) 
        { 
        	//Creates an atomic block
            synchronized (this) 
            { 
                //Thread waits if all the elements of the buffer is consumed
                while (cqueue.isEmpty()) 
                {	
                	System.out.println("Circular Queue is Empty. Further consumption, not possible yet.");
                    wait(); 
                }
                //Consumes the element from the beginning
                int val = cqueue.dequeue(); 

                System.out.println("Consumer consumed-"
                                                + val); 

                //Wake up producer thread 
                notify(); 

                Thread.sleep((long)(Math.random()*2000)); 
            } 
        } 
    } 
} 



//implementation of Circular Queue using Generics
class CircularQueue<E> {

    private int currentSize; //Current Circular Queue Size
    private E[] circularQueueElements;
    private int maxSize; //Circular Queue maximum size

    private int rear;//rear position of Circular queue(new element enqueued at rear).
    private int front; //front position of Circular queue(element will be dequeued from front).      

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        circularQueueElements = (E[]) new Object[this.maxSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }

    /**
     * Enqueue elements to rear.
     */
    public void enqueue(E item) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("Circular Queue is full. Element cannot be added");
        }
        else {
            rear = (rear + 1) % circularQueueElements.length;
            circularQueueElements[rear] = item;
            currentSize++;
            
            if (front == -1) {
				front = rear;
			}
        }
    }

    /**
     * Dequeue element from Front.
     */
    public E dequeue() throws QueueEmptyException {
        E deQueuedElement;
        if (isEmpty()) {
            throw new QueueEmptyException("Circular Queue is empty. Element cannot be retrieved");
        }
        else {
            deQueuedElement = circularQueueElements[front];
            circularQueueElements[front] = null;
            front = (front + 1) % circularQueueElements.length;
            currentSize--;
        }
        return deQueuedElement;
    }

    /**
     * Check if queue is full.
     */
    public boolean isFull() {
        return (currentSize == circularQueueElements.length);
    }

    /**
     * Check if Queue is empty.
     */
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    @Override
    public String toString() {
        return "CircularQueue [" + Arrays.toString(circularQueueElements) + "]";
    }

}

class QueueFullException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QueueFullException() {
        super();
    }

    public QueueFullException(String message) {
        super(message);
    }

}

class QueueEmptyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }

}