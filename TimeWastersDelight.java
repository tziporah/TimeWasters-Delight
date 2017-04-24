package timeWastersDelight;

import java.util.Scanner;
import java.util.Stack;

public class TimeWastersDelight {
	//fields
	private Deck theDeck;
	private Stack<Card> [] stacks; //array of 4 separate stacks of cards

	public TimeWastersDelight(){
		theDeck = new Deck();
		theDeck.shuffle();
		stacks = (Stack<Card>[]) new Stack[4];
		for (int i = 0; i < stacks.length; i++){
			stacks[i] = new Stack<Card>();
			stacks[i].push(theDeck.deal());
		}
		
		
	}
	
	public void display(){
		StringBuilder stackNums = new StringBuilder();
		StringBuilder cards = new StringBuilder();
		Integer cardsLeft = 0;
		for (int i = 0; i <= stacks.length; i++){
			if (i<stacks.length){
				stackNums.append("Stack " + (i+1) + "\t\t\t");
				if (stacks[i].empty()){
					cards.append("     -     \t\t" );
				}
				else {
					cards.append(stacks[i].peek().toString() + "\t\t");
					cardsLeft += stacks[i].size();
				}
			} else if (i == stacks.length){
				cardsLeft += theDeck.cardsLeft();
				stackNums.append("Cards Left");
				cards.append(cardsLeft);
			}
		}
		System.out.println(stackNums);
		System.out.println(cards);
		
		
		
	}
	
	public void discard(int a, int b){
		if(stacks[a].peek().getRank().getValue() == stacks[b].peek().getRank().getValue()){
			stacks[a].pop();
			stacks[b].pop();
		}
	}
	
	public void discard(int a){
		for (int i = 0; i < stacks.length; i++){
			if (stacks[i].empty() == false && stacks[i].peek().getSuit().equals(stacks[a].peek().getSuit())){
				if (stacks[i].peek().getRank().getValue() > stacks[a].peek().getRank().getValue()){
					stacks[a].pop();
					break;
				}
			}
			
		}
	}
	
	public void deal(){
		if (theDeck.cardsLeft() >= 4) {
			for (Stack aStack : stacks){
				aStack.push(theDeck.deal());
			}
		}
		else {
			for (int i = 0; i < theDeck.cardsLeft(); i++){
				stacks[i].push(theDeck.deal());
			}
		}
	}
	
	public void displayMenu(){
		System.out.println("1.If there are two cards with same rank showing, discard both");
		System.out.println("2.If there are two cards of same suit showing, discard one with lower rank");
		System.out.println("3.Deal four new cards, one on top of each stack");
		System.out.println("4.Quit");
	}
	
	public boolean gameWon(){
		boolean gameWon = true;
		if (!this.theDeck.isEmpty()){
			gameWon = false;
		}else{
			for (Stack aStack : stacks){
				if (!aStack.isEmpty()){
					gameWon = false;
					break;
				}
			}
		}
		return gameWon;
	}
	
	
	
	
	public static void main(String [] args){
		
		Scanner keyboard = new Scanner (System.in);
		
		TimeWastersDelight game = new TimeWastersDelight();
		
		while (!game.gameWon()){
			game.display();
			game.displayMenu();
			int choice = keyboard.nextInt();
			int pile1;
			int pile2;
			switch (choice){
			case 1:
				System.out.println("Indicate first pile to discard top card 1,2,3,4");
				pile1 = keyboard.nextInt();
				System.out.println("Indicate second pile to discard top card 1,2,3,4");
				pile2 = keyboard.nextInt();
				game.discard(--pile1, --pile2);
				break;
			case 2:
				System.out.println("Indicate pile with lower rank");
				pile1 = keyboard.nextInt();
				game.discard(--pile1);
				break;
			case 3:
				game.deal();
				break;
			case 4:
				System.out.println("Thank you for playing!");
				System.exit(0);
			}
			
		} 
		
		
		//This code was written and tested by Tziporah Tanenbaum and also tested by Rena Tanenbaum!
		//Since the ranks of jack, king, and queen are all ten, the player cannot necessarily discard two tens that are
			//dealt - only if they actually have the same rank.
		
		
		
		
	}
	
}
