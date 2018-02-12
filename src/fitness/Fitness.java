/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laptop10
 */
public class Fitness extends JPanel{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.setLayout(new GridLayout(1,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Add content
        frame.add(new Fitness(), BorderLayout.CENTER);
         
        //Display
        frame.setSize(1100,600);
        frame.setVisible(true);
        
    }
    
    public Fitness() {
        JTextField voornaam, achternaam, leeftijd, lengte, gewicht, squat, bench, deadlift;
        JButton submitPersonBtn, toFileBtn;
        JCheckBox nogTrainende;
        
        JTabbedPane tabbedPane = new JTabbedPane();
       
        //Persoon form
        JComponent panel1 = makeTextPanel("Persoon Toevoegen");
        tabbedPane.addTab("Nieuwe persoon toevoegen", null, panel1,
                          "Persoonformulier");
        panel1.setPreferredSize(new Dimension(1050, 450));
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        JComponent panel3 = makeTablePanel("Overzicht personen en workouts");
        tabbedPane.addTab("Overzicht", null, panel3,
                          "Overzicht");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        Object[] columnNames = {"Voornaam", "Achternaam", "Leeftijd", "Geslacht", "Lengte", "Gewicht", "Trainende?", "Max Squat", "Max Bench", "Max Deadlift"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        panel3.add(new JScrollPane(table));
        
        
        voornaam = new JTextField(20);
        achternaam = new JTextField(20);
        leeftijd = new JTextField(20);
        lengte = new JTextField(20);
        gewicht = new JTextField(20);
        squat = new JTextField(20);
        bench = new JTextField(20);
        deadlift = new JTextField(20);
        
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
                int inputSquat = Integer.parseInt(squat.getText());
                int inputBench = Integer.parseInt(bench.getText());
                int inputDeadlift = Integer.parseInt(deadlift.getText());
                
                
                boolean isSelected = nogTrainende.isSelected();
                boolean inputTrainende;
                
                if(isSelected ){
                   inputTrainende = true;
                } else {
                   inputTrainende = false;
                }
                
                if(inputGewicht.equals("")){
                    //constructor zonder gewicht
                    Person person = new Person(inputVoornaam, inputAchternaam, 'M', inputLeeftijd, inputLengte, inputTrainende, inputSquat, inputBench, inputDeadlift);
                    persons.add(person);
                } else {
                    int inputGewichtInt = Integer.parseInt(gewicht.getText());
                    Person person = new Person(inputVoornaam, inputAchternaam, 'M', inputLeeftijd, inputLengte, inputGewichtInt, inputTrainende, inputSquat, inputBench, inputDeadlift);
                    persons.add(person);
                }
                
                Person lastPerson = persons.get(persons.size() - 1);
                String personVoornaam = lastPerson.getVoornaam();
                String personAchternaam = lastPerson.getAchternaam();
                int personLeeftijd = lastPerson.getLeeftijd();
                char personGeslacht = lastPerson.getGeslacht();
                int personLengte = lastPerson.getLengte();
                int personGewicht = lastPerson.getGewicht();
                boolean personTrainende = lastPerson.isNogTrainende();
                int personSquat = lastPerson.getSquat(); 
                int personBench = lastPerson.getBench();
                int personDeadlift = lastPerson.getDeadlift();

                Object[] data = {personVoornaam, personAchternaam, personLeeftijd, personGeslacht, personLengte, personGewicht, personTrainende, personSquat, personBench, personDeadlift};

                tableModel.addRow(data);
                table.repaint();
                panel3.validate();
                panel3.repaint();
                    
            }
            
        });
        
        toFileBtn = new JButton("Gegevens wegschrijven");
        toFileBtn.setMnemonic(KeyEvent.VK_ENTER);
        toFileBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PrintWriter writer;
                try {
                    writer = new PrintWriter("personen.txt", "UTF-8");
                    writer.println("Hallo");
                    writer.println("Doei");
                    //For-loop alle personen
                    writer.close();
                    
                    JOptionPane.showMessageDialog(null, "memes");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Fitness.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Fitness.class.getName()).log(Level.SEVERE, null, ex);
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
        panel1.add(new JLabel("Max Squat:"));
        panel1.add(squat);
        panel1.add(new JLabel("Max Bench:"));
        panel1.add(bench);
        panel1.add(new JLabel("Max Deadlift:"));
        panel1.add(deadlift);
        panel1.add(submitPersonBtn);
        panel1.add(toFileBtn);
        
      
        add(tabbedPane);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
    }
    
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(13,0,10,10));
        
        panel.add(filler);
        
        return panel;
    }    
    
    //Gegevens inlezen
//    private void createPerson() {
//        String fName = voornaam.getText();
//    }

    protected JComponent makeTablePanel(String text) {
        JPanel panel = new JPanel(false);
        //JLabel filler = new JLabel(text);
        
        //filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1,0));
        
        //panel.add(filler);
        
        return panel;
    }    
    
}
