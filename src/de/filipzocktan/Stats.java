package de.filipzocktan;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class Stats {

    public static class WaterBottle {
        private static int maxSize;
        private static int units;

        public static int getMaxSize() {
            return maxSize;
        }

        public static int getUnits() {
            return units;
        }

        public static void setMaxSize(int maxSize) {
            WaterBottle.maxSize = maxSize;
        }

        private static void setUnits(int units) {
            WaterBottle.units = units;
        }

        public static void removeUnit() {
            setUnits(getUnits()-1);
        }

        public static void fillBottle(){
            setUnits(getMaxSize());
        }
    }

    public static class Health{
        private static double healthPoints;
        private static double maxHealth;
        private static double armorPoints;

        public static double getHealthPoints() {
            return healthPoints;
        }

        private static void setHealthPoints(double amount) {
            Health.healthPoints = amount;
        }

        public static double getMaxHealth() {
            return maxHealth;
        }

        public static void setMaxHealth(double maxHealth) {
            Health.maxHealth = maxHealth;
            regenerate();
        }

        public static double getArmorPoints() {
            return armorPoints;
        }

        private static void setArmorPoints(double amount) {
            Health.armorPoints = amount;
        }

        private static void addArmorPoints(double amount) {
            setArmorPoints(getArmorPoints()+amount);
            if(getArmorPoints()>65){
                setArmorPoints(65);
            }
        }

        private static void removeArmorPoints(double amount) {
            setArmorPoints(getArmorPoints()-amount);
        }

        private static void getDamage(double amount, boolean ignoreArmor) {
            if(ignoreArmor) {
                setHealthPoints(getHealthPoints() - amount);
            } else {
                double multiplier = 1-(1/100*getArmorPoints());
                setHealthPoints(getHealthPoints() - (amount*multiplier));
            }
        }

        public static void regenerate(){
            setHealthPoints(getMaxHealth());
        }

    }

}
