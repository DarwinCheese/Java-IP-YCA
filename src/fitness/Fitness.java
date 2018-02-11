/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Laptop10
 */
public class Fitness extends JPanel implements ActionListener{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.setLayout(new GridLayout(1,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Add content
        frame.add(new Fitness(), BorderLayout.CENTER);
         
        //Display
        frame.setSize(500,600);
        frame.setVisible(true);
        
    }
    
    public Fitness(){
        JTextField voornaam, achternaam, leeftijd, lengte, gewicht, squat, bench, deadlift, scheduleDay;
        JButton submitPersonBtn, submitWorkoutBtn, getPersonsBtn;
        JCheckBox nogTrainende;
        
        JTabbedPane tabbedPane = new JTabbedPane();
       
        //Persoon form
        JComponent panel1 = makeTextPanel("Persoon Toevoegen");
        tabbedPane.addTab("Nieuwe persoon toevoegen", null, panel1,
                          "Persoonformulier");
        panel1.setPreferredSize(new Dimension(450, 450));
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        voornaam = new JTextField(20);
        achternaam = new JTextField(20);
        leeftijd = new JTextField(20);
        lengte = new JTextField(20);
        gewicht = new JTextField(20);
        
        nogTrainende = new JCheckBox("Train je nog?");
        nogTrainende.setMnemonic(KeyEvent.VK_C);
        nogTrainende.setSelected(true);
        
        JRadioButton manButton = new JRadioButton("Man");
        manButton.setMnemonic(KeyEvent.VK_M);
        manButton.setActionCommand("Man");
        manButton.setSelected(true);

        JRadioButton vrouwButton = new JRadioButton("Vrouw");
        vrouwButton.setMnemonic(KeyEvent.VK_V);
        vrouwButton.setActionCommand("Vrouw");
        
        ButtonGroup group = new ButtonGroup();
        group.add(manButton);
        group.add(vrouwButton);
        
        //Gegevens inlezen
        
        ArrayList<Person> persons = new ArrayList<Person>();
        submitPersonBtn = new JButton("Gegevens verzenden");
        submitPersonBtn.setMnemonic(KeyEvent.VK_ENTER);
        submitPersonBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputVoornaam = voornaam.getText();
                String inputAchternaam = achternaam.getText();
                int inputLeeftijd =  Integer.parseInt(leeftijd.getText());
                int inputLengte = Integer.parseInt(lengte.getText());
                String inputGewicht = gewicht.getText();
                
                
                boolean isSelected = nogTrainende.isSelected();
                boolean inputTrainende;
                
                if(isSelected ){
                   inputTrainende = true;
                } else {
                   inputTrainende = false;
                }
                
                if(inputGewicht.equals("")){
                    //constructor zonder gewicht
                    Person person = new Person(inputVoornaam, inputAchternaam, 'M', inputLeeftijd, inputLengte, inputTrainende);
                } else {
                    int inputGewichtInt = Integer.parseInt(gewicht.getText());
                    Person person = new Person(inputVoornaam, inputAchternaam, 'M', inputLeeftijd, inputLengte, inputGewichtInt, inputTrainende);
                    persons.add(person);
                }
            }
            
        });
        
        panel1.add(new JLabel(""));
        panel1.add(new JLabel("Voornaam:"));
        panel1.add(voornaam);
        panel1.add(new JLabel("Achternaam:"));
        panel1.add(achternaam);
        panel1.add(new JLabel("Geslacht:"));
        panel1.add(new JLabel(""));
        panel1.add(manButton);
        panel1.add(vrouwButton);
        panel1.add(new JLabel("Leeftijd:"));
        panel1.add(leeftijd);
        panel1.add(new JLabel(""));
        panel1.add(nogTrainende);
        panel1.add(new JLabel("Lengte:"));
        panel1.add(lengte);
        panel1.add(new JLabel("Gewicht (optioneel):"));
        panel1.add(gewicht);
        panel1.add(submitPersonBtn);
        
        
        
        //Workout form
        JComponent panel2 = makeTextPanel("Voer hier je workout in (in kg)");
        tabbedPane.addTab("Workout toevoegen", null, panel2,
                          "Workoutformulier");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        squat = new JTextField(20);
        bench = new JTextField(20);
        deadlift = new JTextField(20);
        scheduleDay = new JTextField(20);
        
        submitWorkoutBtn = new JButton("Gegevens verzenden");
        submitWorkoutBtn.setMnemonic(KeyEvent.VK_ENTER);
        
        panel2.add(new JLabel(""));
        panel2.add(new JLabel("Squat:"));
        panel2.add(squat);
        panel2.add(new JLabel("Bench Press:"));
        panel2.add(bench);
        panel2.add(new JLabel("Deadlift:"));
        panel2.add(deadlift);
        panel2.add(new JLabel("Trainingsdag (1, 2 of 3):"));
        panel2.add(scheduleDay);
        panel2.add(submitWorkoutBtn);
        
        //Overzicht
        JComponent panel3 = makeTextPanel("Overzicht personen en workouts");
        tabbedPane.addTab("Overzicht", null, panel3,
                          "Overzicht");
        
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        
        getPersonsBtn = new JButton("Gegevens opvragen");
        getPersonsBtn.setMnemonic(KeyEvent.VK_ENTER);
        getPersonsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //for-loop
                for (int i = 0; i < persons.size(); i++) {
                    String personVoornaam = persons.get(i).getVoornaam();
                    String personAchternaam = persons.get(i).getAchternaam();
                    int personLeeftijd = persons.get(i).getLeeftijd();
                    char personGeslacht = persons.get(i).getGeslacht();
                    int personLengte = persons.get(i).getLengte();
                    int personGewicht = persons.get(i).getGewicht();
                    boolean personTrainende = persons.get(i).isNogTrainende();
                    panel3.add(new JLabel(personVoornaam + " " + personAchternaam + " " + personLeeftijd + " " + personGeslacht + " " + personLengte + " " + personGewicht + " " + personTrainende));
                }
                panel3.validate();
            }
        });
        panel3.add(new JLabel("Sup"));
        panel3.add(new JLabel("Memes"));
        panel3.add(getPersonsBtn);
        
        
        add(tabbedPane);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
    }
    
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(10,0,20,20));
        
        panel.add(filler);
        
        return panel;
    }    
    
    //Gegevens inlezen
//    private void createPerson() {
//        String fName = voornaam.getText();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
