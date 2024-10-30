package Algorithms1.Module2;

public class QuickFind {
	private int[] id;
	public QuickFind(int N) {
		// Initialize the array
		this.id = new int[N];
		for(int i = 0; i<N; i++){
			this.id[i] = i;
		}
	}
	public boolean isConnected(int p, int q){
		return this.id[p] == this.id[q];
	}
	public void union(int p, int q){
		int pid = this.id[p];
		int qid = this.id[q];
		for(int i = 0; i<this.id.length; i++){
			if(this.id[i] == pid){
				this.id[i] = qid;
			}
		}
	}

	public void print(){
		for(int i = 0; i<this.id.length; i++){
			System.out.print(i + "   ");
		}
		System.out.println();
		for(int i = 0; i<this.id.length; i++){
			System.out.print(this.id[i] + "   ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QuickFind quickFind = new QuickFind(10);
		quickFind.union(1,2);
		quickFind.union(8,2);
		quickFind.union(3,4);
		quickFind.union(6,5);
		quickFind.print();
		System.out.println("Is connected 8, 1: " + quickFind.isConnected(8,1));
		quickFind.union(1,9);
		System.out.println("Is connected 7, 1: " + quickFind.isConnected(7,1));
		quickFind.print();
	}
}
