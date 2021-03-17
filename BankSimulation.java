import java.util.Random;

public class BankSimulation {
	LinkedQueue q;
	private boolean isSetup = false;
	private int numMinutes;
	private int arrivalFrequency;
	private int transactionTime;
	private int numTellers;
	private int nextCustomerArrival;
	private int totalCustomers;
	private int maxWait;
	private int maxCustomersInQueue;
	private Random gen;
	private Teller[] tellers;
	
	private int nextCustomerArrival(int curTime) {
		int arrival = gen.nextInt(arrivalFrequency*2);
		
		return curTime + arrival;
	}
	
	public void setup() {
		numMinutes = 480;
		arrivalFrequency = 3;
		transactionTime = 7;
		numTellers = 3;
		gen = new Random(12);
		q = new LinkedQueue();
		totalCustomers = 0;
		isSetup = true;
		maxWait = 0;
		maxCustomersInQueue = 0;
		tellers = new Teller[numTellers];
		for (int i = 0; i < numTellers; i++) {
			tellers[i] = new Teller();
			tellers[i].setBusy(false);
		}
	}
	
	public void runSimulation() {
		if (!isSetup) {
			return;
		}
		// Set the first customer arrival
		nextCustomerArrival = nextCustomerArrival(0);
		
		// run the simulation for numMinutes minutes
		for (int minute = 0; minute < numMinutes; minute++) {
	
			// If a customer arrives add them to the queue
			if (minute == nextCustomerArrival) {
				// enqueue the customer.
				System.out.println("Customer arrival at : " + minute);
				q.add(minute);
				if (q.size() > maxCustomersInQueue) {
					maxCustomersInQueue = q.size();
				}
				// calculate the next arrival
				nextCustomerArrival = nextCustomerArrival(minute+1);
				totalCustomers++;
			}
			
			// If a teller completes a tranaction
			for (int i = 0; i < numTellers; i++) {
				if (tellers[i].getTimeFinished() == minute) {
					tellers[i].setBusy(false);
				}
			}
			
			// Assign a customer to a teller if available
			for (int i = 0; i < numTellers; i++) {
				if (!q.isEmpty()) {
					if (!tellers[i].isBusy()) {
						// Assign this teller
						Integer arrival = q.remove();
						if ((minute - arrival) > maxWait) {
							maxWait = minute - arrival;
						}
						tellers[i].setBusy(true);
						tellers[i].setTimeFinished(minute+transactionTime);
					}
				}
			}			
			
			
			
			
		}
		
		System.out.println("Total Customers          : " + totalCustomers);
		System.out.println("Customers left in queue  : " + q.size());
		System.out.println("Customer max wait time   : " + maxWait);
		System.out.println("Customer max queue depth : " + maxCustomersInQueue);
//		System.out.println(q);
		
		
		
		
	}

}
