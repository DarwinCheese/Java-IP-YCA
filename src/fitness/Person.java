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
    private int squat;
    private int bench;
    private int deadlift;
    
    public Person(String voornaam, String achternaam, char geslacht, int leeftijd, int lengte, boolean nogTrainende, int squat, int bench, int deadlift ) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geslacht = geslacht;
        this.leeftijd = leeftijd;
        this.lengte = lengte;
        this.nogTrainende = nogTrainende;
        this.squat = squat;
        this.bench = bench;
        this.deadlift = deadlift;
    }
    
    public Person(String voornaam, String achternaam, char geslacht, int leeftijd, int lengte, int gewicht, boolean nogTrainende, int squat, int bench, int deadlift) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geslacht = geslacht;
        this.leeftijd = leeftijd;
        this.lengte = lengte;
        this.gewicht = gewicht;
        this.nogTrainende = nogTrainende;
        this.squat = squat;
        this.bench = bench;
        this.deadlift = deadlift;
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

    public int getSquat() {
        return squat;
    }

    public void setSquat(int squat) {
        this.squat = squat;
    }

    public int getBench() {
        return bench;
    }

    public void setBench(int bench) {
        this.bench = bench;
    }

    public int getDeadlift() {
        return deadlift;
    }

    public void setDeadlift(int deadlift) {
        this.deadlift = deadlift;
    }
    
    
}
