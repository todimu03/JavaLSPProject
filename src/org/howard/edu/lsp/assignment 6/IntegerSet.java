package org.howard.edu.lsp.assignment6;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 

public class IntegerSet {
 
    
    private List<Integer> set = new ArrayList<>();
 
    
    public IntegerSet() {}
 
    
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }
 
    
    public void clear() {
        set.clear();
    }
 
    
    public int length() {
        return set.size();
    }
 
    
    public boolean equals(IntegerSet b) {
        if (this.length() != b.length()) return false;
        List<Integer> copyA = new ArrayList<>(set);
        List<Integer> copyB = new ArrayList<>(b.set);
        Collections.sort(copyA);
        Collections.sort(copyB);
        return copyA.equals(copyB);
    }
 
    
    public boolean contains(int value) {
        return set.contains(value);
    }
 
    
    public int largest() {
        if (isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.max(set);
    }
 
    
    public int smallest() {
        if (isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.min(set);
    }
 
    
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }
 
    
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }
 
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : set) result.add(val);
        for (int val : intSetb.set) result.add(val);
        return result;
    }
 
    
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : set) {
            if (intSetb.contains(val)) result.add(val);
        }
        return result;
    }
 
    
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : set) {
            if (!intSetb.contains(val)) result.add(val);
        }
        return result;
    }
 
    
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : intSetb.set) {
            if (!this.contains(val)) result.add(val);
        }
        return result;
    }
 
    
    public boolean isEmpty() {
        return set.isEmpty();
    }
 
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}