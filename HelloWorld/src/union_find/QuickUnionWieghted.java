package union_find;

import java.util.ArrayList;
import java.util.List;

public class QuickUnionWieghted {

	private int[] id;
	private int[] size;
	
	private QuickUnionWieghted(int N) {
		id = new int[N];
		size = new int[N];
		for(int i=0; i<N; i++) {
			id[i] = i;
			size[i] = 1;
			
		}		
	}
	
	private int getRoot(int index) {
		if(index != id[index]) {
			index = getRoot(id[index]);
		}	
		return index;
	}
	
	public void union(int p, int q) {
		int p_root = getRoot(p);
		int q_root = getRoot(q);

		
		if(size[p_root] >= size[q_root]) {
			id[q_root] = p_root;
			size[p_root] = size[p_root] +1;
			size[q_root] = size[p_root];
		}else {
			id[p_root] = q_root;
			size[q_root] = size[q_root] +1;
			size[p_root] = size[q_root];
		}
		
		for(int i=0; i<id.length; i++) {
			System.out.println(String.format("Index : %d - Val : %d", i, id[i]));
		}
	}
	
	
	public static void main(String[] args) {
		QuickUnionWieghted quickUnion = new QuickUnionWieghted(10);
		String inputs = args[0];
		String[] pairs = inputs.split("#");
		for(int i=0; i<pairs.length; i++) {
			String[] num = pairs[i].split(",");
		
			System.out.println(String.format("p %s | q %s", num[0], num[1]));
			int p =  Integer.parseInt(num[0]);
			int q =  Integer.parseInt(num[1]);
			quickUnion.union(p, q);
		}
		

	}

}
