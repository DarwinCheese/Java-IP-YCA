/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

/**
 *
 * @author Laptop10
 */
public class Person {
    private String voornaam;
    private String achternaam;
    private char geslacht;
    private int leeftijd;
    private int lengte;
    private int gewicht;
    private boolean nogTrainende;
    
    public Person(String voornaam, String achternaam, char geslacht, int leeftijd, int lengte, boolean nogTrainende ) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geslacht = geslacht;
        this.leeftijd = leeftijd;
        this.lengte = lengte;
        this.nogTrainende = nogTrainende;
    }
    
    public Person(String voornaam, String achternaam, char geslacht, int leeftijd, int lengte, int gewicht, boolean nogTrainende) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geslacht = geslacht;
        this.leeftijd = leeftijd;
        this.lengte = lengte;
        this.gewicht = gewicht;
        this.nogTrainende = nogTrainende;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public char getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(char geslacht) {
        this.geslacht = geslacht;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public int getLengte() {
        return lengte;
    }

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public boolean isNogTrainende() {
        return nogTrainende;
    }

    public void setNogTrainende(boolean nogTrainende) {
        this.nogTrainende = nogTrainende;
    }
    
    
}
