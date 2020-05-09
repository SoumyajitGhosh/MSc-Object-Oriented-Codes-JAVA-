package Vehicle;

import java.io.*;
import java.util.*;
abstract class Vehicle {
	int travel_dis;
	int travel_time;
	int mileage;
	int fuelCost;
	
	double fuelAmount()
	{
		return (double)((travel_dis*mileage)*fuelCost);
	}
	
	double averageSpeed() {
		double v=(double)(travel_dis/travel_time);
		return v;
	}
	
	abstract void display();
}

class Bus extends Vehicle{
	Bus(){
		travel_dis=0;
		travel_time=0;
		mileage=0;
		fuelCost=0;
	}
	
	Bus(int a,int b,int c){
		travel_dis=a;
		travel_time=b;
		fuelCost=c;
		mileage=10;
	}
	
	void display() {
		System.out.println("This is a Bus.");
		System.out.println("Distance travelled: "+travel_dis);
		System.out.println("Time: "+travel_time);
		System.out.println("Average Speed :"+averageSpeed());	
		System.out.println("Fuel Amount :"+fuelAmount());
	}
}

class Car extends Vehicle{
	Car(){
		travel_dis=0;
		travel_time=0;
		mileage=0;
		fuelCost=0;
	}
	
	Car(int a,int b,int c){
		travel_dis=a;
		travel_time=b;
		fuelCost=c;
		mileage=15;
	}
	
	void display() {
		System.out.println("This is a Car.");
		System.out.println("Distance travelled: "+travel_dis);
		System.out.println("Time: "+travel_time);
		System.out.println("Average Speed :"+averageSpeed());	
		System.out.println("Fuel Amount :"+fuelAmount());
	}
}

class Truck extends Vehicle{
	Truck(){
		travel_dis=0;
		travel_time=0;
		mileage=0;
		fuelCost=0;
	}
	
	Truck(int a,int b,int c){
		travel_dis=a;
		travel_time=b;
		fuelCost=c;
		mileage=8;
	}
	
	void display() {
		System.out.println("This is a Truck.");
		System.out.println("Distance travelled: "+travel_dis);
		System.out.println("Time: "+travel_time);
		System.out.println("Average Speed :"+averageSpeed());	
		System.out.println("Fuel Amount :"+fuelAmount());
	}
}


class TestVehicle{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		Vehicle vehicleList[]=new Vehicle[30];

