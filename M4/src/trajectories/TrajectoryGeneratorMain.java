package trajectories;

import geometry.Polyline;
//import geometry.Position;

import javax.swing.JFrame;
import ptolemy.plot.Plot;

import java.util.Locale;
import java.util.Scanner;

public class TrajectoryGeneratorMain {
public static void main(String[] args) {
    // System.out.println(TrajectoryGenerator.generateRandom(50, 0, 100, 0, 75).toString());
    // System.out.println(TrajectoryGenerator.generateBrownian(100, 2.5).toString());
    //System.out.println(TrajectoryGenerator.generate(Types.BROWNIAN, 5).toString());
    var con = System.console();

    if (con != null) {
        Scanner sc = new Scanner(con.reader()).useLocale(Locale.US);
        System.out.print("Insert the number of points: ");
        int N = sc.nextInt();
        System.out.print("Insert the step: ");
        double step = sc.nextDouble();
    
        Polyline trajectoire = new Polyline();
        Plot plot = new Plot();
        //int N = 50;
        trajectoire = TrajectoryGenerator.generateBrownian(N, step);
        //trajectoire = TrajectoryGenerator.generateRandom(N, 0, 100, 0, 75);

        System.out.println(trajectoire);

        for(int i = 0;i<N;i++){
            plot.addPoint(0, trajectoire.getXPosition(i), trajectoire.getYPosition(i),true);
            plot.setLineStyle("solid", 0); 
        }    

        // main window -- do not change code below
        JFrame frame = new JFrame("Trajectory");
        frame.add(plot);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sc.close();
    }
}
}