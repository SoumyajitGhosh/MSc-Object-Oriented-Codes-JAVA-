package Employee;

import java.util.*;
import java.io.*;

class Employee{
	private int eId;
	private String eName;
	private double basicSal;
	public Employee(int eId, String eName, double basicSal) {
		this.eId=eId;
		this.eName=eName;
		this.basicSal=basicSal;
	}
	
	@Override
	public String toString() {
		return "\n\tempID:" + geteId() + "\t" +
		"\tempName:" + geteName() + "\t" +
		"\tsalary:" + calculateSalary() + ";" +
		"\n";
	}
	
	public int geteId() {
		return this.eId;
	}
	
	public void seteId(int eId) {
		this.eId=eId;
	}
	
	public String geteName() {
		return this.eName;
	}
	
	public void seteName(String eName) {
		this.eName = eName;
	}
	
	public void setEmpName(String eName) {
		this.eName = eName;
	}
	
	public double calculateSalary() {
		return 0.0d;
	}
	
	/*public void showSalary(double salary) {
		System.out.println("Salar: "+salary);
	}*/
}

class Manager extends Employee{
	double basic;
	double da,ta,hra,ma,gross;
	public Manager(int eId, String eName, double basicSal) {
		super(eId, eName, basicSal);
		basic=basicSal;
	}
	
	public double calculateSalary() {
		ta=0.15*basic;
		da=0.7*basic;
		hra=0.24*basic;
		ma=0.2*basic;
		gross=ta+da+hra+ma+basic;
		return gross;
	}
}

class TechnicalStaff extends Employee{
	double basic;
	double da,ta,hra,ma,gross;
	public TechnicalStaff(int eId, String eName, double basicSal) {
		super(eId, eName, basicSal);
		basic=basicSal;
	}
	
	public double calculateSalary() {
		ta=0.1*basic;
		da=0.5*basic;
		hra=0.2*basic;
		ma=0.2*basic;
		gross=ta+da+hra+ma+basic;
		return gross;
	}
}

class Labour extends Employee{
	double basic;
	double da,ta,hra,ma,gross;
	public Labour(int eId, String eName, double basicSal) {
		super(eId, eName, basicSal);
		basic=basicSal;
	}
	
	public double calculateSalary() {
		ta=0.1*basic;
		da=0.3*basic;
		hra=0.1*basic;
		ma=0.1*basic;
		gross=ta+da+hra+ma+basic;
		return gross;
	}
}



class TestEmployee {
	public static void main(String args[])throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		ArrayList<Employee> empList = new ArrayList<Employee>();
		int eId,y=1,ch,i,count=0,pos1=0,pos2=0;
		String eName;
		double basic,S=0.0d,avgSalary,minSalary=0.0d,maxSalary=0.0d;
		do {
			System.out.println("Enter type of employee:1.Manager, 2.TechnicalStaff, 3.Labour");
			ch=Integer.parseInt(br.readLine());
			switch(ch) {
			case 1:	System.out.println("Enter Manager ID:\t");
					eId=Integer.parseInt(br.readLine());
					System.out.println("Enter Manager Name:\t");
					eName=br.readLine();
					System.out.println("Enter Manager Salary:\t");
					basic=Double.parseDouble(br.readLine());
					Manager man = new Manager(eId, eName, basic);
					empList.add(man);
					man.calculateSalary();
					//System.out.println(man);
					break;
			case 2:	System.out.println("Enter TechnicalStaff ID:\t");
					eId=Integer.parseInt(br.readLine());
					System.out.println("Enter TechnicalStaff Name:\t");
					eName=br.readLine();
					System.out.println("Enter TechnicalStaff Salary:\t");
					basic=Double.parseDouble(br.readLine());
					TechnicalStaff tech = new TechnicalStaff(eId, eName, basic);
					empList.add(tech);
					tech.calculateSalary();
					//System.out.println(tech);
					break;		
			case 3:	System.out.println("Enter Labour ID:\t");
					eId=Integer.parseInt(br.readLine());
					System.out.println("Enter Labour Name:\t");
					eName=br.readLine();
					System.out.println("Enter Labour Salary:\t");
					basic=Double.parseDouble(br.readLine());
					Labour lab = new Labour(eId, eName, basic);
					empList.add(lab);
					lab.calculateSalary();
					//System.out.println(lab);
					break;		
			default:System.out.println("Do you wish to continue:(1/0)?");
					y=Integer.parseInt(br.readLine());
			}
		}
		while(y!=0);
		System.out.println(empList);
		minSalary=empList.get(0).calculateSalary();
		for(i=0;i<empList.size();i++) {
			S=S+empList.get(i).calculateSalary();
			count++;
			if(maxSalary<empList.get(i).calculateSalary()) {
				maxSalary=empList.get(i).calculateSalary();
				pos1=i;
			}
			if(minSalary>empList.get(i).calculateSalary()) {
				minSalary=empList.get(i).calculateSalary();
				pos2=i;
			}
		}	
		avgSalary=(double)(S/count);
		System.out.println("Average Salary of the Employees:\t"+avgSalary);
		System.out.println("Maximum Salary of the Employees:\t"+maxSalary);
		System.out.println("Details of the Employee:\n");
		System.out.println(empList.get(pos1));
		System.out.println("Minimum Salary of the Employees:\t"+minSalary);
		System.out.println("Details of the Employee:\n");
		System.out.println(empList.get(pos2));
	}		
}



