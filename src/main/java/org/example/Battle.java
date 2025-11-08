package org.example;

public class Battle {
    private Player player1;
    private Player player2;
    private int countRound = 0;

    public Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        System.out.println("====== Le Combat a commencé======");
        Player actif = player1;
        Player Opponent = player2;

        while (!player1.isDefeated() && !player2.isDefeated())
        {
            System.out.println("\n ---- Round " + countRound + "----");
            System.out.println("Tour de " + actif.getName());

            displayTeams();

           /* boolean active = player1.isDefeated();
            if(!active) {
                System.out.println(player1.getName() + "n'a plus de caracteres en vie!");
                break;
            }*/





        }

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


}
