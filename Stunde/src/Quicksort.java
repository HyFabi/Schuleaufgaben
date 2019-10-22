public class Quicksort {
	int[] a = {1,7,3,9,8,2,5,4,6};
	
	public static void main(String[] args) {
		Quicksort q = new Quicksort();
		q.quicksort(0, q.a.length-1);
		for(int i = 0; i< q.a.length; i++){
			System.out.println(q.a[i]);
		}
		
	}
	
	public void quicksort(int anf, int ende) {
		if(anf < ende) {
			int p = pivot(anf, ende-1, ende);
			quicksort(anf, p-1);
			quicksort(p+1, ende);
			
		}
	}
	
	public int pivot(int i, int j, int pivot) {
		if(i < j) {
			if(a[i] < a[pivot]) {
				return pivot(i+1, j, pivot);
			}else if(a[j] > a[pivot]) {
				return pivot(i, j-1, pivot);
			}else {
				int x = a[i];
				a[i] = a[j];
				a[j] = x;
			}
		}else {
			if(a[pivot] < a[j]) {
				int x = a[pivot];
				a[pivot] = a[j];
				a[j] = x;
			}else {
				return pivot;
			}
		}
		return 0;
	}
}