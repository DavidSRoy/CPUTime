import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class CPUTimeMain {
	private static ArrayList<Integer> array = new ArrayList<>();
	private static LinkedList<Integer> linkedList = new LinkedList<>();
	private static BinarySearchTree tree = new BinarySearchTree();
	private final static double PROB_ADD = 0.1;
	private final static double PROB_REMOVE = 0.2;
	private final static double PROB_SEARCH = 0.7;
	
	private static double arrayTime = 0.0;
	private static double llTime = 0.0;
	private static double treeTime = 0.0;
	
	private static Random random = new Random();
	
	public static void main(String[] args) {

		ArrayList<Double> probs = new ArrayList<Double>();
		probs.add(PROB_ADD);
		probs.add(PROB_REMOVE);
		probs.add(PROB_SEARCH);
		Collections.sort(probs);
		
		for (int i = 0; i < 1e8; i++) {
			
			int num = random.nextInt(9);
			
			
			if (num <= probs.get(0)) {
				add();
			} else if (num <= probs.get(1)) {
				remove();
			} else if (num <= probs.get(2)) {
				search();
			}

		}	
		
		System.out.println("Array Time: " + arrayTime);
		System.out.println("LinkedList Time: " + llTime);
		System.out.println("BST Time: " + treeTime);
	}
	
	private static void add() {
		long start;
		long end;
		int value = random.nextInt((int) 1e9);
		start = System.currentTimeMillis();
		array.add(value);
		end = System.currentTimeMillis();
		arrayTime += getExeTime(start, end);
		
		start = System.currentTimeMillis();
		linkedList.add(value);
		end = System.currentTimeMillis();
		llTime += getExeTime(start, end);
		
		start = System.currentTimeMillis();
		tree.insert(value);
		end = System.currentTimeMillis();
		treeTime += getExeTime(start, end);

	}
	
	private static void remove() {
		long start;
		long end;
		int value = random.nextInt((int) 1e9);
		
		start = System.currentTimeMillis();
		array.remove(value);
		end = System.currentTimeMillis();
		arrayTime += getExeTime(start, end);
		
		start = System.currentTimeMillis();
		linkedList.remove(value);
		end = System.currentTimeMillis();
		llTime += getExeTime(start, end);
		
		start = System.currentTimeMillis();
		tree.delete(value);
		end = System.currentTimeMillis();
		treeTime += getExeTime(start, end);
	}
	
	private static void search() {
		long start;
		long end;
		int value = random.nextInt((int) 1e9);
		
		start = System.currentTimeMillis();
		array.get(value);
		end = System.currentTimeMillis();
		arrayTime += getExeTime(start, end);
		
	
		start = System.currentTimeMillis();
		linkedList.get(value);
		end = System.currentTimeMillis();
		llTime += getExeTime(start, end);
		
		start = System.currentTimeMillis();
		tree.search(value);
		end = System.currentTimeMillis();
		treeTime += getExeTime(start, end);
	}
	
	private static double getExeTime(long start, long end) {
		return (end - start)/ 1000.0;
	}

	
}
