/*
 * Hello Droids! Android application made as a part of the GDG Legon series on android application development.
 * This application is a simple calculator, which uses buttons to input binary math expressions into a text view, then
 * and then evaluate and display those expressions
 * There are many ways to implement calculators in android, but this simple calculator with a restriction to binary
 * expressions was chosen for relative simplicity, while still illustrating the features of android development. 
 */
package com.GDGLegon.hellodroids;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	//Creating the various java representations of our xml views and widgets
	Button btn1,btnEqual;
	Button btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
	Button btnMultiply,btnDivide,btnAdd,btnSubtract,btnDecimal;
	TextView displayScreen;
	
	Boolean operatorEntered=false; // Boolean variable to tell us if an operator has been input into the text view
	Boolean decimalEntered = false;
	
	String input; // the the input entered into the text view
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Linking the java representations of the xml views to the xml views themselves
		btn0 = (Button) findViewById(R.id.btn0);
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn5 =(Button) findViewById(R.id.btn5);
		btn6 = (Button) findViewById(R.id.btn6);
		btn7 = (Button) findViewById(R.id.btn7);
		btn8 = (Button) findViewById(R.id.btn8);
		btn9 = (Button) findViewById(R.id.btn9);
		btnMultiply = (Button) findViewById(R.id.btnMultiply);
		btnSubtract = (Button) findViewById(R.id.btnSubtract);
		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnDivide =(Button)  findViewById(R.id.btnDivide);
		btnDecimal = (Button) findViewById(R.id.btnDecimal);
		btnEqual = (Button) findViewById(R.id.btnEqual);
		displayScreen = (TextView) findViewById(R.id.txtResult);
	}
	
	/*
	 * The following functions would be called when the xmls view which have their method names in them are clicked
	 * Eg. Since the XML view btn1 has disp1 in it's onClick field, disp1 would run when btn1 is clicked.
	 * Note that this is just one way to call button clicks. There are other ways to do this. 
	 */
	public void disp1(View v){
		input= (String) displayScreen.getText();
		input = input +"1";
		displayScreen.setText(input);
	}
	public void disp2(View v){
		input= (String) displayScreen.getText();
		input = input +"2";
		displayScreen.setText(input);
	}
	public void disp3(View v){
		input= (String) displayScreen.getText();
		input = input +"3";
		displayScreen.setText(input);
	}
	public void disp4(View v){
		input= (String) displayScreen.getText();
		input = input +"4";
		displayScreen.setText(input);
	}
	public void disp5(View v){
		input= (String) displayScreen.getText();
		input = input +"5";
		displayScreen.setText(input);
	}
	public void disp6(View v){
		input= (String) displayScreen.getText();
		input = input +"6";
		displayScreen.setText(input);
	}
	public void disp7(View v){
		input= (String) displayScreen.getText();
		input = input +"7";
		displayScreen.setText(input);
	}
	public void disp8(View v){
		input= (String) displayScreen.getText();
		input = input +"8";
		displayScreen.setText(input);
	}
	public void disp9(View v){
		input= (String) displayScreen.getText();
		input = input +"9";
		displayScreen.setText(input);
	}
	public void disp0(View v){
		input= (String) displayScreen.getText();
		input = input +"0";
		displayScreen.setText(input);
	}
	
	/*
	 * The methods called when the operators are clicked would do same as when the numbers are clicked, 
	 * however, once one operator is added, another cant be added. Thus, the operatorEntered variable is set to 
	 * true when an operator is entered. If another operator is clicked after one has already been added,
	 * a Toast message pops up, and tells the user that he/she cannot add more operators, unless the input is cleared.
	 */
	public void dispAddition(View v){
		if(operatorEntered == true){
			Toast.makeText(getApplicationContext(),"You can only enter one operator per operation" , Toast.LENGTH_SHORT).show();
		}
		else{
			input= (String) displayScreen.getText();
			input = input +"+";
			displayScreen.setText(input);
			operatorEntered= true;
			decimalEntered=false;
		}
	}
	public void dispSubtraction(View v){
		if(operatorEntered == true){
			Toast.makeText(getApplicationContext(),"You can only enter one operator per operation" , Toast.LENGTH_SHORT).show();
		}
		else{
			input= (String) displayScreen.getText();
			input = input +"-";
			displayScreen.setText(input);
			operatorEntered= true;
			decimalEntered=false;
		}
		
	}
	public void dispMultiplication(View v){
		if(operatorEntered == true){
			Toast.makeText(getApplicationContext(),"You can only enter one operator per operation" , Toast.LENGTH_SHORT).show();
		}
		else{
			input= (String) displayScreen.getText();
			input = input +"*";
			displayScreen.setText(input);
			operatorEntered= true;
			decimalEntered=false;
		}
		
	}
	public void dispDivision(View v){
		if(operatorEntered == true){
			Toast.makeText(getApplicationContext(),"You can only enter one operator per operation" , Toast.LENGTH_SHORT).show();
		}
		else{
			input= (String) displayScreen.getText();
			input = input +"/";
			displayScreen.setText(input);
			operatorEntered= true;
			decimalEntered=false;
		}
		
	}
	public void dispDecimal(View v){
		if(decimalEntered == false){
			input= (String) displayScreen.getText();
			input = input +".";
			displayScreen.setText(input);
			operatorEntered= false;
			decimalEntered=true;
		}
		else {
			Toast.makeText(getApplicationContext(),"You can only enter one decimal point per number" , Toast.LENGTH_SHORT).show();
		}
			

	}
	
	/*
	 * The equal to operator would be the heart of our calculator logic.
	 * What we want to do is that when the user clicks the equal to, we search through the input for an
	 * operator. The operator we find determines the operation we are to take.
	 * At the point where we find the operator, we split the rest of the input into two parts. 
	 * Each part is converted to a double data type, and operated upon.
	 * The result is then displayed. 
	 * 
	 * Note: the \\ is used before each of the operators because they are special characters and must be 'escaped'
	 * Read more on escape sequences to learn about this.
	 */
	
	public void evaluate(View v){
		String operatorUsed ;
		String [] splitValues;
		double num1=0;
		double num2=0;
		double result;

		if(input.contains("+")){
			splitValues = input.split("\\+");
			num1 = Double.valueOf(splitValues[0]);
			num2 = Double.valueOf(splitValues[1]);
			result = num1+num2;
			displayScreen.setText(String.valueOf(result));
		}
		else if(input.contains("-")){
			splitValues = input.split("\\-");
			num1 = Double.valueOf(splitValues[0]);
			num2 = Double.valueOf(splitValues[1]);
			result = num1-num2;
			displayScreen.setText(String.valueOf(result));
		}
		else if(input.contains("/")){
			splitValues = input.split("\\/");
			num1 = Double.valueOf(splitValues[0]);
			num2 = Double.valueOf(splitValues[1]);
			//We need to check that num2 is not 0. If it is, we display an error
			if(num2==0){
				Toast.makeText(getApplicationContext(),"Error! Cannot divide by 0!", Toast.LENGTH_SHORT).show();
				displayScreen.setText("");
			}
			else{
				result = num1/num2;
				displayScreen.setText(String.valueOf(result));
			}
		}
		else if(input.contains("*")){
			splitValues = input.split("\\*");
			num1 = Double.valueOf(splitValues[0]);
			num2 = Double.valueOf(splitValues[1]);
			result = num1*num2;
			displayScreen.setText(String.valueOf(result));
		}
		
		operatorEntered= false; // Once the expression has been evaluated, we can allow another expression to be evaluated 
		
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		/*
		 * Here, the actionbar element is called action_clear, and when it is clicked, it clears
		 * what ever is in the textview. 
		 */
		if (id == R.id.action_clear) {
			displayScreen.setText("");
			operatorEntered = false;
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
