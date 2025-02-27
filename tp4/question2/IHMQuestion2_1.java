package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IHMQuestion2_1 extends JFrame {

    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");

    private TextArea contenu = new TextArea(30, 80);

 
    public IHMQuestion2_1() {
        super("IHM Question2_1");
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        enHaut.setBackground(Color.blue);
        setLocation(100,100);
        pack();show();

        // le bouton A a 3 observateurs jbo1, jbo2 et jbo3
        JButtonObserver boutonA1 = new JButtonObserver("jbo1", contenu);
        JButtonObserver boutonA2 = new JButtonObserver("jbo2", contenu);
        JButtonObserver boutonA3 = new JButtonObserver("jbo3", contenu);
        
        boutonA.addActionListener(boutonA1);
        boutonA.addActionListener(boutonA2);
        boutonA.addActionListener(boutonA3); 
        
        // le bouton B a 2 observateurs jbo1 et jbo2
        JButtonObserver boutonB1 = new JButtonObserver("jbo1", contenu);
        JButtonObserver boutonB2 = new JButtonObserver("jbo2", contenu);
        boutonB.addActionListener(boutonB1);
        boutonB.addActionListener(boutonB2);
        
         // le bouton C a 1 observateur jbo1
        JButtonObserver boutonC1 = new JButtonObserver("jbo1", contenu);
        boutonC.addActionListener(boutonC1);
        
      
    }
    
    public static void main(String[] args){
        new IHMQuestion2_1();
    }

}
