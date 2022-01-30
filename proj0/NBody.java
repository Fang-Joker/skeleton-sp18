public class NBody {
	/**
	The class was used to run the simulation of the moving of n planet. 
	*/
	static double radius;
	// return the radius of universe from a file named by filename
	public static double readRadius(String fileName){
		// Start reading in filename
		In in = new In(fileName);

		// read the radius
		int num = in.readInt();
		radius = in.readDouble();

		return radius;
	}

	// return an array about class planet of planet from a file 
	public static Planet[] readPlanets(String fileName){
		// Start reading in filename
        In in = new In(fileName);

        // read the number of planet
        int num = in.readInt();
        double radius = in.readDouble();

        // create a array of planet
        Planet[] nPlanet = new Planet[num]; 

        // reading planet arguments and create the array objects of planet by class planet  
        for (int i = 0; i < num; i++){
        	// reading planet arguments
        	double xP = in.readDouble();
        	double yP = in.readDouble();
        	double xV = in.readDouble();
        	double yV = in.readDouble();
        	double mass = in.readDouble();
        	String imgFileName = in.readString();
        	nPlanet[i] = new Planet(xP, yP, xV, yV, mass, imgFileName);
        }

        return nPlanet;
	}

	// the main function to simulate the movement of planet
	public static void main(String[] args){
		
		// define the arguments, args[0] express total time T, args[1] express 
		// the step time dt, args[2] express the filename 
		
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		/** Sets up the universe so it goes from 
		  * -100, -100 up to 100, 100 */
		StdDraw.setScale(-NBody.readRadius(filename), NBody.readRadius(filename));

		/* Clears the drawing window. */
		StdDraw.clear();


		// Draw the background and planets
		StdDraw.picture(0, 0, "images/starfield.jpg");
		Planet[] planets = NBody.readPlanets(filename);
		// Draw the planets
		for (Planet p : planets){
			p.draw();
		}

		// start double buffer
		StdDraw.enableDoubleBuffering();

		// create force arrays 
		double[] xForces = new double[planets.length];
		double[] yForces = new double[planets.length];

		for (int t = 0; t < T; t += dt){
			// calculate netforce X and Y, storing these in the xForce and yForce arrays respectively
			for (int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			// update all planets
			for (int i = 0; i < planets.length; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			/* Clears the drawing window. */
			StdDraw.clear();
			// Draw the background and planets
			StdDraw.picture(0, 0, "images/starfield.jpg");
			// Draw the planets
			for (Planet p : planets){
				p.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
		}

		// Print the final state of all planets
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++){
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
					planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}
	}
}
