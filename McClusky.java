/*
NAME: Bryan Chan
SCHOOL: Middlesex County Academy for Science, Mathematics, and Engineering Technologies
GRADE: 9
DIVISION: Junior - 5
ROUND: Practice Test #1
PROGRAM NAME: Quine-McCluskyAlgorithm
LANGUAGE: Java

Pledge: I have neither given nor recieved help, nor will I give help on this program or any other program.
*/


import java.util.*;
import java.lang.*;

public class McClusky {
	
	public static void clear() { //method that clears the screen
		for(int i = 0; i < 50; i++) {
			System.out.println("");
		}
	} //end method clear
	
	public static String getBinaryNum(int input) { //method that gets a binary number
		String ab = "a";
		
		//hardcoding every possibility
		if(input == 0) {
			ab = "0000";
		}
		else if(input == 1) {
			ab = "0001";
		}
		else if(input == 2) {
			ab = "0010";
		}
		else if(input == 3) {
			ab = "0011";
		}
		else if(input == 4) {
			ab = "0100";
		}
		else if(input == 5) {
			ab = "0101";
		}
		else if(input == 6) {
			ab = "0110";
		}
		else if(input == 7) {
			ab = "0111";
		}
		else if(input == 8) {
			ab = "1000";
		}
		else if(input == 9) {
			ab = "1001";
		}
		else if(input == 10) {
			ab = "1010";
		}
		else if(input == 11) {
			ab = "1011";
		}
		else if(input == 12) {
			ab = "1100";
		}
		else if(input == 13) {
			ab = "1101";
		}
		else if(input == 14) {
			ab = "1110";
		}
		else if(input == 15) {
			ab = "1111";
		}
		return ab;
	} //end method getBinaryNum
	
	public static void main(String args[]) { //begins main method
		
		//Initizliation
		Scanner input = new Scanner(System.in); //the scanner for this class
		boolean[] minterms = new boolean[16]; //this array is used to check if the certain minterm is a 1
		
		
		//Code
		clear(); //#asthetic
		System.out.println("NOTE: Make sure you put a comma AND A SPACE between every number inputted!");
		System.out.println("Enter Minterms: ");
		String minterm = input.nextLine(); //gets the keyboard's input from the user
		
		minterm = minterm.replaceAll("," , ""); //erases the commas from the input, just leaves the spaces
		String[] terms = minterm.split(" "); //splits the string by the spaces...that's why typing in the spaces is so important!
		
		
		for(int i = 0; i < terms.length; i++) { //goes through every character, checks what's inside this loop
				int y = Integer.parseInt(terms[i]); //finds the integer value of the string
				if(y == -1) { //if y is -1 that means the list is done!
					break;
				} //end if statement
				else {
					minterms[y] = true; //sets the value to true to be used later!
				} //end else statement
		} //end for loop
		
		for(int times = 0; times < 5; times++) { //runs through this code 6 times for the 6 inputs, begin for loop
			int x1 = 1, x2 = 1; //defines the two integers that will take the inputs
			String s = input.nextLine(); //takes the next string input
			s = s.replaceAll("," , "");
			String nums[] = s.split(" ");
			
			for(int i = 0; i < nums.length; i++) { //goes through all the array slots
				String z1 = nums[0]; //temperary storage so the parseInt always works
				String z2 = nums[1];
				x1 = Integer.parseInt(z1); //takes the integer value of the string
				x2 = Integer.parseInt(z2);
			} //end for loop
			
			
			
			String Binary1 = getBinaryNum(x1); //returns the binary number of x1
			String Binary2 = getBinaryNum(x2); //returns the binary number of x2
			
			//System.out.println(Binary1 + ", " + Binary2);
			//This Statement above troubleshoots the program!
			
			char[] num1 = Binary1.toCharArray(); //splits String Binary1 into a character array
			char[] num2 = Binary2.toCharArray(); //splits String Binary2 into a character array
			int counter = 0; //counts how many similarities there are, if it is less than 3, then nonefinish becomes true
			boolean nonefinish = false; //if this is true, the numbers cannot be simplified
			String letter1 = ""; //substitute for Letter A
			String letter2 = ""; //substitute for Letter B
			String letter3 = "";//substitute for Letter C
			String letter4 = "";//substitute for Letter D
			
			if(minterms[x1] == false) { //this checks if the first input is one of the valid minterms from the first line
				nonefinish = true;
			}
			else if(minterms[x2] == false) { //this checks if the second input is one of the valid minterms from the first line
				nonefinish = true;
			}
			
			
			for(int check = 0; check < 4; check++) { //comparing numbers
				//marking the letters and labelling them for use later, kind of hardcoded
				if(num1[check] == num2[check]) { //if the two numbers are equal to eachother
					if(check == 0) {
						letter1 = "A"; 
						if(num1[check] == '0') {
							letter1 = "a";
						}
					}
					if(check == 1) {
						letter2 = "B";
						if(num1[check] == '0') {
							letter2 = "b";
						}
					}
					if(check == 2) {
						letter3 = "C";
						if(num1[check] == '0') {
							letter3 = "c";
						}
					}
					if(check == 3) {
						letter4 = "D";
						if(num1[check] == '0') {
							letter4 = "d";
						}
					}
				}
				
				else if(num1[check] != num2[check]) { //this checks if there is a difference in which it will put an 'x' in replace of the number
						num1[check] = 'x';
				}
			}
			
			for(int z = 0; z < 4; z++) {
				if(num1[z] == 'x') { //checks how many differences are in the two numbers
					counter++;
					if(counter > 1) { //if the differences are over one...
						nonefinish = true; //the numbers cannot be simplified
					}
				}
			}
			
			
			System.out.println(""); //just whitespace for asthetically pleasing
			
			if(nonefinish) { //if the numbers cannot be simplified...
				System.out.println("NONE"); ///print out the desired output
			}
			else { //otherwise...print out the numbers and the letters
				for(int i = 0; i < num1.length; i++) {
					System.out.print(num1[i]);
				}
				System.out.print(", " + letter1 + letter2 + letter3 + letter4);
				
			}
			
			System.out.println(""); //#asthetic
			
			
		} //end for loop
		
		
		
		
		 
	} //end main method
} //end class
	
	
	
	
