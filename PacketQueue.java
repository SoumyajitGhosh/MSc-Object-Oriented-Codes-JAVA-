package LeakyBucket;

import java.util.Arrays;
import java.math.*;
import java.io.*;

public class PacketQueue {
	int capacity=6,i=0;
	
	CircularQueue<Integer> cqueue = new CircularQueue<>(capacity);
	
    //Network Function
    public void network() throws InterruptedException 
    { 
        int value=0; 
        int cap=Math.round(capacity/2);
        while(cap>0) {
        	cqueue.enqueue(value++);
        	cap--;
        }
        while (true) 
        { 
        	//Creates an atomic block
            synchronized (this) 
            { 
                //Thread waits if the buffer is full
                while (cqueue.isFull()) {
                	System.out.println("Capacity full. Network Thread cannot produce any more packet.");
                    wait(); 
                }
                System.out.println("Packet produced-"
                                              + value); 

                //adds the thread to the list
                cqueue.enqueue(value++); 

                if(cqueue.isHalfFull()) {
                	//Notifies the Application thread that it can start consuming
                	notify(); 
                }
                
                Thread.sleep((long)(Math.random()*3000)); 
            } 
        } 
    } 

    //Application Function
    public void application() throws InterruptedException 
    { 
        while (true) 
        { 
        	//Creates an atomic block
            synchronized (this) 
            { 
                //Thread waits if all the packets of the buffer is consumed
                while (cqueue.isEmpty()) {
                	System.out.println("Capacity empty. Application Thread cannot consume packet.");
                    wait(); 
                }
                //Consumes the element from the beginning(FIFO format)
                int val = cqueue.dequeue(); 

                System.out.println("Packet consumed-"
                                                + val); 
                //Wake up Network thread 
                notify(); 
                

                Thread.sleep(3500); 
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
     * Check if queue is half full.
     */
    public boolean isHalfFull() {
        return (currentSize >= Math.floor((circularQueueElements.length)/2));
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