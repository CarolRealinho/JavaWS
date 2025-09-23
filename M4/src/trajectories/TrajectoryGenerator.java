package trajectories;

import geometry.Polyline;
import geometry.Position;

public class TrajectoryGenerator {
    /**
     * Generate a random position from a rectangle
     */
    static public Polyline generateRandom(int N, double x_min, double x_max, double y_min, double y_max){
        Polyline trajec = new Polyline();

        // Define the range
        double range_x = x_max-x_min +1;
        double range_y = y_max-y_min+1;

        for(int i=0;i<N;i++){
            Position pos = new Position(Math.random()*range_x+x_min, Math.random()*range_y+y_min); 
            trajec.addVertex(pos);
        }

        return trajec;
    }

    static public Polyline generateBrownian(int N, double step){
        Polyline trajec = new Polyline();
        // create and add the first position
        Position origin = new Position(0,0);
        Position lastPos = new Position();

        for(int i=0;i<N;i++){
            if(i==0){
                trajec.addVertex(origin);
                lastPos.moveTo(origin);
            }
            else{
                double angle = Math.random()*2*Math.PI; // direction randomly generated
                lastPos.translate(Math.cos(angle)*step, Math.sin(angle)*step);
                Position pos = new Position(lastPos);
                trajec.addVertex(pos);
            }
        }
        return trajec;
    }

    static public Polyline generate(Types t ,int N){
        Polyline defaultPoly = new Polyline();
        switch (t) {
            case RANDOM:
                return TrajectoryGenerator.generateRandom(N, 0, 1, 0, 1);
            case BROWNIAN:
                return TrajectoryGenerator.generateBrownian(N, 1);
            default:
                return defaultPoly;
        }
    }
}
