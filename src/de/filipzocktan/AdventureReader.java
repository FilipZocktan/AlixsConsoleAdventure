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
                print("Water-Status: You still have " + Stats.WaterBottle.getUnits() + "/" + Stats.WaterBottle.getMaxSize());
                break;
            case "HEALTH":
                break;
            case "HELP":
                print("You can do the following (not case-matching):");
                print("water --> showing your water status.");
                print("health --> showing your health status.");
                print("inventory --> ");
                for(int i = 0;i<expected.length;i++){
                    print(expected[i] +" --> Forwarding the story.");
                }
                break;
            default:
                for(int i = 0;i<expected.length;i++){
                    if(in.equals(expected[i])) return in;
                }
                print("This option is not available. If you don't have any idea what to do, type \"help\"");
                return readLine(expected);
        }
        throw new Exception("Something went wrong.");
    }
}
