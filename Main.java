/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitalygame;

import java.io.FileNotFoundException;
/**
 *
 * @author aliafzal
 */
public class Main {
    
/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CapitalyGame cg = new CapitalyGame();
        try {
            cg.read("test.txt","dice.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
            System.exit(-1);
        } catch (InvalidInputException ex) {
            System.out.println("Invalid input!");
            System.exit(-1);
        }
        cg.simulate();
    }

}