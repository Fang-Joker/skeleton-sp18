import java.lang.Math;

public class Planet {
    /**
    A body respect something in universe.
    */
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
    private double G = 6.67e-11;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName){
        this.xxPos = xxPos;
        this.yyPos = yyPos;
		this.xxVel = xxVel;
		this.yyVel = yyVel;
		this.mass = mass;
		this.imgFileName = imgFileName;
    }

    public Planet(Planet b){
		this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet other){
		return Math.sqrt(Math.pow(this.xxPos - other.xxPos, 2) + Math.pow(this.yyPos - other.yyPos, 2));
    }

    public double calcForceExertedBy(Planet other){
		return (G * this.mass * other.mass) / Math.pow(this.calcDistance(other), 2);
    }

	// return the ForceExertedByX from the planet other 
	public double calcForceExertedByX(Planet other){
		return this.calcForceExertedBy(other) * (other.xxPos - this.xxPos) / this.calcDistance(other);
	}

	// return the ForceExertedByY from the planet other 
	public double calcForceExertedByY(Planet other){
		return this.calcForceExertedBy(other) * (other.yyPos - this.yyPos) / this.calcDistance(other);
	}

	// return the NetForceExertedByX from the all other planet
	public double calcNetForceExertedByX(Planet[] all){
		double netForceX = 0;
		for (int i = 0; i < all.length; i++){
			if (!this.equals(all[i])){
				netForceX += this.calcForceExertedByX(all[i]);
			}
		}
		return netForceX;
	}

	// return the NetForceExertedByY from the all other planet
	public double calcNetForceExertedByY(Planet[] all){
		double netForceY = 0;
		for (int i = 0; i < all.length; i++){
			if (!this.equals(all[i])){
				netForceY += this.calcForceExertedByY(all[i]);
			}
		}
		return netForceY;
	}

	// update the v and position of planet
	public void update(double dt, double fX, double fY){
		double aX = fX / this.mass;
		double aY = fY / this.mass;
		this.xxVel += dt * aX;
		this.yyVel += dt * aY;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel; 
		// StdOut.println(this.xxPos);
	}

	// Draw the planet 
	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos,"./images/" + this.imgFileName);
	}
}
