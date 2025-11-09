package org.example;

import java.util.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main() {


        System.out.println("=== Bienvenue au Battle Arena ===");

        //Creation of the players

        String name1, name2;
        do {
            System.out.print("Entrez le nom du joueur 1 : ");
            name1 = scanner.nextLine().trim();
            if (name1.isEmpty()) {
                System.out.println("Le nom ne peut pas etre vide");

            }

//            Player player2 = new Player(scanner.nextLine());
        }
        while (name1.isEmpty());

        do {
            System.out.print("Entrez le nom du joueur 2 : ");
            name2 = scanner.nextLine().trim();

//            do
//            {
            if (name2.isEmpty()) {
                System.out.println("Le nom ne peut pas etre vide");
            }
//            else{
//                System.out.println("Les deux noms doivent etre differents");
//                System.out.print("Entrez le nom du joueur 2 : ");
//                name2 = scanner.nextLine().trim();
//
//            }
//            }
//
//
////            else if(name1.equalsIgnoreCase(name2)){
////                System.out.println("Les deux noms doivent etre differents");
////            }
//            while(name1.equalsIgnoreCase(name2));
        }
        while (name2.isEmpty());

        while (name1.equalsIgnoreCase(name2) || name2.isEmpty()) {
            System.out.println("Les deux noms doivent etre differents");
            System.out.print("Entrez le nom du joueur 2 : ");
            name2 = scanner.nextLine().trim();
        }

        Player player1 = new Player(name1);
        Player player2 = new Player(name2);


        System.out.println("\n -- Joueur 1, creez votre equipe ---");
        createTeam(player1);
        System.out.println("\n -- Joueur 2, creez votre equipe ---");
        createTeam(player2);

        //Start the battle

        Battle battle = new Battle(player1, player2);
        battle.start();


    }

    private static void createTeam(Player player) {
        Set<String> usedNames = new HashSet<>();
        Set<Type> usedTypes = new HashSet<>();

        for (int i = 1; i <= 3; i++) {
            System.out.println("\nCaractere " + i + " pour " + player.getName());


            Type chosenType = null;
            do {
                System.out.println("choisis le type : ");
                System.out.println("1- Warrior  2- Magus  3- Colossus  4- Dwarf");
                String choice = scanner.nextLine().trim().toLowerCase();

                // we convert the choice to type

                switch (choice) {
                    case "1":
                    case "warrior":
                        chosenType = Type.WARRIOR;
                        break;
                    case "2":
                    case "magus":
                        chosenType = Type.MAGUS;
                        break;
                    case "3":
                    case "colossus":
                        chosenType = Type.COLOSSUS;
                        break;
                    case "4":
                    case "dwarf":
                        chosenType = Type.DWARF;
                        break;
                    default:
                        System.out.println("La choix n'est pas une choix valide. reessayez !");
                        break;

                }
                if ((chosenType != null) && usedTypes.contains(chosenType)) {
                    System.out.println("VOus avez deja choisi ce type. le type doit etre unique!");
                    chosenType = null;
                }

            }
            while (chosenType == null);
            //adding to the usedTypes
            usedTypes.add(chosenType);

            String name;
            do {
                System.out.print("Entrez un nom unique : ");
                name = scanner.nextLine().trim().toLowerCase();
                if (usedNames.contains(name)) {
                    System.out.println("Le nom est deja pris. choisissez un autre.");
                    name = null;
                }

            }
            while (name == null || name.isEmpty());
            usedNames.add(name);


            //creation of the character
            Character character = switch (chosenType) {
                case WARRIOR -> new Warrior(name);
                case MAGUS -> new Magus(name);
                case COLOSSUS -> new Colossus(name);
                case DWARF -> new Dwarf(name);

            };
            if (character != null) {
                System.out.println(character.getName());
                player.addCharacter(character);
                usedTypes.add(chosenType);
                System.out.println(character.getName() + " est ajoute a l'equipe!");
            }
        }

    }
}
