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
		/*
		 * Create a list of operations and add the operations based on their
		 * probabilities, creating a sample.
		 */
		ArrayList<Operation> ops = new ArrayList<Operation>();
		for (int i = 0; i < PROB_ADD * 10; i++) {
			ops.add(Operation.ADD);
		}

		for (int i = 0; i < PROB_SEARCH * 10; i++) {
			ops.add(Operation.SEARCH);
		}

		for (int i = 0; i < PROB_REMOVE * 10; i++) {
			ops.add(Operation.REMOVE);
		}

		System.out.println(ops);
		for (int i = 0; i < 1; i++) {

			Operation op = ops.get(random.nextInt(ops.size()));

			switch (op) {
			case ADD:
				add();
				break;
			case REMOVE:
				remove();
				break;
			case SEARCH:
				search();
				break;
			}
		}

		System.out.println("Array Time: " + arrayTime);
		System.out.println("LinkedList Time: " + llTime);
		System.out.println("BST Time: " + treeTime);
	}

	private static void operation(int x) {

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
		return (end - start) / 1000.0;
	}

}

enum Operation {
	ADD, REMOVE, SEARCH
}
