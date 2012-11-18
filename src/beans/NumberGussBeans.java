package beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class NumberGussBeans {

	//Sources in wiki => post your solutions projectName_Yourname.tar.gz
	//Random Number
	//guess
	//message
	int randNumber;
	int guess = 0;
	int counter = 0;
	private int GUESS_CONDITION=0;
	private String view;
	Random rand;
	private String msg;
	private String name;
//	private boolean nameStatus;
	
	public NumberGussBeans(){
		init();
	}
	public void init(){
		rand = new Random();
		randNumber = rand.nextInt(100);
		
		counter = 0;
		//setGUESS_CONDITION(1);
	}
	
	public int getGuess() {
		return guess;
	}
	public void setGuess(int guess) {
		this.guess = guess;
		counter++;
	}
	
	
	
			// check the guess
	public String getMsg(){
		if(guess == randNumber){
			msg = "Number of tries: "+counter;
			setGUESS_CONDITION(2);
			try {
				saveRecords();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			init();
		}
		else if(randNumber<guess){
			msg = "smaller than => Number of tries: "+counter;
		}
		else if(randNumber>guess){
			msg = "grater than => Number of tries: "+counter;
			setGUESS_CONDITION(3);
		}
		return msg;
	}
	public int getCounter() {
		return counter;
	}
		
	// vie getter and setter
	
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public int getGUESS_CONDITION() {
		return GUESS_CONDITION;
	}
	public void setGUESS_CONDITION(int guess_condition) {
		GUESS_CONDITION = guess_condition;
	}
	// scores
	public void scores(){
		
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public String getName(){
		return name;
	}
	
	
	public void saveRecords() throws IOException{
		String filePath = "gameResult.txt";
		File file = new File(filePath);
		BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
	    output.write(this.getName()+" "+this.getCounter()+"\n");
	    output.close();
	}
	
}
