import java.lang.Math;

public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double Gconstant = 6.67e-11;

    public Planet(double xP, double yP, double xV,double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p2){
        double distanceSquare = Math.pow(p2.xxPos - xxPos, 2) + Math.pow(p2.yyPos - yyPos, 2);
        return Math.sqrt(distanceSquare);
    }
    
    public double calcForceExertedBy(Planet p2){
        double distance = calcDistance(p2);
        double force = Gconstant * p2.mass * mass / (distance * distance);
        return force;
    }

    public double calcForceExertedByX(Planet p2){
        double forceX = calcForceExertedBy(p2) * (p2.xxPos - xxPos) / calcDistance(p2);
        return forceX; 
    }

    public double calcForceExertedByY(Planet p2){
        double forceY = calcForceExertedBy(p2) * (p2.yyPos - yyPos) / calcDistance(p2);
        return forceY;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double netForceX = 0;
        for(Planet planet:allPlanets){
            if(!this.equals(planet)){
                netForceX += calcForceExertedByX(planet); 
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double netForceY = 0;
        for(Planet planet:allPlanets){
            if(!this.equals(planet)){
                netForceY += calcForceExertedByY(planet); 
            }
        }
        return netForceY;
    }

    public void update(double time, double xForce, double yForce){
        double accelerationX = xForce / mass;
        double accelerationY = yForce / mass;
        xxVel += time * accelerationX;
        yyVel += time * accelerationY;
        xxPos += time * xxVel;  
        yyPos += time * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }
}