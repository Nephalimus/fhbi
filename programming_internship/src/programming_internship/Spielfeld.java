package programming_internship;

import edu.princeton.cs.introcs.StdDraw;

public class Spielfeld {
	
	private final static double xStart=100;
	private final static double yStart=100;
	private final static double maxX=200;
	private final static double maxY=200;
	private final static double kante=90;
	private final static double radius=10;
	private final static double innenabstand=10;
	private static Spielstein[][] felder;
	
	public static void main(String[] args) {
		// Zeichne Spielfeld
		StdDraw.setXscale(0,maxX);
		StdDraw.setYscale(0,maxY);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.square(xStart, yStart, kante);
		
		felder = new Spielstein[7][6];
		felder[0][0] = new Spielstein(true);
		felder[1][5] = new Spielstein(true);
		felder[0][1] = new Spielstein(true);
		felder[4][4] = new Spielstein(false);
		felder[6][2] = new Spielstein(true);
		felder[3][3] = new Spielstein(true);
		felder[4][5] = new Spielstein(true);
		felder[2][1] = new Spielstein(false);
		zeichnen(7, 6);
	}

	public static void zeichnen(int h, int v) {
		StdDraw.setPenColor(StdDraw.BLACK);
		double hAbs = ((2*kante)-(2*innenabstand))/h;
		double vAbs = ((2*kante)-(2*innenabstand))/v;

		double scx = (maxX-(2*kante))/2+innenabstand+radius;
		double scy = (maxY-(2*kante))/2+innenabstand+radius;
		double scyalt = scy;
		
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=v;j++) {
				//System.out.println(i+"|"+j+"|"+scx+"|"+scy);
				StdDraw.circle(scx, scy, radius);
				
				if(felder[i-1][j-1] != null) {
					if(felder[i-1][j-1].isRot()) {
						//System.out.println("rot");
						StdDraw.setPenColor(StdDraw.RED);
						StdDraw.filledCircle(scx, scy, 8);
					} else {
						//System.out.println("gelb");
						StdDraw.setPenColor(StdDraw.YELLOW);
						StdDraw.filledCircle(scx, scy, 8);
					}
				}
				StdDraw.setPenColor(StdDraw.BLACK);
				scy=scy+vAbs;
			}
			scy=scyalt;
			scx=scx+hAbs;
		}
	}
	
}


