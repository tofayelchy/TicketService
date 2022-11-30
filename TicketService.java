import java.util.Scanner;  // Import the Scanner class

public class TicketService {
	
	
static  String [] ticketType = {"1. Adult Only", "2. Adult and Child ", "3. Adult and Infant ", "4. Adult, Child and Infant"};   
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your name"); // asking a user to input name

		while (!sc.hasNext("[A-Za-z]*")) { // only letters are allowed
		    System.out.println("Please input valid name");
		    sc.next();
		}
		String name = sc.next();
		
		// id >0 , can be used auto increment
		
		int id;
		do {
			System.out.println("\"Welcome " + name+ ", please type your id" );
			
		    while (!sc.hasNextInt()) {
		        System.out.println("Please type a number greater than zero");
		        sc.next(); 
		    }
		    id = sc.nextInt();
		} while (id <= 0);
		System.out.println(name + ", your id is "+  id );
		
		
		// Asking a user how many ticket they need.
		int totalQ;
		System.out.println("How many tickets would you like to purchase?" );
		do {
			System.out.println("You can only buy at least 1 and maximum of 20 tickets" );
			
			
		    while (!sc.hasNextInt()) { //checking if it is number
		        System.out.println("Invalid input, please type a number");
		        sc.next(); 
		    }
		    totalQ = sc.nextInt();
		} while (totalQ < 1 || totalQ > 20);
		
		
		
        
        System.out.println("Select the ticket type you would like to purchase:");
        for (int i=0; i<ticketType.length; i++) {
        	System.out.println(ticketType[i]);
        }
        String choice = sc.next(); // string is immutable by default
        double adultCost =0;
        double childCost=0;
        double totalCost=0;
    	double adulTicketPrice =20 ;
    	double childTicketPrice =10;
    	int adultQ;
    	int childQ;
    	int infantQ;
        switch(choice)
        {
        
        // if a user choose only adult ticket the system calculate the total price
            case "1":
                {
                	
                    totalCost = (totalQ*adulTicketPrice);
                  
                    System.out.println("You are buying " + totalQ + " adult ticket/s and totl cost is " + totalCost);
                    
                    break;
                }
                
                // if a user choose to buy adult and child, the system asked user to choose how
                //many adult tickets they want and calculate the price
            case "2":
                {
                  
                    
                	
            		System.out.println("How many adult tickets would you like to purchase?" );
            		do {
            			System.out.println("You can not buy more than " + totalQ + " tickets" );
            			
            			
            		    while (!sc.hasNextInt()) {
            		        System.out.println("Invalid input, please type a number");
            		        sc.next(); 
            		    }
            		   adultQ = sc.nextInt();
            		} while (adultQ > totalQ);
                    
            		adultCost = (adultQ*adulTicketPrice);
                    System.out.println("Ticket cost of adult " + adultCost);
                    childQ =totalQ-adultQ;
                    childCost = childQ*childTicketPrice;
                  totalCost = adultCost + childCost;
                    System.out.println("You are buying " + childQ + " child tickets and cost " + childCost);
                    System.out.println("Total price " + totalCost);
                   
                    break;
                }
            case "3":
            {
                          	
        		System.out.println("How many adult tickets would you like to purchase?" );
        		do {
        			System.out.println("You can not buy more than " + totalQ + " tickets" );
        			
        	
        		    while (!sc.hasNextInt()) {
        		        System.out.println("Invalid input, please type a number");
        		        sc.next(); 
        		    }
        		   adultQ = sc.nextInt();
        		} while (adultQ > totalQ);
                
        		adultCost = (adultQ*adulTicketPrice);
                System.out.println("Ticket cost of adult " + adultCost);
                infantQ =totalQ-adultQ;
              totalCost = adultCost;
                System.out.println("You are buying " + infantQ + " infant tickets " );
                System.out.println("Total price " + totalCost);
                break;
            }
            case "4":
            {
              
                
            	
            	System.out.println("How many adult tickets would you like to purchase?" );
        		do {
        			System.out.println("You can not buy more than " + totalQ + " adult tickets" );
        			
        			
        		    while (!sc.hasNextInt()) {
        		        System.out.println("Invalid input, please type a number");
        		        sc.next();
        		    }
        		   adultQ = sc.nextInt();
        		} while (adultQ > totalQ);
                
        		adultCost = (adultQ*adulTicketPrice);
                System.out.println("Ticket cost of adult " + adultCost);
                System.out.println("how many child tickets would you like?");
                childQ =totalQ-adultQ; // I should use a separate variable for counting ticket quantities
                childCost = childQ*childTicketPrice;
              
              //  System.out.println("You are buying" + childQ + " child tickets and cost" + childCost);
                do {
        			System.out.println("You can not buy more than " + childQ + " child tickets" );
        			
        			
        			
        		    while (!sc.hasNextInt()) {
        		        System.out.println("Invalid input, please type a number");
        		        sc.next(); // this is important!
        		    }
        		   childQ = sc.nextInt();
        		} while (childQ >= totalQ);
                childCost = childQ*childTicketPrice;
                totalCost = adultCost + childCost;
                infantQ = totalQ - adultQ-childQ;
                System.out.println("You choose " + adultQ + " adult tickets, and " + childQ + " child tickets and " + infantQ + " infant tickets."   );
                System.out.println("Total price is " + totalCost );
                break;
            }
            default:
                System.out.println("Invalid Input");
        }
        
      
	    }
	}




