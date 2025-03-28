/**
 * This is PA5 Sanctuary.java file
 * Name: Yonghyeon Choi
 * PID: A17010613
 * Email: y9choi@ucsd.edu
 * Sources used: Oracle, Lecture Slides, Zybooks
 * 
 * This file uses a HashMap to organize elements. It
 * gives maximum values of the HashMap. Utilizing HashMap
 * Key and Value parameters, it stores multiples of animal 
 * elements. 
 */
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * This class provides specific characteristics to a
 * HashMap. It also allows the HashMap to store the elements, 
 * which are animals in this case. It includes various
 * methods that deal with the characteristics of the 
 * HashMap.
 */
public class Sanctuary {
    
    HashMap<String, Integer> sanctuary;
    int maxAnimals;
    int maxSpecies;

    /**
     * Initalizes the HashMap with no elements and other
     * instance variables accordingly
     * @param maxAnimals - maximum number of animals that 
     * sanctuary can store
     * @param maxSpecies - maximum number of species that 
     * sanctuary can store
     */
    public Sanctuary(int maxAnimals, int maxSpecies) {

        if (maxAnimals < 0 || maxSpecies < 0) {
            throw new IllegalArgumentException();
        }

        sanctuary = new HashMap<>();
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;

    }

    /**
     * Returns the number of animals in the sanctuary of
     * the given species
     * @param species - species that will be count
     * @return number of animals of those species
     */
    public int getNum(String species) {

        if (species == null) {
            throw new IllegalArgumentException();
        }
        
        if (sanctuary.containsKey(species) == false) {
            return 0;
        }
        else {
            return sanctuary.get(species);

        }

    }
    
    /**
     * Returns the total number of animals in the sanctuary
     * @return total number of animals
     */
    public int getTotalAnimals() {

        int animalCount = 0; 

        Set<String> keySet = sanctuary.keySet();
        // Iterates through the HashSet to collect the 
        // number of animals for each species
        for (String s : keySet) {
            animalCount = animalCount + sanctuary.get(s);
        }

        return animalCount;
        
    }
    
    /**
     * Returns the total number of species in the sanctuary 
     * @return total number of species
     */
    public int getTotalSpecies() {

        return sanctuary.size();
    
    }

    /**
     * If given parameters don't exceed the maxAnimals nor
     * maxSpecies, add number of animals of given species
     * @param species - species that will be added
     * @param num - number of animals being added
     * @return number of elements that could not be rescued
     */
    public int rescue(String species, int num) {
        
        if (num <= 0) {
            throw new IllegalArgumentException();
        }
        if (species == null) {
            throw new IllegalArgumentException();
        }

        if (getTotalSpecies() + 1 <= maxSpecies 
            && getTotalAnimals() + num <= maxAnimals) {
            sanctuary.put(species, num);

            return 0;
        }

        if (getTotalSpecies() + 1 <= maxSpecies 
        && getTotalAnimals() + num > maxAnimals) {
            // Stores two int values that will each decide how many 
            // animals will be added and what will be returned when 
            //the addition exceeds maxAnimals
            int permittedNum;
            int exceededNum;
            exceededNum = getTotalAnimals() + num - maxAnimals;
            permittedNum = num - exceededNum;
            sanctuary.put(species, permittedNum);

            return exceededNum;
        }
        else {
            return 0;
        }

    }

    /**
     * Remove given number of animals of given species
     * from the sanctuary and remove the species if 
     * remaining number of animals is zero.
     * @param species - species that will be removed
     * @param num - number of animals that will be removed
     */
    public void release(String species, int num) {

        if (num <= 0 || num > getNum(species) 
            || species == null || sanctuary.containsKey(species) == false) {
            throw new IllegalArgumentException();
        }

        // Stores number of remaining animals after removing 
        // to later determine if the species will be removed or not
        int remainNum = getNum(species) - num;
        
        if (remainNum <= 0) {
            sanctuary.remove(species);
        }
        else {
            sanctuary.replace(species, remainNum);
        }

    }
}
