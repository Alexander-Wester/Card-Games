package cardGames;
import java.util.ArrayList;
import java.util.Random;


public class card {
    
private int value;
private String suit;
private int v52;

public card(int a, String b, int c){
    this.value = a;
    this.suit = b;
    this.v52 = c;
}

public int getValue(){
    return this.value;
}
public String getSuit(){
    return this.suit;
}
public int getV52(){
    return this.v52;
}



public static card drawOneCardNoReplace(ArrayList<Integer> arr) {
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

      cardValue = (cardDrawn-1)%13 + 1;

      //int randCardValue = arr.get(randCard);
      //System.out.println("randCardValue is " + randCardValue);
      arr.remove(randCard);
      
      card newCard = new card(cardValue, cardSuit, cardDrawn);
      
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

      public static void printHand(ArrayList<card> deck){
        for(int i=0;i<deck.size();i++){
          System.out.print((i+1) + ": ");    
          deck.get(i).printCard();
        }
    }

        
public static ArrayList<Integer> createDeck(){
    ArrayList<Integer> m = new ArrayList<Integer>();
        
    for (int i=0;i<52;i++){
         m.add(i+1);
    }
    return m;
}

          
public static ArrayList<card> createStartingHand(ArrayList<card> arr, ArrayList<Integer> deck){
    for(int i=0;i<5;i++){
         arr.add(drawOneCardNoReplace(deck));
    }
     return arr;
    }

    public static String getMostSuits(ArrayList<card> hand){
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




}
