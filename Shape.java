package Shape;

import java.util.*;
class Shape {
	int a,l,b,h,r;
	public Shape() {
		System.out.println("Default base class constructor");
	}
	public Shape(int a,int l,int b,int h,int r) {
		this.a=a;
		this.l=l;
		this.b=b;
		this.h=h;
		this.r=r;
		System.out.println("Parameterised base class constructor");
	}


	public double calcVolume() {
		return 0.0d;
	}

	public void showVolume(double x) {
		System.out.println("Volume = " + x);
	}
}

class Cube extends Shape {
	int a;
	public Cube(int a,int l,int b,int h,int r) {
		super(a,l,b,h,r);
		this.a=a;
	}

	
	public double calcVolume() {
		return a * a * a;
	}
}

class RectangularPrism extends Shape {
	int length, breadth, height;
	public RectangularPrism(int a,int l,int b,int h,int r) {
		super(a,l,b,h,r);
		length = l;
		breadth = b;
		height = h;
	}

	public double calcVolume() {
		return length * breadth * height;
	}
}

class Sphere extends Shape {
	int radius;
	public Sphere(int a,int l,int b,int h,int r) {
		super(a,l,b,h,r);
		radius = r;
	}
	
	public double calcVolume() {
		return 4/3 * Math.PI * Math.pow(radius, 3);
	}
}



class Test {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Shape> obj = new ArrayList<Shape>();
		int a,r,l,b,h,ch,y=1;
		do {
			System.out.println("1.Cube\t 2.RectangularPrism\t 3.Sphere\t 4.Remove last existing shape");
			System.out.println("Enter choice:");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:	System.out.print("Enter side of cube: ");
					a = sc.nextInt();
					Cube c=new Cube(a, 0, 0, 0, 0);
					obj.add(c);
					c.showVolume(c.calcVolume());
					break;
			case 2: System.out.print("Enter details for rectangular prism:\\nLength: ");
					System.out.print("Length: ");
					l = sc.nextInt();
					System.out.print("Breadth: ");
					b = sc.nextInt();
					System.out.print("Height: ");
					h = sc.nextInt();
					RectangularPrism rp = new RectangularPrism(0, l, b, h, 0);
					obj.add(rp);
					rp.showVolume(rp.calcVolume());
					break;
			case 3: System.out.print("Enter radius of sphere: ");
					r=sc.nextInt();
					Sphere s = new Sphere(0, 0, 0, 0, r);
					obj.add(s);
					s.showVolume(s.calcVolume());
					break;
			case 4: System.out.println("Shape Array Size before removal:"+obj.size());
					obj.remove(obj.size()-1);
					System.out.println("Shape Array Size after removal:"+obj.size());
			case 5: System.out.print("Do you wish to continue:(y/n)?");
					y=sc.nextInt();
			}
		}
		while(y!=0);
		System.out.println("Program has ended");
		sc.close();
	}	
}
