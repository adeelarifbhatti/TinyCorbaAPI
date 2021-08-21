package Client;

import java.util.Scanner;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import GraphCore.GraphCoreTest;
import GraphCore.GraphCoreTestHelper;


public class Client {
	private static Scanner scan;
	public static void main (String[] args) {
		try {
			ORB orb = ORB.init(args,null);			
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			GraphCoreTest graphCoreTest = GraphCoreTestHelper.narrow(ncRef.resolve_str("GraphCore"));
			
			
			scan = new Scanner(System.in);
			String line = scan.nextLine();
			
			String str= line;
			String[] parts = str.split("[[ ]*|[//.]]");
			/*for(int i=0;i<parts.length-1;i++) {
			//System.out.print(parts[i]+" string testing "+parts.length);
			}*/
			String country = parts[1];
			
			if(parts[0].equals("set")) {
				String capital = parts[2];			
				String data=graphCoreTest.putValues(country,capital);
				if(!data.equals("Done")) {
					System.out.println("Something When Wrong");
					}
			}
			else if(parts[0].equals("get")) {
			
				String data2=graphCoreTest.getCapital(country);
				if(data2.equals("not found")) {
					System.out.println("error: not found");
				}
				else System.out.println(data2);
			}
			
			
		}
		catch(Exception e) {
			System.out.println("Client error "+e.getMessage());
			e.printStackTrace(System.out);			
		}
		
	}

}
