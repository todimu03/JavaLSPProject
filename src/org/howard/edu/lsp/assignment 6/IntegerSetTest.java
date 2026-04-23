package org.howard.edu.lsp.assignment6;
 
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.*;
 

public class IntegerSetTest {
 

    @Test
    @DisplayName("Test clear() - normal case: non-empty set becomes empty")
    public void testClearNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();
        assertTrue(set.isEmpty(), "Set should be empty after clear()");
        assertEquals(0, set.length(), "Length should be 0 after clear()");
    }
 
    @Test
    @DisplayName("Test clear() - edge case: clearing already-empty set")
    public void testClearAlreadyEmpty() {
        IntegerSet set = new IntegerSet();
        set.clear(); // should not throw
        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }
 

    @Test
    @DisplayName("Test length() - normal case: set with multiple elements")
    public void testLengthNormal() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(20);
        set.add(30);
        assertEquals(3, set.length());
    }
 
    @Test
    @DisplayName("Test length() - edge case: empty set has length 0")
    public void testLengthEmpty() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length());
    }
 

    @Test
    @DisplayName("Test equals() - normal case: identical sets in same order")
    public void testEqualsNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(1); b.add(2); b.add(3);
        assertTrue(a.equals(b));
    }
 
    @Test
    @DisplayName("Test equals() - edge case: same elements in different order")
    public void testEqualsDifferentOrder() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(3); b.add(1); b.add(2);
        assertTrue(a.equals(b));
    }
 
    @Test
    @DisplayName("Test equals() - edge case: sets with different elements")
    public void testEqualsMismatch() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(1); b.add(2);
        assertFalse(a.equals(b));
    }
 

    @Test
    @DisplayName("Test contains() - normal case: value present in set")
    public void testContainsPresent() {
        IntegerSet set = new IntegerSet();
        set.add(5); set.add(10); set.add(15);
        assertTrue(set.contains(10));
    }
 
    @Test
    @DisplayName("Test contains() - edge case: value not present in set")
    public void testContainsAbsent() {
        IntegerSet set = new IntegerSet();
        set.add(5); set.add(10);
        assertFalse(set.contains(99));
    }
 

    @Test
    @DisplayName("Test largest() - normal case: set with multiple elements")
    public void testLargestNormal() {
        IntegerSet set = new IntegerSet();
        set.add(3); set.add(1); set.add(7); set.add(4);
        assertEquals(7, set.largest());
    }
 
    @Test
    @DisplayName("Test largest() - edge case: single element set")
    public void testLargestSingleElement() {
        IntegerSet set = new IntegerSet();
        set.add(42);
        assertEquals(42, set.largest());
    }
 
    @Test
    @DisplayName("Test largest() - edge case: throws exception on empty set")
    public void testLargestEmptySetThrows() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, set::largest);
    }
 

    @Test
    @DisplayName("Test smallest() - normal case: set with multiple elements")
    public void testSmallestNormal() {
        IntegerSet set = new IntegerSet();
        set.add(3); set.add(1); set.add(7); set.add(4);
        assertEquals(1, set.smallest());
    }
 
    @Test
    @DisplayName("Test smallest() - edge case: single element set")
    public void testSmallestSingleElement() {
        IntegerSet set = new IntegerSet();
        set.add(99);
        assertEquals(99, set.smallest());
    }
 
    @Test
    @DisplayName("Test smallest() - edge case: throws exception on empty set")
    public void testSmallestEmptySetThrows() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, set::smallest);
    }
 

    @Test
    @DisplayName("Test add() - normal case: adding new values increases length")
    public void testAddNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(3, set.length());
        assertTrue(set.contains(2));
    }
 
    @Test
    @DisplayName("Test add() - edge case: duplicate values are not added twice")
    public void testAddDuplicate() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(5); // duplicate
        assertEquals(1, set.length(), "Duplicate should not increase length");
    }
 

    @Test
    @DisplayName("Test remove() - normal case: existing value is removed")
    public void testRemoveNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(2); set.add(3);
        set.remove(2);
        assertFalse(set.contains(2));
        assertEquals(2, set.length());
    }
 
    @Test
    @DisplayName("Test remove() - edge case: removing a value not present does nothing")
    public void testRemoveNotPresent() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(2);
        set.remove(99); // should not throw
        assertEquals(2, set.length(), "Length should be unchanged");
    }
 
  
    @Test
    @DisplayName("Test union() - normal case: two overlapping sets")
    public void testUnionNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(2); b.add(3); b.add(4);
        IntegerSet result = a.union(b);
        assertEquals(4, result.length());
        assertTrue(result.contains(1));
        assertTrue(result.contains(4));
    }
 
    @Test
    @DisplayName("Test union() - edge case: union with empty set returns copy of original")
    public void testUnionWithEmpty() {
        IntegerSet a = new IntegerSet();
        IntegerSet empty = new IntegerSet();
        a.add(1); a.add(2);
        IntegerSet result = a.union(empty);
        assertEquals(2, result.length());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
    }
 
    @Test
    @DisplayName("Test intersect() - normal case: two overlapping sets")
    public void testIntersectNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(2); b.add(3); b.add(4);
        IntegerSet result = a.intersect(b);
        assertEquals(2, result.length());
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
    }
 
    @Test
    @DisplayName("Test intersect() - edge case: no common elements yields empty set")
    public void testIntersectNoCommon() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(3); b.add(4);
        IntegerSet result = a.intersect(b);
        assertTrue(result.isEmpty());
    }
 
    @Test
    @DisplayName("Test diff() - normal case: elements in a but not in b")
    public void testDiffNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(2); b.add(3); b.add(4);
        IntegerSet result = a.diff(b);
        assertEquals(1, result.length());
        assertTrue(result.contains(1));
    }
 
    @Test
    @DisplayName("Test diff() - edge case: identical sets yield empty diff")
    public void testDiffIdenticalSets() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(1); b.add(2); b.add(3);
        IntegerSet result = a.diff(b);
        assertTrue(result.isEmpty());
    }
 
    @Test
    @DisplayName("Test complement() - normal case: elements in b not in a")
    public void testComplementNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(2); b.add(3); b.add(4);
        IntegerSet result = a.complement(b);
        assertEquals(1, result.length());
        assertTrue(result.contains(4));
    }
 
    @Test
    @DisplayName("Test complement() - edge case: disjoint sets yield all elements of b")
    public void testComplementDisjoint() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(3); b.add(4);
        IntegerSet result = a.complement(b);
        assertEquals(2, result.length());
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
    }
 

    @Test
    @DisplayName("Test isEmpty() - edge case: newly created set is empty")
    public void testIsEmptyTrue() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
    }
 
    @Test
    @DisplayName("Test isEmpty() - normal case: non-empty set returns false")
    public void testIsEmptyFalse() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertFalse(set.isEmpty());
    }
 
    
    @Test
    @DisplayName("Test toString() - normal case: elements appear sorted with correct format")
    public void testToStringNormal() {
        IntegerSet set = new IntegerSet();
        set.add(3); set.add(1); set.add(2);
        assertEquals("[1, 2, 3]", set.toString());
    }
 
    @Test
    @DisplayName("Test toString() - edge case: empty set returns []")
    public void testToStringEmpty() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());
    }
}