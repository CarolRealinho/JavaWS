package plots;

import javax.swing.JFrame;
import ptolemy.plot.Plot;

public class TrigonometryPlotterMain {
    public static void main(String[] args) {
    // create an area to draw some curves
    Plot plot = new Plot();
    int step = 1;
    for (int i=0; i<=360;i=i+step){
        plot.addPoint(0, i, Math.cos(Math.toRadians(i)), true);
        plot.setLineStyle("dotted", 0);    
        plot.addPoint(1, i, Math.sin(Math.toRadians(i)), true);
        plot.setLineStyle("solid", 1); 
    }

    // main window -- do not change code below
    JFrame frame = new JFrame("Sine Waves Plots");
    frame.add(plot);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}


