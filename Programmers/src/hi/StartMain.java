package hi;

public class StartMain {
	public static void main(String[] args) {
		WithHash ws = new WithHash();
		String[] participant = new String[4];
		String[] completion = new String[3];

		completion[0] = "eden";
		completion[1] = "kiki";
		completion[2] = "josh";

        participant[0]="eden";
        participant[1]="kiki";
        participant[2]="josh";
        participant[3]="kim";

       System.out.println(ws.marathonSolution(participant, completion)); 
	}

}
