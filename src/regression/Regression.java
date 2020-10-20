 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regression;

import jade.core.Agent;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.math.plot.Plot2DPanel;

/**
 *
 * @author oem
 */
public class Regression extends Agent {
    public void setup(){
   double[][] data = {{36,31},{28,29},{35,34},{39,35},{30,29},{30,30},{31,30},{38,38},{36,34},{38,33},{29,29},{26,26}};
       Regression slr = new Regression();
       slr.calculateRegression(data);
    }
    private void calculateRegression(double[][] data) {
        SimpleRegression regression = new SimpleRegression();
        regression.addData(data); 
        System.out.println("---Simple Linear Regression---");
        System.out.println("Beta 0:"+ regression.getIntercept());
        System.out.println("Beta 1:"+ regression.getSlope());
        System.out.println("Prediccion:"+ regression.predict(10));
        System.out.println("Ecuacion:"+regression.getIntercept()+"+"+regression.getSlope());
 //Graficar        
        Plot2DPanel plot = new Plot2DPanel();
        plot.addLegend("South");
        plot.addScatterPlot("Datos",data);
        plot.addLinePlot("Regresion",data);
      //  BaseLabel titulo = new BaseLabel ("Simple Linear Regression", Color.PINK,0.5,1.1);
     //  plot.addPlotable(titulo);
        JFrame frame = new JFrame("Simple Linear Regression");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600,500);
    frame.add(plot,BorderLayout.CENTER);
    frame.setVisible(true);

    /**
     * @param args the command line arguments
     */
    }
  
    
}
