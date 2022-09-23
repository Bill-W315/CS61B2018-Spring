public class NBody {

    public static double readRadius(String filename){
        In input = new In(filename);
        input.readInt();
        return input.readDouble();
    }

    public static Planet[] readPlanets(String filename){
        
        double xxPos;
        double yyPos;
        double xxVel;
        double yyVel;
        double mass;
        String imgFileName;

        In input = new In(filename);
        int amount = input.readInt();
        Planet[] planets = new Planet[amount];
        input.readDouble();

        for(int i=0; i < amount; i++){
            xxPos = input.readDouble();
            yyPos = input.readDouble();
            xxVel = input.readDouble();
            yyVel = input.readDouble();
            mass = input.readDouble();
            imgFileName = input.readString(); 
            planets[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
        }
        return planets;
    }

    public static void main(String[] args){
        double T =  Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];
        double r = readRadius(fileName);
        Planet[] planets = readPlanets(fileName);
     
        // set the universe scale
		StdDraw.setXscale(-r, r);
		StdDraw.setYscale(-r, r);
		StdDraw.enableDoubleBuffering();

        double t = 0;
        double[] xForces = new double[planets.length];
        double[] yForces = new double[planets.length];

        while(t < T){
            
            //Background picture
            StdDraw.picture(0, 0, "images/starfield.jpg");

            for(int i=0; i<planets.length; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
                planets[i].update(t,xForces[i],yForces[i]);
                planets[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(80);	
            t += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}
