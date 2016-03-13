import java.awt.Color;
import java.util.*;
public class SieveModel extends Observable {
	boolean[] numbers = new boolean[121];
	public Color[] colors = new Color[121];
	public SieveModel(){
		
	
	}
	
	public void AddView(SieveView v){
		this.addObserver(v); //Register a view
	}
	
	public void UpdatePrime(int index, Color c){
		numbers[index] = true;
		colors[index] = c;
		setChanged(); //Flag the Model as changed (From Observable)
		notifyObservers(numbers); //Notify the view that the model has been changed
	}
	
	public boolean IsPrime(int index){
		return numbers[index];
	}
}
