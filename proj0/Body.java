import java.lang.Math;

public class Body {
	/**
	A body respect something in universe.
	*/
	public Body(double xP, double yP, double xV, double yV, double m, String img){
		this.xP = xP;
		this.yP = yP;
		this.xV = xV;
		this.yV = yV;
		this.m = m;
		this.img = img;
	}

	public Body(Body b){
		this = b;
	}

	public double calcDistance(Body other){
		return Math.sqrt(Math.pow(this.xP - other.xP, 2) + Math.pow(this.yP - other.yP, 2));
	}
}
