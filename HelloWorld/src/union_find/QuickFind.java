package union_find;

public class QuickFind {

	private int[] id;
	
	private QuickFind(int N) {
		id = new int[N];
		for(int i=0; i<N; i++) {
			id[i] = i;
		}
		
	}
	
	public void union(int p, int q) {
		System.out.println(String.format("p %s | q %s", p, q));
		for(int i=0; i<id.length; i++) {
			
			if(id[i] == p) {
				System.out.println(String.format("i : %d, id: %d", i, id[i]));
				id[i]= id[q];
			}
		}
		for(int i=0; i<id.length; i++) {
			System.out.println(String.format("Index : %d - Val : %d", i, id[i]));
		}
		
	}
	
	public static void main(String[] args) {
		QuickFind quickfind = new QuickFind(10);
		String inputs = args[0];
		String[] pairs = inputs.split("#");
		for(int i=0; i<pairs.length; i++) {
			String[] num = pairs[i].split(",");
		
			System.out.println(String.format("p %s | q %s", num[0], num[1]));
			int p =  Integer.parseInt(num[0]);
			int q =  Integer.parseInt(num[1]);
			quickfind.union(p, q);
		}

	}

}
