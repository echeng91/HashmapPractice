import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter; 
import java.io.IOException; 
import java.io.File;

public class HashmapPractice {

	public static void main(String[] args)
	{
		HashMap<Integer, String> myMap = new HashMap<Integer, String>();
		Scanner sc = new Scanner(System.in);
		File file = new File("integervaluemap");
		Integer tempKey;
		String tempValue;

		try
		{
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				tempKey = input.nextInt();
				tempValue = input.next();
				input.nextLine();
				myMap.put(tempKey, tempValue);
			}
			input.close();
		}
		catch(IOException e)
		{
			System.out.println("Error reading from file");
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("File format does not match expected format.");
		}

		System.out.print("Enter a number: ");
		try
		{
			Integer key = sc.nextInt();
			sc.nextLine();
			if(myMap.containsKey(key))
			{
				System.out.println("You entered " + myMap.get(key) + ".");
			}
			else
			{
				System.out.print("Value not found. What is the name of that number?: ");
				String value = sc.nextLine();
				myMap.put(key, value);
			}
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Not an integer.");
		}

		try
		{
			PrintWriter pw = new PrintWriter(file);
			for(Map.Entry<Integer, String> entry: myMap.entrySet())
			{
				pw.println(entry.getKey() + "\t" + entry.getValue());
			}
			pw.flush();
			pw.close();
		}
		catch(IOException e)
		{
			System.out.println("Error writing to file.");
		}
		sc.close();
	}
}
