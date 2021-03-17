
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
//		me.doIt();
		me.bankSim();
	}
	
	private void doIt() {
		MyQueue q = new LinkedQueue();
		
		System.out.println(q);
		q.add(12);
		q.add(13);
		System.out.println(q);
		q.remove();
		//q.remove();
		System.out.println(q);
		q.add(12);
		q.add(12);
		q.add(12);
		q.add(12);
		q.add(12);
		q.remove();
		q.remove();
		q.remove();
		q.remove();
		System.out.println(q);
		
		for (int i = 0; i < 27; i++) {
			q.add(i);
		}
		
		System.out.println(q);
	}
	
	public void bankSim() {
		BankSimulation sim = new BankSimulation();
		sim.setup();
		sim.runSimulation();
		
	}

}
