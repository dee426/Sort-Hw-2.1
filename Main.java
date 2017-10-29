package hw3;

import java.util.Scanner;

import org.apache.commons.cli.*;


public class Main implements Comparable{


	
	public static final String Type = "type";
	public static final String Key = "key";
	public static final String List = "list";

	
	public static void main(String[] args)
	{
		
		//Source source = new Source();
		CommandLineParser parser = new BasicParser();
		Options options = new Options();

		Option typeCase = new Option("t", Type, true, " “i” for integer and “s” for string ");
		Option keyIn = new Option("k", Key, true, " “i” for integer and “s” for string ");
		Option listIn = new Option("l", List, true, " “i” for integer and “s” for string ");
		listIn.setArgs(100);
		
		options.addOption(typeCase);
		options.addOption(keyIn);
		options.addOption(listIn);

		Scanner reader = new Scanner(System.in);
		try {
			CommandLine cmd = parser.parse(options, args);

				String inType = cmd.getOptionValue(Type);
				String inKey = cmd.getOptionValue(Key);
				String[] inList = cmd.getOptionValues(List);
				int[] numbList = new int[inList.length];
				
				System.out.println("Type Selected: " + inType);
				System.out.println("Key Selected: " + inKey);

				char typeConv = inType.charAt(0);
				for (int i =0; i< inList.length; i++)
				{
					System.out.println("List Selected: " + inList[i]);
				}
				
				if (typeConv == 'i')
				{
					System.out.println("In Integer....");
					for (int i =0; i< inList.length; i++)
					{
						System.out.println("List Selected: " + inList[i]);
						numbList[i] = Integer.parseInt(inList[i]);
					}
					
					for (int i =0; i< numbList.length; i++)
					{
						System.out.print(inList[i] + " ");
					}
					
					int newKey = Integer.parseInt(inKey);
					intFunction(numbList,  newKey);
					
				} 
				else{
					System.out.println("In String....");

					stringFunction(inList, inKey);

				}


		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		


	}
	
    static double[][] bList = new double[100][2];
    public static boolean binSearch(double input, int[] list, int size)
    {
        
         int low = 0;
         int high = size - 1;
          
         while(high >= low) {
             int middle = (low + high) / 2;
             if(list[middle] == input) {
                 System.out.println("Found " + input + " at index: " + list[middle]);
                 return true;
             }
             else if(list[middle] < input) {
                 low = middle + 1;
             }
             else if(list[middle] > input) {
                 high = middle - 1;
             }
        }
          return false;
    }
    
    public static <T extends Comparable<T>> boolean binSearchC(T key, T[] list, int size)
    {
        
         int low = 0;
         int high = size - 1;
          
         while(high >= low) {
             int middle = (low + high) / 2;
             int compare = key.compareTo(list[middle]);
				System.out.println(compare + " " + list[middle]);

             if(compare == 0) {
                 System.out.println("Found " + key + " at index: " + middle);
                 return true;
             }
             else if(compare > 0) {
                 low = middle + 1;
             }
             else if(compare < 0) {
                 high = middle - 1;
             }
        }
          return false;
    }
	
	
	public static void intFunction(int[] list, int key)
	{
		boolean isIn = binSearch( key, list, list.length);
		
		if (isIn){
			System.out.println("0");
		}else{	System.out.println("1");	}
		
	}
	
	public static void stringFunction(String[] list, String key)
	{
		System.out.println("....");

	     binSearchC(key, list, list.length);

		
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
