/**
 * 
 */
package microwaveOven.driver;

import java.io.FileNotFoundException;

import microwaveOven.service.MicrowaveContext;
import microwaveOven.service.MicrowaveStateI;
import microwaveOven.util.FileProcessor;
import microwaveOven.util.Results;

/**
 * @author Admin
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	static String outputString;
	static int i;
	static int ind;
	static int arr[] = new int[50];
	static String[] keycode = new String[100];
	static String sct[] = new String[3];
	static String fw[] = new String[3];
	static MicrowaveContext context;
	static MicrowaveStateI setTime;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				if (args.length == 2) {
					
					try {
						FileProcessor fp = new FileProcessor(args[0]);
						FileProcessor fileProcessor = new FileProcessor(args[0]);
						FileProcessor outFile = new FileProcessor(args[1]);
						Results res = new Results(outFile);
						context = new MicrowaveContext(res);
						if (!fp.isEmpty()) {

							outputString = fileProcessor.readLine();
							//System.out.println(outputString);
							//System.out.println("Output string has been printed");
							
							keycode = outputString.split("\n");
							for(i=0; i<fileProcessor.line_count; i++)
							{
								System.out.println("Instruction "+i+ ":"+keycode[i]);
								fw = keycode[i].split(" ");
								//System.out.println(fw[0]);
								if(fw[0].equals("setClockTime"))
								{
									//System.out.println("inside sct");
								    context.setTime(fw[1], fw[2]);		   
							        
							        context.setClock();
							        
								}
								if(fw[0].equals("start"))
								{
									//System.out.println("inside start");
									context.cookTime(fw[1], fw[2]);
									context.start();
								}
								if(fw[0].equals("cancel"))
								{
								    //System.out.println("inside cancel");
								    context.stop();
								}
							}
							
							
						}
						for (i = 0; i < res.count; i++) {
							String temp;
							temp = res.store[i];
							System.out.println(temp);
							res.writeToFile(temp);
						}
					} catch (IllegalArgumentException ex) {
						System.err.println("Invalid number of arguments.");
						ex.printStackTrace();
						System.exit(1);
					} catch (FileNotFoundException ex) {
						System.err.println("Input file not Found.");
						ex.printStackTrace();
						System.exit(1);
					} catch (ArrayIndexOutOfBoundsException ex) {
						System.err.println("Invalid debug value");
						ex.printStackTrace();
						System.exit(1);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						
					}
                    

			}else {
					System.out.println("Invalid number of arguments");
				 }

}
}
