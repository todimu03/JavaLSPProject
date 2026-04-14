package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class IntegerSetTest {

    private IntegerSet setA;
    private IntegerSet setB;

    @BeforeEach
    public void setUp() {
        setA = new IntegerSet();
        setB = new IntegerSet();
    }

    @Test
    @DisplayName("clear() – normal: removes all elements")
    public void testClearNormal() {
        setA.add(1);
        setA.add(2);
        setA.clear();
        assertTrue(setA.isEmpty(), "Set should be empty after clear()");
    }

    @Test
    @DisplayName("clear() – edge: clearing an already-empty set")
    public void testClearAlreadyEmpty() {
        setA.clear(); // should not throw
        assertTrue(setA.isEmpty());
        assertEquals(0, setA.length());
    }

    @Test
    @DisplayName("length() – normal: correct count after adds")
    public void testLengthNormal() {
        setA.add(10);
        setA.add(20);
        setA.add(30);
        assertEquals(3, setA.length());
    }

    @Test
    @DisplayName("length() – edge: empty set has length 0")
    public void testLengthEmpty() {
        assertEquals(0, setA.length());
    }

    @Test
    @DisplayName("equals() – normal: same elements same order")
    public void testEqualsNormal() {
        setA.add(1); setA.add(2); setA.add(3);
        setB.add(1); setB.add(2); setB.add(3);
        assertTrue(setA.equals(setB));
    }

    @Test
    @DisplayName("equals() – edge: same elements different order")
    public void testEqualsDifferentOrder() {
        setA.add(1); setA.add(2); setA.add(3);
        setB.add(3); setB.add(1); setB.add(2);
        assertTrue(setA.equals(setB), "Sets with same elements in different order should be equal");
    }

    @Test
    @DisplayName("equals() – edge: different elements returns false")
    public void testEqualsMismatch() {
        setA.add(1); setA.add(2);
        setB.add(1); setB.add(99);
        assertFalse(setA.equals(setB));
    }

    @Test
    @DisplayName("equals() – edge: different sizes returns false")
    public void testEqualsDifferentSize() {
        setA.add(1); setA.add(2);
        setB.add(1);
        assertFalse(setA.equals(setB));
    }

    @Test
    @DisplayName("contains() – normal: value present")
    public void testContainsPresent() {
        setA.add(5);
        assertTrue(setA.contains(5));
    }

    @Test
    @DisplayName("contains() – edge: value not present")
    public void testContainsAbsent() {
        setA.add(5);
        assertFalse(setA.contains(99), "Should return false for value not in set");
    }

    @Test
    @DisplayName("largest() – normal: returns max of multiple elements")
    public void testLargestNormal() throws IntegerSetException {
        setA.add(3); setA.add(7); setA.add(1);
        assertEquals(7, setA.largest());
    }

    @Test
    @DisplayName("largest() – edge: single element set")
    public void testLargestSingleElement() throws IntegerSetException {
        setA.add(42);
        assertEquals(42, setA.largest());
    }

    @Test
    @DisplayName("largest() – edge: empty set throws IntegerSetException")
    public void testLargestEmptyThrows() {
        assertThrows(IntegerSetException.class, () -> setA.largest());
    }


    @Test
    @DisplayName("smallest() – normal: returns min of multiple elements")
    public void testSmallestNormal() throws IntegerSetException {
        setA.add(3); setA.add(7); setA.add(1);
        assertEquals(1, setA.smallest());
    }

    @Test
    @DisplayName("smallest() – edge: single element set")
    public void testSmallestSingleElement() throws IntegerSetException {
        setA.add(-5);
        assertEquals(-5, setA.smallest());
    }

    @Test
    @DisplayName("smallest() – edge: empty set throws IntegerSetException")
    public void testSmallestEmptyThrows() {
        assertThrows(IntegerSetException.class, () -> setA.smallest());
    }

    @Test
    @DisplayName("add() – normal: adds a new element")
    public void testAddNormal() {
        setA.add(10);
        assertTrue(setA.contains(10));
        assertEquals(1, setA.length());
    }

    @Test
    @DisplayName("add() – edge: duplicate values are not added twice")
    public void testAddDuplicate() {
        setA.add(5);
        setA.add(5);
        assertEquals(1, setA.length(), "Duplicate should not increase length");
        assertTrue(setA.contains(5));
    }


    @Test
    @DisplayName("remove() – normal: removes an existing element")
    public void testRemoveNormal() {
        setA.add(1); setA.add(2); setA.add(3);
        setA.remove(2);
        assertFalse(setA.contains(2));
        assertEquals(2, setA.length());
    }

    @Test
    @DisplayName("remove() – edge: removing value not present does nothing")
    public void testRemoveNotPresent() {
        setA.add(1);
        setA.remove(99); // should not throw
        assertEquals(1, setA.length());
        assertTrue(setA.contains(1));
    }

    @Test
    @DisplayName("union() – normal: combines two non-empty sets")
    public void testUnionNormal() {
        setA.add(1); setA.add(2);
        setB.add(3); setB.add(4);
        setA.union(setB);
        assertTrue(setA.contains(1));
        assertTrue(setA.contains(2));
        assertTrue(setA.contains(3));
        assertTrue(setA.contains(4));
        assertEquals(4, setA.length());
    }

    @Test
    @DisplayName("union() – edge: union with empty set leaves set unchanged")
    public void testUnionWithEmpty() {
        setA.add(1); setA.add(2);
        setA.union(setB); // setB is empty
        assertEquals(2, setA.length());
        assertTrue(setA.contains(1));
        assertTrue(setA.contains(2));
    }

    @Test
    @DisplayName("union() – edge: no duplicates added on overlap")
    public void testUnionNoDuplicates() {
        setA.add(1); setA.add(2);
        setB.add(2); setB.add(3);
        setA.union(setB);
        assertEquals(3, setA.length());
    }

    @Test
    @DisplayName("intersect() – normal: keeps common elements")
    public void testIntersectNormal() {
        setA.add(1); setA.add(2); setA.add(3);
        setB.add(2); setB.add(3); setB.add(4);
        setA.intersect(setB);
        assertTrue(setA.contains(2));
        assertTrue(setA.contains(3));
        assertFalse(setA.contains(1));
        assertFalse(setA.contains(4));
        assertEquals(2, setA.length());
    }

    @Test
    @DisplayName("intersect() – edge: no common elements results in empty set")
    public void testIntersectNoCommon() {
        setA.add(1); setA.add(2);
        setB.add(3); setB.add(4);
        setA.intersect(setB);
        assertTrue(setA.isEmpty(), "Intersection of disjoint sets should be empty");
    }


    @Test
    @DisplayName("diff() – normal: removes elements in setB from setA")
    public void testDiffNormal() {
        setA.add(1); setA.add(2); setA.add(3);
        setB.add(2); setB.add(3);
        setA.diff(setB);
        assertTrue(setA.contains(1));
        assertFalse(setA.contains(2));
        assertFalse(setA.contains(3));
        assertEquals(1, setA.length());
    }

    @Test
    @DisplayName("diff() – edge: identical sets result in empty set")
    public void testDiffIdenticalSets() {
        setA.add(1); setA.add(2);
        setB.add(1); setB.add(2);
        setA.diff(setB);
        assertTrue(setA.isEmpty(), "Diff of identical sets should be empty");
    }

    @Test
    @DisplayName("complement() – normal: elements in setB not in setA")
    public void testComplementNormal() {
        setA.add(1); setA.add(2);
        setB.add(1); setB.add(2); setB.add(3); setB.add(4);
        setA.complement(setB);
        assertTrue(setA.contains(3));
        assertTrue(setA.contains(4));
        assertFalse(setA.contains(1));
        assertFalse(setA.contains(2));
    }

    @Test
    @DisplayName("complement() – edge: disjoint sets — all of setB becomes result")
    public void testComplementDisjoint() {
        setA.add(1); setA.add(2);
        setB.add(3); setB.add(4);
        setA.complement(setB);
        assertTrue(setA.contains(3));
        assertTrue(setA.contains(4));
        assertEquals(2, setA.length());
    }

    @Test
    @DisplayName("isEmpty() – edge: empty set returns true")
    public void testIsEmptyTrue() {
        assertTrue(setA.isEmpty());
    }

    @Test
    @DisplayName("isEmpty() – normal: non-empty set returns false")
    public void testIsEmptyFalse() {
        setA.add(1);
        assertFalse(setA.isEmpty());
    }

    
    @Test
    @DisplayName("toString() – normal: correct format for populated set")
    public void testToStringNormal() {
        setA.add(1); setA.add(2); setA.add(3);
        String result = setA.toString();
        assertEquals("[1, 2, 3]", result);
    }

    @Test
    @DisplayName("toString() – edge: empty set returns []")
    public void testToStringEmpty() {
        assertEquals("[]", setA.toString());
    }
}
