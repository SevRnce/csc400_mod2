import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Bag2<x> {
	private ArrayList<x> items;
	
	public Bag2() {
		items = new ArrayList<>();
		//define initial bag
	}
	
	public void add(x item) {
		items.add(item);
		//adding items
	}
	
	public boolean remove(x item) {
		return items.remove(item);
		//remove method
	}
	
	public boolean contains(x item) {
		return items.contains(item);
		//contains check method
	}
	
	public int count(x item) {
		int counts = 0;
		for (x currentItem : items) {
			if (currentItem.equals(item)) {
				counts++;
			}
		}
		return counts;
		//item count method
	}
	
	public void print() {
		System.out.println(items);
		//prints contents
	}
	
	public int size() {
		//returns bag size
		return items.size();
	}
	
	public void combine(Bag2<x> other){
		//combines 2 bags
		items.addAll(other.items);
	}
	
	public static <x> Bag2<x> distinct(Bag2<x> other) {
		//creates a new bag with no duplicates from another bag
        Set<x> noDupe = new HashSet<>();
        Bag2<x> noDupeBag = new Bag2<>();

        for (x element : other.items) {
            if (!noDupe.contains(element)) {
            	noDupeBag.add(element);
            	noDupe.add(element);
            }
        }
        return noDupeBag;
    }
	
	public static void main(String[] args) {
		Bag2<String> bag1 = new Bag2<>();
		Bag2<String> bag2 = new Bag2<>();
		bag1.add("a");
		bag1.add("b");
		bag1.add("c");
		bag1.add("b");
		
		bag2.add("d");
		bag2.add("e");
		bag2.add("f");
		bag2.add("d");

		bag1.print();
		System.out.println("Bag 1 contains " + bag1.size() + " items.");
		bag2.print();
		System.out.println("Bag 2 contains " + bag2.size() + " items.");
		System.out.println("Combining bags: ");
		bag1.combine(bag2);
		bag1.print();
		System.out.println("Bag's merged, bag 1 now contains " + bag1.size() + " items.");
		System.out.println("Removing duplicates: ");
		Bag2<String> noDupes = distinct(bag1);
		noDupes.print();
		System.out.println("The new bag contains " + noDupes.size() + " items.");
		//tests
	}
}