package timeWastersDelight;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Rank[] ranks = Rank.values();
	private Suit [] suits = Suit.values();
	private Color[] colors = Color.values();
	
	public Deck(){
		Rank rank;
		Suit suit;
		Color color;
		for (int s = 0; s < 4; s++){
			suit = suits[s];
			
			if (s < 2){
				color = colors[0];
			}
			else {
				color = colors[1];
			}
			
			for (int r = 0; r < 13; r++){
				rank = ranks[r];
				
				cards.add(new Card(rank, suit, color));
			}//end for rank
		}//end for suit
	}//end constructor
	
	public void shuffle(){
		Random rand = new Random();
		Card temp;
		
		for (int i = 0; i < cards.size(); i++){
			int position = rand.nextInt(51);
			temp = cards.get(i);
			cards.set(i, cards.get(position));
			cards.set(position, temp);
		}
	}
	
	public Card deal(){
		Card top = cards.get(0);
		cards.remove(0);
		return top;
	}
	
	public boolean isEmpty(){
		return cards.isEmpty();
	}
	
	public Integer cardsLeft(){
		return cards.size();
	}
	
	

}//end class


