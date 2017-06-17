import java.io.*;
import java.util.Scanner;
/*	
 *run on athena
 *save as: HmWrk_One.java
  compile:javac HmWrk_One.java
  run  : java HmWrk_One

  end statement with $ character


*/
//set up methods i should keep
public class HmWrk_One{
  static String inputString;
  static int index = 0;
  static int errorflag = 0;

  private char token(){ 
	return(inputString.charAt(index)); 
  }
  private void advancePtr()
  { if (index < (inputString.length()-1)) index++; }

  private void match(char T)
  { if (T == token()) advancePtr(); else error(); }

  private void error()
  {
    System.out.println("error at position: " + index);
    errorflag = 1;
    advancePtr();
  }
//non-terminals 
// find out easier way to predictive parse this  
  private void program(){
	do{
	statemt();
	}while(token()== 'I'||token()== 'F'|| token()== 'N'|| token()== 'O'|| token()== 'X'|| token()== 'Y'|| token()== 'Z');
	match('$');  
  }
  private void statemt()
  { if (token() == 'I') ifstmt (); 
    else if(token() == 'F') For();
    else if(token()== 'N')  Input();
    else if(token()== 'O') output();
    else asignmt(); 
  }
  private void ifstmt()
  {
    match('I');
    comprsn();
    match('@');
    while(token()== 'I'||token()== 'F'|| token()== 'N'|| token()== 'O'|| token()== 'X'|| token()== 'Y'|| token()== 'Z'){
    	statemt();
    }
    if(token()== '%'){
	match('%');
    	while(token()== 'I'||token()== 'F'|| token()== 'N'|| token()== 'O'|| token()== 'X'|| token()== 'Y'|| token()== 'Z'){
		statemt();
	}
    }
    match('&');
  }
  
  private void For(){
  	match('F');
	match('(');
	asignmt();
	match(')');
	match('(');
	comprsn();
	match(')');
	match('L');
	while(token()== 'I'||token()== 'F'|| token()== 'N'|| token()== 'O'|| token()== 'X'|| token()== 'Y'|| token()== 'Z'){
		statemt();
	}
	match('\\');	
  }
  
  private void Input(){
  	match('N');
	indent();
	while(token()== ','){
		match(',');
		indent();
	}
	match(';');
  }

  private void output(){
	match('O');
	indent();
	while(token()== ','){
		match(',');
		indent();
	}
	match(';');
  }

  private void asignmt(){
	indent();
	match('~');
	exprsn();
  }
  
  public void comprsn(){
	match('(');
	oprnd();
	opratr();
	oprnd();
	match(')');
  }

  private void exprsn(){
	factor();
	while(token()== '+' || token()== '-'){
		supmop();
		factor();
	}
  }

  private void factor(){
	oprnd();
	while(token()== '*' || token()== '/'){
	prodop();
	oprnd();
	} 
  }

  private void oprnd(){
	if(token() == '('){
		match('(');
		exprsn();
		match(')');
	} else if(token()== 'X' || token()== 'Y'|| token()== 'Z'){
		indent();
	} else{
		integer();
	}
  }

  private void indent(){
	letter();
	while( token()== 'Z' || token()== 'Y' || token()== 'X'|| token()== '0'|| token()== '1'|| token()== '2'|| token()== '3'|| token()== '4'|| token()== '5'|| token()== '6'|| token()== '7'){
		Char();
	}
  }
  
  private void integer(){
	do{
		digit();
	}while(token()== '1'|| token()== '2'|| token()== '3'|| token()== '4'|| token()== '5'|| token()== '6'|| token()== '7');
  }

  private void digit(){
	if(token()== '1'|| token()== '2'|| token()== '3'|| token()== '4'|| token()== '5'|| token()== '6'|| token()== '7'){ 
		match(token());
	} else error();
  }
	
  private void letter(){
	if( token()== 'Z'|| token()== 'Y'|| token()== 'X'){
		match(token());
	}else error();
  }
  
  private void Char(){
	if( token()== 'Z'|| token()== 'Y'|| token()== 'X'){
		letter();
	} else digit();
  }	 

  private void prodop(){
	if( token()== '*'|| token()== '/'){
		match(token());
	} else error();
  }

  private void supmop(){
	if(token()== '+'|| token()== '-'){
		match(token());
	} else error();
  }

  private void opratr(){
	if( token()== '<'|| token()== '='|| token()== '>'|| token()== '!'){
		match(token());
	} else error();
  }
//start 
  private void start()
  {
    program();
    match('$');

    if (errorflag == 0)
      System.out.println("legal." + "\n");
    else
      System.out.println("errors found." + "\n");
  }
//hi main
  public static void main (String[] args) throws IOException
  {
    HmWrk_One rec = new HmWrk_One();

    Scanner in1eput = new Scanner(System.in);

    System.out.print("\n" + "enter an expression: ");
    inputString = input.nextLine();

    rec.start();
  }
}