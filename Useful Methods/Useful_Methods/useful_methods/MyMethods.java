/*runCommand:String,runCommand:String[],speak:String,arrayToArraylist:String[],arrayToArraylist:int[],arrayToArraylist:Double[],arrayToArraylist:long[],arrayToArraylist:boolean[],openPhotos:,sigmoid:Double,rollDice:int,sigmoid:int,speak:String+String,randomInt:int+int,intArrayToByteArray:int[],byteArrayToIntArray:byte[],modifiedSigmoid:Double+Double,modifiedSigmoid:int+Double,readLines:String,updateTextFile:ArrayList<String>+String,modifiedSigmoidDerivative:Double+Double,inverseModifiedSigmoid:Double+Double,test:,testy:,testy2:*/package useful_methods;import java.io.BufferedReader;import java.io.FileNotFoundException;import java.io.FileReader;import java.io.IOException;import java.io.PrintWriter;import java.nio.ByteBuffer;import java.util.ArrayList;public class MyMethods {public static void runCommand(String command) {			String[] bargs = new String[] {"/bin/bash", "-c", command, "with", "args"};			try {				Process proc = new ProcessBuilder(bargs).start();			} catch (IOException e) {				e.printStackTrace();			}		}public static void runCommand(String[] commands) {			for(String c: commands) {			String[] bargs = new String[] {"/bin/bash", "-c", c, "with", "args"};			try {				Process proc = new ProcessBuilder(bargs).start();			} catch (IOException e) {								e.printStackTrace();			}			}		}public static void speak(String s) {	MyMethods.runCommand("say " + s);}public static ArrayList<String> arrayToArraylist(String[] theArray) {	ArrayList<String> newb = new ArrayList<String>();	for(String sirp: theArray) {		newb.add(sirp);	}	return newb;}public static ArrayList<Integer> arrayToArraylist(int[] theArray) {	ArrayList<Integer> newb = new ArrayList<Integer>();	for(int sirp: theArray) {		newb.add(sirp);	}	return newb;}public static ArrayList<Double> arrayToArraylist(Double[] theArray) {	ArrayList<Double> newb = new ArrayList<Double>();	for(Double sirp: theArray) {		newb.add(sirp);	}	return newb;}public static ArrayList<Long> arrayToArraylist(long[] theArray) {	ArrayList<Long> newb = new ArrayList<Long>();	for(Long sirp: theArray) {		newb.add(sirp);	}	return newb;}public static ArrayList<Boolean> arrayToArraylist(boolean[] theArray) {	ArrayList<Boolean> newb = new ArrayList<Boolean>();	for(Boolean sirp: theArray) {		newb.add(sirp);	}	return newb;}public static void openPhotos() {	MyMethods.runCommand("open -a Photos");}public static double sigmoid(Double d) {			return (1/(1 + Math.pow(Math.E, -d)));		}public static int[] rollDice(int numberOfDice, int numberOfSides)		{		int counter = 0;		boolean rolling = true;		int theTotal = 0;		int results[] = new int[numberOfDice + 1];		for(int i = 0; i< numberOfDice; i ++)		{		int randomNumber = (int) ( (Math.random()) * numberOfSides) + 1;		results[counter] = randomNumber;		theTotal = theTotal + randomNumber;		}		return results;		}public static double sigmoid(int d) {			return (1/(1 + Math.pow(Math.E, -d)));		}public static void speak(String voice, String statement) {	MyMethods.runCommand("say -v " + voice + " " + statement);}public static int randomInt(int range1, int range2) {			return (int) (Math.random()*(range2 - range1 + 1) + range1);		}public static byte[] intArrayToByteArray(int[] intArray) {	byte[] bytes = new byte[intArray.length * 4];		int counter1 = 0;	for(Integer i: intArray) {		ByteBuffer bb = ByteBuffer.allocate(4); 		bb.putInt(i);		byte[] beets = bb.array();		for(byte b: beets) {		bytes[counter1] = b;		counter1++;		}	}	return bytes;}public static int[] byteArrayToIntArray(byte[] byteArray) {	int[] ints = new int[byteArray.length /4];	int counter1 = 0;	for(int i = 0; i < byteArray.length; i+=4) {		byte[] bytes = new byte[4];		bytes[0] = byteArray[i];		bytes[1] = byteArray[i + 1];		bytes[2] = byteArray[i + 2];		bytes[3] = byteArray[i + 3];		int value = ByteBuffer.wrap(bytes).getInt();    ints[counter1] = value;    counter1 ++;	}    	return ints;}public static double modifiedSigmoid(Double d, Double modifier) {		return (1/(1 + Math.pow(Math.E, -d / modifier)));	}public static double modifiedSigmoid(int d, Double modifier) {		return (1/(1 + Math.pow(Math.E, -d / modifier)));	}public static ArrayList<String> readLines(String fileName)	{		String line = null;		ArrayList<String> theLines= new ArrayList<String>();		try			{				FileReader fileReader = new FileReader(fileName);				BufferedReader bufferedReader = new BufferedReader(fileReader);								while ((line = bufferedReader.readLine()) != null)					{						theLines.add(line);											}				bufferedReader.close();			} catch (FileNotFoundException ex)			{				System.out.println("Unable to open file '" + fileName + "'");			} catch (IOException ex)			{				System.out.println("Error reading file '" + fileName + "'");			}				return theLines;	}public static void updateTextFile(ArrayList<String> theLines, String fileName) throws FileNotFoundException {		String toPrint = theLines.get(0);		for(String s: theLines) {			toPrint += "\n";			toPrint += s;		}		PrintWriter writer = new PrintWriter(fileName);        writer.print(toPrint);        writer.close();			}public static double modifiedSigmoidDerivative(Double d, Double modifier) {		double sig = MyMethods.modifiedSigmoid(d, modifier);		double diggidy = sig * (1.0 - sig);				return (Double) (diggidy/modifier);			}public static double inverseModifiedSigmoid(Double d, Double modifier) {		return -1 * modifier * Math.log((1/d) - 1.0);	}public static String test() {		return "maybe baby";	}public static String testy() {		return "maybe baby";	}public static String testy2() {		return "maybe baby";	}}