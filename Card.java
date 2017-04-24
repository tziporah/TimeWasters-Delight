package timeWastersDelight;

public class Card {
	
	private Rank rank;
	private Suit suit;
	private Color color;
	
	public Card(Rank rank, Suit suit, Color color){
		this.rank = rank;
		this.suit = suit;
		this.color = color;
	}
	
	public Card(String rank, String suit, String color){
		try{
			Rank aRank = null;
			aRank = Rank.valueOf(rank.toUpperCase());
			System.out.println ("Beginning search for " + rank + "...");
			}catch(IllegalArgumentException ex){
				System.out.println("Please choose from one of the following ranks.");
				for (Rank option : Rank.values()){
				System.out.println(option.name());
				}//end for each
			}//end catch
			
		try{
			Suit aSuit = null;
			aSuit = Suit.valueOf(suit.toUpperCase());
			System.out.println ("Beginning search for " + suit + "...");
			}catch(IllegalArgumentException ex){
				System.out.println("Please choose from one of the following suits.");
				for (Suit option : Suit.values()){
				System.out.println(option.name());
				}//end for each
			}//end catch
			
		try{
			Color aColor = Color.valueOf(color.toUpperCase());
			System.out.println ("Beginning search for " + color + "...");
			}catch(IllegalArgumentException ex){
				System.out.println("Please choose from one of the following colors.");
				for (Color option : Color.values()){
					System.out.println(option);
				}//end for each
			}//end catch
			
	}
	
	public Rank getRank(){
		return this.rank;
	}
	
	public Suit getSuit(){
		return this.suit;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public String toString(){
	
			return "Card " + this.rank.getValue() + " " + this.getSuit();
		
	}

}
