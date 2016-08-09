package safeSelling.util;

import java.util.ArrayList;
import java.util.List;

public class StringConversions {

	public static List<String> stringToList(String inp, String delimiter) {

		String[] arr = inp.split(delimiter);
		List<String> list = new ArrayList<String>();
		for (String element : arr) {
			list.add(element);
		}
		return list;
	}

	public static String listToString(List<String> inp, String delimiter) {

		String singleStr = "";
		for(String element : inp) {
			singleStr = singleStr.concat(element + delimiter);
		}
		return singleStr;
	}

	/*testing 

	public static void main(String args[]){
		String abc = "car;bike;autos;parts";
		List<String> output = new ArrayList<String>();
		output = stringToList(abc, ";");

		for(String element : output){
			System.out.println("This is " + element);
		}

		String result= listToString(output, ":");
		System.out.println(result);
	}
	 */
}
