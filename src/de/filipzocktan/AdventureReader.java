package de.filipzocktan;

import java.io.Reader;

import static de.filipzocktan.ConsoleAdventure.print;

public class AdventureReader extends java.io.BufferedReader {
    public AdventureReader(Reader in) {
        super(in);
    }

    public String readLine(String[] expected) throws Exception {
        String in = super.readLine();

        switch (in.toUpperCase()){
            case "WATER":
                print("Water-Status: You still have " + Stats.WaterBottle.getUnits() + "/" + Stats.WaterBottle.getMaxSize() + " water units.");
                break;
            case "HEALTH":
                print("Health-Status: You still have " + Stats.Health.getHealthPoints() + "/"+ Stats.Health.getMaxHealth() + " health points.");
                break;
            case "ARMOR":
                print("Armor-Status: You have " + Stats.Health.getArmorPoints() + " percent of damage-reduction caused by your armor.");
                break;
            case "HELP":
                print("You can do the following (not case-matching):");
                print("water --> showing your water status.");
                print("health --> showing your health status.");
                print("armor --> showing your armor status");
                for(int i = 0;i<expected.length;i++){
                    print(expected[i] +" --> Forwarding the story.");
                }
                break;
            default:
                for(int i = 0;i<expected.length;i++){
                    if(in.equalsIgnoreCase(expected[i])) return in;
                }
                print("This option is not available. If you don't have any idea what to do, type \"help\"");
        }
        return readLine(expected);
    }
}
