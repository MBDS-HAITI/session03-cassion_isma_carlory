package org.example;

import java.util.List;
import java.util.Scanner;

public class Battle {
    private Player player1;
    private Player player2;
    private int countRound = 0;

    private final Scanner scanner = new Scanner(System.in);

    public Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        System.out.println("====== Le Combat a commencé======");
        Player actif = player1;
        Player opponent = player2;

        while (!player1.isDefeated() && !player2.isDefeated())
        {
            System.out.println("\n ---- Round " + countRound + "----");
            System.out.println("Tour de " + actif.getName());

            displayTeams();

            Character active =  chooseAlveCharacter(actif,scanner);
            if(active==null) {
                System.out.println(actif.getName() + "n'a plus de caracteres en vie!");
                break;
            }

            if(active instanceof Healer healer){
                System.out.println("Choose action: 1- Attack  2- Heal");
                String choice = scanner.nextLine();

                if (choice.equals("2")) {
                    Character ally= chooseAlveCharacter(actif,scanner);
                    healer.heal(ally);
                }
                else{
                    Character enemy = chooseAlveCharacter(opponent,scanner);

                    if (active instanceof  Attacker attacker){
                        attacker.attack(enemy);
                    }
                    else {
                        System.out.println(active.getName() + "ne peut pas attaquer!");
                    }

                }

            }
            else  if (active instanceof Attacker attacker){
                Character enemy = chooseAlveCharacter(opponent,scanner);
                attacker.attack(enemy);
            }

            //verify if the opponet is defeated

            if (opponent.isDefeated()) {
                System.out.println(actif.getName() + "a gagne apres " + countRound + " rounds" );
                break;
            }

            Player temp = actif;
            actif = opponent;
            opponent = temp;

        }
        displayFinalStatus();


    }


    private void displayTeams()
    {
        System.out.println("Equipe "+ player1.getName());
        player1.getCharacters().forEach(character ->
                System.out.println(" - "+character.getName() + character.getHp()+ "HP"));

        System.out.println("Equipe "+ player2.getName());
        player2.getCharacters().forEach(character ->
                System.out.println(" - "+character.getName() + character.getHp()+ "HP"));

    }

    private Character chooseAlveCharacter(Player player, Scanner scanner)
    {
        List<Character> aliveCharacters = player.getCharacters();
        if(aliveCharacters.isEmpty())
        {
            System.out.println(" Aucun personnage vivant pour "+player.getName());
            return null;
        }
        //show alive characters

        System.out.println("\n"+ player.getName()+ ", chosis un personnage");
        for(int i=0;i<aliveCharacters.size();i++){
            Character c= aliveCharacters.get(i);
            System.out.printf("[%d] %s (%s, %d HP) %n",i+1,c.getName(), c.getType().name(),c.getHp());
        }

        //read and validate the choice

        int choice = -1;
        while(true)
        {
            System.out.print("Entrez le numero de ton choix: ");
            try{
                choice = Integer.parseInt(scanner.nextLine().trim());
                if(choice>=1 && choice<=aliveCharacters.size())
                {
                    break;
                }
                else {
                    System.out.println(" Choix invalide. reessayez !");

                }
            }
            catch (NumberFormatException e){
                System.out.println(" valeur saisie invalide. entrez un nombre ");
            }
        }
        Character chosen = aliveCharacters.get(choice-1);
        System.out.println(chosen.getName() + "selectionne !");
        return chosen;

    }
     private void displayFinalStatus(){
         System.out.println("\n=== Resume de la bataille ===");
         System.out.println("ROund total : "+countRound+ "\n");

         showTeamStatus(player1);
         showTeamStatus(player2);
     }



    private  void showTeamStatus(Player player){
        System.out.println("Equipe "+ player.getName() + " : ");
        for (Character character : player.getCharacters()) {
            String status = character.isAlive() ? "Vivant": "Mort";
            System.out.println(" - "+ character.getName() +  " (" + character.getClass().getSimpleName() + "): " +character.getHp()+ "HP - "+ status);
        }
        System.out.println();
    }


}
