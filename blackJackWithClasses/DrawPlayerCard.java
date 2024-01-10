package blackJackWithClasses;
import java.util.ArrayList;
import java.util.Random;


public class DrawPlayerCard {

public int aces;
private ArrayList<Integer> d = new ArrayList<Integer>();
public int playerSum;

public DrawPlayerCard(int a, ArrayList<Integer> b, int c){
this.aces = a;
this.d = b;
this.playerSum=c;
}





    public static int drawOneCardNoReplace(ArrayList<Integer> arr, int a) {
        int cardsInPile = arr.size();
        String cardSuit = "Spades";
        int cardValue;
        String cardFaceValue = "Spades";
    
    
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
    
          cardValue = (cardDrawn-1)%13 + 1;
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


         int randCardValue = arr.get(randCard);
         //System.out.println("randCardValue is " + randCardValue);
         arr.remove(randCard);
         return randCardValue;
        }






    //public static int drawOneCardNoReplace(ArrayList<Integer> arr){
        //return arr.remove(drawOneCard(arr));
    //}



    public DrawPlayerCard playerDraw(int a){
        //System.out.println("1playerSum is " + this.playerSum);

        //drawOneCardNoReplace(arr);
        int val = drawOneCardNoReplace(this.d, a);
        //System.out.println("val is "+ val);
        val = blackJackValue(val);
        //System.out.println("post BJV val is "+ val);
        if (val == 11){
        aces++;
        }

        playerSum = playerSum + val;
   
        //System.out.println("2playerSum is " + playerSum);

        DrawPlayerCard result = new DrawPlayerCard(aces,this.d,playerSum);
   return result;
   
   
    }



    public static int blackJackValue(int drawnCard){
        int yourHandValue = 0;

      drawnCard = (((drawnCard-1)%13)+1);


    if(drawnCard>=10){
      yourHandValue=10;
    }

  else if(drawnCard == 1){
    yourHandValue=11;
    //aces++;
  }
  else{
    yourHandValue=drawnCard;
  }

return yourHandValue;
    }




    public static void main(String[] args) {

    }







}