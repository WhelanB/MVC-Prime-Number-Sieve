import java.awt.Color;
import java.awt.Font;
import java.util.*;
public class SieveView implements Observer {
	Font arial_italic_10pt;
	public SieveView(SieveModel m){
		StdDraw.setCanvasSize(768, 512); //Change the canvas size to allow for room for both the grid system and number list
		StdDraw.show(); //Show the window
		StdDraw.setXscale(0,768); //These lines change the coordinate system from using 0,0 as the bottom left to using 0,0 as the top left to make it easier to render
		StdDraw.setYscale(512, 0);//Units go from 0,0 to 768,512, with 1 unit being 1 pixel on the canvas
		arial_italic_10pt = new Font("Arial", Font.ITALIC, 10);
		StdDraw.setFont(arial_italic_10pt);//Make the font a little nicer
		StdDraw.text(450, 0, "Prime Numbers"); 
		
		
	}
	//Produces white text with a 1px black outline, ensuring text can be easily read on any background colour
	public void OutlinedText(int x, int y, String text){
		int textX = x * 40;
		int textY = y * 40;
		StdDraw.setPenColor(Color.black);
		StdDraw.text(textX+1, textY, text);
		StdDraw.text(textX-1, textY, text);
		StdDraw.text(textX, textY+1, text);
		StdDraw.text(textX, textY-1, text);
		StdDraw.setPenColor(Color.white);
		StdDraw.text(textX, textY, text);
		StdDraw.setPenColor(Color.gray);
	}
	
	public void update(Observable obs, Object obj) {
		//To-do: Have this run only for the number being update, not for every single number each time!
		boolean[] numbers = (boolean[])obj;
		int y = 0;
		int x = 0;
		for(int i = 2; i < numbers.length; i++){
			if(x == 10){
				y++;
				x = 0;
			}
			if(numbers[i] == false){
				StdDraw.setPenColor(Color.gray);
				StdDraw.text(450 + (x * 30), (y + 2) * 20 , i+"");
			}
			else{
				
				StdDraw.setPenColor(((SieveModel)obs).colors[i]);
			}
				
			StdDraw.filledSquare(x * 40, y * 40, 20);
			StdDraw.setPenColor(Color.black);
			OutlinedText(x, y , i+"");
			x++;
		}
	}
}
