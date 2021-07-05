package question3;


import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Décrivez votre classe Controleur ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(null);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);
        push.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent ae){
                try {
                   Controleur.this.push();
                } catch (Exception ex) {
                } 
            }
            });
        boutons.add(add);
        add.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent ae){
                sum();
            }
        });
        boutons.add(sub);
        sub.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent ae){
                sub();
            }
            });
        boutons.add(mul);
        mul.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent ae){
                mul();
            }
            });
        boutons.add(div);
        div.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent ae){
                div();
            }
            });
        boutons.add(clear);
        clear.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent ae){
                clear();
            }
            });
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
        
    }

    public void actualiserInterface() {
        // à compléter
        if(pile.estVide()){
          add.setEnabled(false);
          sub.setEnabled(false);
          mul.setEnabled(false);
          div.setEnabled(false);
          clear.setEnabled(false);
          push.setEnabled(true);
       }
       else if(pile.taille()== 1){
          add.setEnabled(false);
          sub.setEnabled(false);
          mul.setEnabled(false);
          div.setEnabled(false);
          clear.setEnabled(true);
          push.setEnabled(true);
        }
        else if(pile.taille()> 1){
          add.setEnabled(true);
          sub.setEnabled(true);
          mul.setEnabled(true);
          div.setEnabled(true);
          clear.setEnabled(true);
          push.setEnabled(true);
        }
        else if(pile.estPleine()) {
          push.setEnabled(false);
          add.setEnabled(true);
          sub.setEnabled(true);
          mul.setEnabled(true);
          div.setEnabled(true);
          clear.setEnabled(true);
        }
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    // à compléter
    // en cas d'exception comme division par zéro, 
    // mauvais format de nombre suite à l'appel de la méthode operande
    // la pile reste en l'état (intacte)
    public void push() throws Exception {
        
      try{
            this.pile.empiler(operande());
            System.out.print(operande());
              
        }catch(Exception e){

        }
        this.actualiserInterface();
    }

    public void sum() {
        try{
        this.pile.empiler(this.pile.depiler() + this.pile.depiler());
    }catch(PilePleineException | PileVideException e){
    
    }
        actualiserInterface();
    }

    public void mul() {
        try{
        this.pile.empiler(this.pile.depiler() * this.pile.depiler());
        }catch(PilePleineException | PileVideException e){
    
        }
        actualiserInterface();

    }

    public void sub() {
        try{
        int premiereNumbre = this.pile.depiler();
        this.pile.empiler(this.pile.depiler() - premiereNumbre);
        }catch(PilePleineException | PileVideException e){
    
        }
        actualiserInterface();
    }

    public void div() {
        try{
        int nbPourDivision = this.pile.sommet();
        if (nbPourDivision != 0) {
            this.pile.depiler();
            this.pile.empiler(this.pile.depiler() / nbPourDivision);
        }
        }catch(PilePleineException | PileVideException e){
    
        }
        actualiserInterface();

    }

    public void clear() {
        try{
        for (int i = this.pile.taille(); i >= 0; i--) {
            this.pile.depiler();
        }
        }catch(PileVideException e){
    
        }
        actualiserInterface();

    }
}
