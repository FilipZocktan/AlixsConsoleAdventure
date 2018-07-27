package de.filipzocktan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleAdventure {

    private final int scenario;
    private final AdventureReader in;
    private Inventory inventory;

    public ConsoleAdventure(int scenario) throws Exception {
        this.scenario = scenario;
        this.in=new AdventureReader(new InputStreamReader(System.in));
        inventory = new Inventory(10);
        Stats.WaterBottle.setMaxSize(15);
        Stats.WaterBottle.fillBottle();
        for(int i = 0;i<5;i++) {
            Stats.WaterBottle.removeUnit();
        }
        Stats.Health.setMaxHealth(50);
        intro();
        startGame();
    }

    public static void main(String[] args) {
        try {
            new ConsoleAdventure(chooseScenario());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int chooseScenario() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            print("Choose a Story (type number)");
            print("1 - Forest-Expidition");

            print("More stories will be added in future patches.");
            int scenario = Integer.parseInt(in.readLine());
            if(scenario>1) {
                throw new NumberFormatException("");
            }
            return scenario;
        } catch (NumberFormatException ex) {
            System.out.println();
            print("This story doesn't exist.");
            return chooseScenario();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return chooseScenario();
    }

    private void intro() throws IOException {
        switch (scenario){
            case 1:
                print("Welcome to Alix's Console-Adventure Game.");
                print("In this Story you are an explorer and you have got to explore a forest where nobody has ever been before.");
                print("You go there with only a bottle of water which holds 10 units and can hold a maximum of 15 units and with your backpack in which you can store up to 10 items.");
                print("Every time you walk 1 unit will be used.");
                print("");
                print("[Press enter to go on.]");
                in.readLine();
                print("You can refill your bottle at lakes and creeks but sometimes the water there is not clean enough for you to drink and you will lose health by drinking it.");
                print("You can find other bottles in chests.");
                print("Other loot you can find from chests are health-containers, regeneration potions, weapons, armor and other loot.");
                print("Health-containers will improve your maximum health and regenerate all missing life.");
                print("");
                print("[Press enter to go on.]");
                in.readLine();
                print("Regeneration potions will regenerate your health points to your maximum.");
                print("Weapons will change your attack damage.");
                print("Armor will reduce your taken damage for up to 65%.");
                print("Sometimes items you find will help you, sometimes they won't.");
                print("");
                print("[Press enter to go on.]");
                in.readLine();
                print("Whenever you find something, you will be able to decide on whether you take it or not.");
                print("But if you don't take it, the item will be lost and you will have to restart the game if you need it later.");
                print("And hey, if you run out of storage, you can find new backpacks.");
                print("Now I wish you good luck and a lot of fun on your expidition.");
                print("");
                print("[Press enter to go on.]");
                in.readLine();
                break;
        }
    }

    private void startGame() throws Exception {
        stageS();
    }

    private void stageS() throws Exception {
        print("Do you want to go left or right?");
        in.readLine(new String[]{"Left", "Right"});
    }

    public static void print(String msg){
        System.out.println("> " + msg);
    }
}
