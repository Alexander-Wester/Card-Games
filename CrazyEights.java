

//eights wild, 2 draw 2, ace skip;
//github test

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CrazyEights{
    private int value;
    private String suit;
    private int val52;


    public CrazyEights(int v, String s, int v2){
        this.value =v;
        this.suit = s;
        this.val52 = v2;
    }

      public int getValue(){
return this.value;
      }
     
      public String getSuit(){
        return this.suit;
      }
      public int getVal52(){
        return this.val52;
      }

      
      
      
      public static ArrayList<Integer> createDeck(){
        ArrayList<Integer> m = new ArrayList<Integer>();
    
        for (int i=0;i<52;i++){
            m.add(i+1);
        }
        return m;
    
      }




    public static CrazyEights drawOneCardNoReplace(ArrayList<Integer> arr) {
        int cardsInPile = arr.size();
        String cardSuit = "Spades";
        int cardValue;
        //String cardFaceValue = "Spades";


          int cardDrawn;
          Random randGen = new Random();
          int randCard = randGen.nextInt(cardsInPile);

          //System.out.println("randCard is " + randCard);
    
          cardDrawn = arr.get(randCard);
          //System.out.println("cardDrawn is " + cardDrawn);
    
     
          if(cardDrawn<=13){
            cardSuit = "Spades";
          }
          else if ((cardDrawn<=26) && (cardDrawn>13)){
              cardSuit = "Hearts";
          }
          else if ((cardDrawn<=39) && (cardDrawn>26)){
              cardSuit = "Clubs";
          }
          else if ((cardDrawn<=52) && (cardDrawn>39)){
              cardSuit = "Diamonds";
          }
    
          
        /* 
         
          
          if(cardValue == 11){
            cardFaceValue = "Jack";
          }
          else if(cardValue == 12){
            cardFaceValue = "Queen";
          }
          else if(cardValue == 13){
            cardFaceValue = "King";
          }
          else if(cardValue == 1){
            cardFaceValue = "Ace";
          }
    
   
          if (a==1){
        if (cardValue<=10 && cardValue != 1){
          System.out.println("Card drawn is the " + cardValue + " of " + cardSuit);
        }
         else {
           System.out.println("Card drawn is the " + cardFaceValue + " of " + cardSuit);
         } 
          //System.out.println(", Size is " + arr.size());
        // System.out.println("randCard is " + randCard);
        }  
*/

cardValue = (cardDrawn-1)%13 + 1;

         //int randCardValue = arr.get(randCard);
         //System.out.println("randCardValue is " + randCardValue);
         arr.remove(randCard);
         
         CrazyEights newCard = new CrazyEights(cardValue, cardSuit, cardDrawn);
         
         return newCard;
        }

public void printCard(){
  
  int cardValue = this.value;
  String cardFaceValue = "";
  
  if(cardValue == 11){
    cardFaceValue = "Jack";
  }
  else if(cardValue == 12){
    cardFaceValue = "Queen";
  }
  else if(cardValue == 13){
    cardFaceValue = "King";
  }
  else if(cardValue == 1){
    cardFaceValue = "Ace";
  }

if(cardValue!=1 && cardValue <=10){
  System.out.println(cardValue + " of " + this.suit);
}
else{
  System.out.println(cardFaceValue + " of " + this.suit);
}


}



  public static void printHand(ArrayList<CrazyEights> deck){
      for(int i=0;i<deck.size();i++){
        System.out.print((i+1) + ": ");    
        deck.get(i).printCard();
      }
  }

  public static ArrayList<CrazyEights> createStartingHand(ArrayList<CrazyEights> arr, ArrayList<Integer> deck){
    for(int i=0;i<5;i++){
      arr.add(drawOneCardNoReplace(deck));
    }
    return arr;
  }

    public static String getMostSuits(ArrayList<CrazyEights> hand){
      int h=0;
      int d=0;
      int s=0;
      int c=0;
      
      for(int i=0;i<hand.size();i++){
        if(hand.get(i).getValue()==8){
          continue;
        }  
        if(hand.get(i).getSuit().compareTo("Hearts")==0){
            h++;
          }
        else if(hand.get(i).getSuit().compareTo("Diamonds")==0){
            d++;
          } 
        else if(hand.get(i).getSuit().compareTo("Spades")==0){
            s++;
          }
        else if(hand.get(i).getSuit().compareTo("Clubs")==0){
            c++;
          }
        }
        int highest=h;
        if (highest<d){
          highest=d;
        }
        if (highest<s){
          highest=s;
        }
        if (highest<c){
          highest=c;
        }

          if(highest==h){
            return "Hearts";
          }
          if(highest==d){
            return "Diamonds";
          }
          if(highest==c){
            return "Clubs";
          }
          if(highest==s){
            return "Spades";
          }
          else {
            return "Error";
          }



        }

    




  public static void playCrazyEights(Scanner scnr) throws InputMismatchException {

    ArrayList<Integer> deck = new ArrayList<Integer>();
    deck = createDeck();

    ArrayList<CrazyEights> yourHand = new ArrayList<CrazyEights>();
    createStartingHand(yourHand,deck);

    ArrayList<CrazyEights> oppHand = new ArrayList<CrazyEights>();
    createStartingHand(oppHand,deck);

    ArrayList<CrazyEights> discardPile = new ArrayList<CrazyEights>();

    CrazyEights topCard = drawOneCardNoReplace(deck);
    String highSuit = "";

    int input;
    int input2;
    boolean validInput = false;
    boolean yourTurnSkipped = false;
    boolean oppTurnSkipped = false;
    boolean youPickUpTwo = false;
    boolean oppPicksUpTwo = false;


    System.out.println("Welcome to crazy eights!");
    System.out.println("You play against 1 AI");
    System.out.println("Quick rules:");
    System.out.println("You must play a card that matches the suit, or number/face");
    System.out.println("Or an 8, which can be played at any time and allows you to choose the suit");
    System.out.println("aces skip the other players turn, 2 also skip and forces them to draw 2 cards");
    System.out.println("First one to play all of their cards wins");
    System.out.printf("\n----------------------------------------\n\n");
    
        
        
    while(yourHand.size() != 0 && oppHand.size() !=0){

      if(deck.size()<5){
        System.out.println("Shuffling discard pile back into the deck");
        while(discardPile.size()>0){
          deck.add(discardPile.get(0).getVal52());
          discardPile.remove(0);
        }
      }



        System.out.println("The opponent has " + oppHand.size() + " cards");
        //System.out.println("The discard pile has " +discardPile.size() + " cards");
        //System.out.println("The draw pile has "+deck.size()+" cards");
        //System.out.println("Cards accounted for: " + (oppHand.size() + yourHand.size() + 1 + discardPile.size() + deck.size()));
        System.out.print("The top card is ");
        
        if(topCard.getVal52() != 53){
        topCard.printCard();
        }
        else{
          discardPile.get(discardPile.size()-1).printCard();
          System.out.println("but, you must play an eight or a " + topCard.getSuit());
        }
        
        System.out.println();
       

        while(!validInput && !yourTurnSkipped && !youPickUpTwo){

        System.out.println("Your hand: ");
        printHand(yourHand);
        System.out.println((yourHand.size()+1)+": Draw 1 card");
        System.out.println();

        
         
          System.out.println(" Please select a card # to play");
          try{
            input = scnr.nextInt();
            if(input>yourHand.size()+1 || input<=0){
              System.out.println("That option does not exist");
              continue;
            }
          }
          catch(InputMismatchException excep){
            System.out.println("Please select a card number (integer)");
            scnr.nextLine();
            continue;
          }          
          
          if(input==(yourHand.size()+1)){
            yourHand.add(drawOneCardNoReplace(deck));
            System.out.println("You drew a card");
            break;
          }

          if(yourHand.get(input-1).getValue() == 8){
              System.out.println("Wildcard played, what suit would you like to be played?");
              System.out.printf("1:hearts\n2:diamonds\n3:spades\n4:clubs\n");
              
              if(topCard.getVal52()!=53){
              discardPile.add(topCard);
              }

              while(true){
                try{
                  input2 = scnr.nextInt();
                    if(input2 == 1){
                      System.out.println("Top card is the 8 of " + yourHand.get(input-1).getSuit() +" but the next card played must be an eight or a Heart");
                      topCard = new CrazyEights(8, "Hearts", 53);
                      break;
                    }
                    if(input2 == 2){
                      System.out.println("Top card is the 8 of " + yourHand.get(input-1).getSuit() +" but the next card played must be an eight or a Diamond");
                      topCard = new CrazyEights(8, "Diamonds", 53);
                      break;
                    }
                    if(input2 == 3){
                      System.out.println("Top card is the 8 of " + yourHand.get(input-1).getSuit() +" but the next card played must be an eight or a Spade");
                      topCard = new CrazyEights(8, "Spades", 53);
                      break;
                    }
                    if(input2 == 4){
                      System.out.println("Top card is the 8 of " + yourHand.get(input-1).getSuit() +" but the next card played must be an eight or a Club");
                      topCard = new CrazyEights(8, "Clubs", 53);
                      break;
                    }
                    else{
                      System.out.println("Invalid input, try again");
                    }
              }
              catch(InputMismatchException exc){
                System.out.println("Invalid input, try again (integer needed)");
                scnr.nextLine();
                continue;
              }


            }
            discardPile.add(yourHand.get(input-1));
            yourHand.remove(input-1);
            break;
          }





          if(yourHand.get(input-1).getValue() == topCard.getValue() || yourHand.get(input-1).getSuit().compareTo(topCard.getSuit())==0){
          
          if(yourHand.get(input-1).getValue()==2){
            oppPicksUpTwo = true;
          }
          if(yourHand.get(input-1).getValue()==1){
            oppTurnSkipped = true;
          }
          
          if(topCard.getVal52()!=53){
            discardPile.add(topCard);
            }

          topCard = yourHand.get(input-1);
          System.out.print("card accepted, top card is now the ");
          topCard.printCard();
          yourHand.remove(input-1);
          break;
        }  
          else{
            System.out.println("That card cannot be played");
          }
          
          //printHand(yourHand);
          
          System.out.println();

        }

        if(youPickUpTwo || yourTurnSkipped){
          System.out.println("Your turn is skipped");

            if(youPickUpTwo){
              System.out.println("You pick up 2 cards");
              yourHand.add(drawOneCardNoReplace(deck));
              yourHand.add(drawOneCardNoReplace(deck));

            }
              youPickUpTwo = false;
              yourTurnSkipped = false;   
        }
        
      
      
      if(yourHand.size() == 0){
        break;
      }

      System.out.println();
      System.out.println("Opponent's turn");


      if(oppTurnSkipped || oppPicksUpTwo){ 
        System.out.println("Opponent turn skipped");
          oppTurnSkipped = false;
          if(oppPicksUpTwo){
            System.out.println("Opponent picks up 2 cards");
            oppHand.add(drawOneCardNoReplace(deck));
            oppHand.add(drawOneCardNoReplace(deck));
            oppPicksUpTwo = false;
          }
          System.out.println();
          continue;
      }


      for(int i=0;i<oppHand.size();i++){
          if (oppHand.get(i).getValue()==8){
            highSuit = getMostSuits(oppHand);
            System.out.println("Opponent played the eight of " + oppHand.get(i).getSuit() + ", and has chosen the suit to be " + highSuit);
            
            


            if(topCard.getVal52()!=53){
              discardPile.add(topCard);
              }
              discardPile.add(oppHand.get(i));
              oppHand.remove(i);
            
            topCard= new CrazyEights(8, highSuit, 53);
            break;
          }
        
        
        
        if(oppHand.get(i).getSuit().compareTo(topCard.getSuit())==0 || oppHand.get(i).getValue() == topCard.getValue()){
            
          if(oppHand.get(i).getValue()==2){
            youPickUpTwo = true;
          }
          if(oppHand.get(i).getValue()==1){
            yourTurnSkipped = true;
          }
          
          if(topCard.getVal52()!=53){
            discardPile.add(topCard);
            }

          topCard = oppHand.get(i);
            oppHand.remove(i);
            System.out.print("Oppenent played, top card is now ");
            topCard.printCard();
            break;
          }
          else if(i==oppHand.size()-1){
            System.out.println("Opponent picked up a card");
            oppHand.add(drawOneCardNoReplace(deck));
            break;
            }
          }

        }
      
    System.out.println("Game over");
    if(yourHand.size() == 0){
      System.out.println("You win!");
    }
    else{
      System.out.println("You lose");
    }
    
    

  }

    //}

    
  




        public static void main(String[] args) {
          Scanner scnr = new Scanner(System.in);
          playCrazyEights(scnr);

          //CrazyEights test;
          //test = drawOneCardNoReplace(deck);






          
          
          }






}