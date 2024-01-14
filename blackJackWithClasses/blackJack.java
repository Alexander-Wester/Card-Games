package blackJackWithClasses;

//import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;



public class blackJack{


    
  public static ArrayList<Integer> createDeck(){
    ArrayList<Integer> m = new ArrayList<Integer>();

    for (int i=0;i<52;i++){
        m.add(i+1);
    }
    return m;

  }




    public static void playBlackJack(Scanner scnr){
        
      
      int i=2;

      int running = 1;
        int playerCheck = 1;
        int dealerCheck = 1;
        int input = 0;

        int playerSum=0;
       // int dealerSum=0;
        int aces=0;

        

        ArrayList<Integer> deck = new ArrayList<Integer>();
        deck = createDeck();

        DrawPlayerCard player = new DrawPlayerCard(aces, deck, playerSum);
        //System.out.println("arr position 3 should be 4, but it is "+ deck.get(3));
        DrawPlayerCard dealer = new DrawPlayerCard(0, deck, 0);

boolean dealerSetup = true;
boolean playerSetup = true;
//boolean dealerAce = true;

        while (running == 1){
          //////dealer
          if (dealerCheck==1){
            if(dealerSetup){
              System.out.print("First dealer draw: ");
            dealer.playerDraw(1);
            dealerSetup=false;
          }
            else{dealer.playerDraw(0);
            System.out.println("Dealer drew a card");
            }
          
          if (dealer.playerSum>16){
            if (dealer.aces>0){
                  dealer.playerSum-=10;
                  aces--;
                }
            
            
            else{
            dealerCheck=0;
            }
          }
          //if(dealerSetup){
            //System.out.println("Dealer value is " + dealer.playerSum);
          //}
          }
          //System.out.println("Dealer running total is "+ dealer.playerSum);


            ////player

            if (playerCheck==1 && i<2){
              System.out.println("Type 1 to hit, type 2 to stand");  
          input = scnr.nextInt();
          if(input==1){
          }
          else if (input==2){
            System.out.println("Standing: Your final total is " + player.playerSum);
            playerCheck=0;
          }
          else{
           System.out.println("Invalid input detected");
            System.exit(0);
          }
            }




            if (playerCheck == 1){
                player.playerDraw(1);
            
            if (player.playerSum>=21){
              if(player.playerSum==21){
                System.out.println("21! Continuing...");
                playerCheck=0;
                continue;
              }
              else{
                if (player.aces>0){
                  player.playerSum-=10;
                  aces--;
                }
                
                else{
                System.out.println("BUST: You lose! Your final total is "+ player.playerSum);
                System.exit(0);}
              }
            }
          System.out.println("Your running total is: " + player.playerSum);
          
          if (playerSetup){
            playerSetup=false;
            continue;
          }
        }
            //System.out.println("player.playersum is " + player.playerSum);



i--;
              if (playerCheck==0 && dealerCheck==0){
                running =0;
              }

        }
        if(player.playerSum>dealer.playerSum || dealer.playerSum>21){
            System.out.println();
             System.out.println("YOU WIN! Your score is " + player.playerSum + " vs dealer score: " + dealer.playerSum);
        }
        else if(player.playerSum==dealer.playerSum){
            System.out.println();
             System.out.println("TIE GAME! Your score is " + player.playerSum + " vs dealer score: " + dealer.playerSum);
        }
        else{
          System.out.println();
          System.out.println("YOU LOSE! Your score is " + player.playerSum + " vs dealer score: " + dealer.playerSum);
        }

    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        playBlackJack(scnr);

    }

}