		System.out.println("Enter price of 1L Diesel: ");
		int fc=sc.nextInt();
		final int svp=0,sbp=0,scp=10,stp=20;//start of vehicle pointer=start of bus pointer; scp=start of car pointer; stp=start of truck pointer
		int vp=svp,bp=sbp,cp=scp,tp=stp;//initialization
		int vyn=0,yn=0;//manages the do loops
		do {
			System.out.println("Enter the following");
			System.out.println("1 for Bus");
			System.out.println("2 for Car");
			System.out.println("3 for Truck");
			System.out.println("4 for total vehicle count");
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			switch (ch)
			{
			case 1:
				System.out.println("Bus Module");
				yn=0;
				do {
					System.out.println("Enter the following");
					System.out.println("1 for add new Bus");
					System.out.println("2 for delete old Bus");
					System.out.println("3 for view all Bus");
					System.out.println("Enter your choice");
					int ch1=sc.nextInt();
					switch(ch1) {
					case 1:
						if(bp<sbp+10) {
							
							System.out.println("Enter total Distance");
							int a=sc.nextInt();
							System.out.println("Enter total Time ");
							int b=sc.nextInt();
							Bus temp=new Bus(a,b,fc);
							vehicleList[bp++]=temp;
							vp++;
							System.out.println("New Bus added Total Bus = "+(bp));
						}
						else 
							System.out.println("Bus full");
						break;
					case 2:
						if(bp>0) {
							System.out.println("Which Bus you want to delete ?");
							int pos = sc.nextInt();
							vehicleList[(sbp+pos-1)].display();
							for(int i=sbp+pos-1;i<bp;i++)
								vehicleList[i]=vehicleList[i+1];
							bp--;
							vp--;
							System.out.println("successfully deleted");
						}
						else
							System.out.println("Empty list nothing to delete");
						break;
					case 3:
						System.out.println("All Busses are");
						for(int i=sbp;i<bp;i++)
							vehicleList[i].display();
						break;
					default:
						System.out.println("Wrong Choice");
					}
					System.out.println("Do you want to continue with bus module(1/0)");
					yn=sc.nextInt();
				}while(yn==1);
				break;
			case 2:
				System.out.println("Car Module");
				yn=0;
				do {
					System.out.println("Enter the following");
					System.out.println("1 for add new car");
					System.out.println("2 for delete old car");
					System.out.println("3 for view all car");
					System.out.println("Enter your choice");
					int ch1=sc.nextInt();
					switch(ch1) {
					case 1:
						if(cp<scp+10) {
							
							System.out.println("Enter total Distance");
							int a=sc.nextInt();
							System.out.println("Enter total Time ");
							int b=sc.nextInt();
							Car temp=new Car(a,b,fc);
							vehicleList[cp++]=temp;
							vp++;
							System.out.println("New car added Total car = "+(cp-scp));
						}
						else 
							System.out.println("car full");
						break;
					case 2:
						if(cp>scp+0) {
							System.out.println("Which car you want to delete ?");
							int pos = sc.nextInt();
							vehicleList[(scp+pos-1)].display();
							for(int i=scp+pos-1;i<cp;i++)
								vehicleList[i]=vehicleList[i+1];
							cp--;
							vp--;
							System.out.println("successfully deleted");
						}
						else
							System.out.println("Empty list nothing to delete");
						break;
					case 3:
						System.out.println("All cars are");
						for(int i=scp;i<cp;i++)
							vehicleList[i].display();
						break;
					default:
						System.out.println("Wrong Choice");
					}
					System.out.println("Do you want to continue with car module(1/0)");
					yn=sc.nextInt();
				}while(yn==1);
				break;
			case 3:
				System.out.println("Truck Module");
				yn=0;
				do {
					System.out.println("Enter the following");
					System.out.println("1 for add new Truck");
					System.out.println("2 for delete old Truck");
					System.out.println("3 for view all Truck");
					System.out.println("Enter your choice");
					int ch1=sc.nextInt();
					switch(ch1) {
					case 1:
						if(cp<stp+10) {
							
							System.out.println("Enter total Distance");
							int a=sc.nextInt();
							System.out.println("Enter total Time ");
							int b=sc.nextInt();
							Truck temp=new Truck(a,b,fc);
							vehicleList[tp++]=temp;
							vp++;
							System.out.println("New car added Total car = "+(tp-stp));
						}
						else 
							System.out.println("car full");
						break;
					case 2:
						if(cp>stp+0) {
							System.out.println("Which car you want to delete ?");
							int pos = sc.nextInt();
							vehicleList[(stp+pos-1)].display();
							for(int i=stp+pos-1;i<tp;i++)
								vehicleList[i]=vehicleList[i+1];
							tp--;
							vp--;
							System.out.println("successfully deleted");
						}
						else
							System.out.println("Empty list nothing to delete");
						break;
					case 3:
						System.out.println("All cars are");
						for(int i=stp;i<tp;i++)
							vehicleList[i].display();
						break;
					default:
						System.out.println("Wrong Choice");
					}
					System.out.println("Do you want to continue with car module(1/0)");
					yn=sc.nextInt();
				}while(yn==1);
				break;
			case 4:
				System.out.println("Total Vehicle = "+vp);
				break;
			default:
				System.out.println("Wrong Choice");
			}
			System.out.println("Do you want to continue with Vehicle module(1/0)");
			vyn=sc.nextInt();			

		}while(vyn==1);
		sc.close();
	}
}