package net.ddns.goy;

import java.util.InputMismatchException;
import java.util.Scanner;
// Classe qui contient l'interface command line
public class CLI {

    // Fonction principale pour executer l"interface
    public static void run(){
        Scanner sc = new Scanner(System.in);

        do {
            mainMenu(sc);
            System.out.println("--------------------");
        } while (true);
    }

    // Menu principale
    private static void mainMenu(Scanner sc){
        // Variable qui contient le choix de l'utilisateur
        int choice = -1;
        // Loop qui prend l'entree utilisateur
        do {
            // Try catch qui verifie que le user input est bien un integer
            try {
                System.out.println("Media tools :\n1) Title fixer\n2) Missing content finder\n3) Custom search\n0) Quit");
                System.out.print("Select one : ");
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(sc.nextLine() + " is not a valid input!");
            }
            // Option disponible dans le menu
            switch(choice){
                case 0:
                    System.out.println("Bye bye!");
                    System.exit(0);
                case 1:{
                    System.out.println("Not implemented yet!");
                    break;
                }
                case 2:{
                    System.out.println("Not implemented yet!");
                    break;
                }
                case 3:{
                    System.out.println("Not implemented yet!");
                    break;
                }
                default:
                    choice = -1;
            }
        } while (choice == -1);

    }

    // Menu pour la reparation de titre de DVD
    private static void titleFixMenu(){

    }

    // Menu pour les recherches personnaliser
    private static void customSearchMenu(){

    }

    //

}
