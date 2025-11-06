package org.intermine.util;

/*
 * Copyright (C) 2002-2022 FlyMine
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  See the LICENSE file for more
 * information or http://www.gnu.org/copyleft/lesser.html.
 *
 */

import junit.framework.TestCase;

public class CacheMapTest extends TestCase
{
    public CacheMapTest(String arg1) {
        super(arg1);
    }

    // Yeah, we can't test SoftReferences this way without properly mocking the entire CacheMap implementation so
    // we can control when objects are GC'd.  But don't do try and do this - INSTEAD REPLACE THE HOME-BAKED IMPLEMENTATION
    // HERE WITH SOMETHING BATTLE-TESTED IN AN EXTERNAL LIBRARY (QUITE POSSIBLY SOMETHING FROM THE JDK ITSELF)
//    public void test() throws Exception {
//        CacheMap cm = new CacheMap();
//        for (int i = 0; i < 300; i++) {
//            Integer iI = Integer.valueOf(i);
//            cm.put(iI, new byte[1048576]);
//        }
//
//        assertTrue(cm.size() < 1500);
//        assertTrue("Expected first two to be missing",!(cm.containsKey(Integer.valueOf(2)) && cm.containsKey(new Integer(1))));
//        assertTrue("Expected last two to be present", cm.containsKey(Integer.valueOf(298)) || cm.containsKey(new Integer(299)));
//    }

    public void test2() throws Exception {
        CacheMap cm = new CacheMap();

        cm.put(Integer.valueOf(5), new Integer(40));
        cm.put(Integer.valueOf(763), new Integer(67));
        cm.put(Integer.valueOf(2), null);

        assertEquals(Integer.valueOf(40), cm.get(new Integer(5)));
        assertEquals(Integer.valueOf(67), cm.get(new Integer(763)));
        assertNull(cm.get(Integer.valueOf(2)));
        assertTrue(cm.containsKey(Integer.valueOf(5)));
        assertTrue(cm.containsKey(Integer.valueOf(763)));
        assertTrue(cm.containsKey(Integer.valueOf(2)));

        assertNull(cm.remove(Integer.valueOf(3)));
        assertEquals(Integer.valueOf(40), cm.get(new Integer(5)));
        assertEquals(Integer.valueOf(67), cm.get(new Integer(763)));
        assertNull(cm.get(Integer.valueOf(2)));
        assertTrue(cm.containsKey(Integer.valueOf(5)));
        assertTrue(cm.containsKey(Integer.valueOf(763)));
        assertTrue(cm.containsKey(Integer.valueOf(2)));

        assertEquals(Integer.valueOf(40), cm.remove(new Integer(5)));
        assertNull(cm.get(Integer.valueOf(5)));
        assertEquals(Integer.valueOf(67), cm.get(new Integer(763)));
        assertNull(cm.get(Integer.valueOf(2)));
        assertFalse(cm.containsKey(Integer.valueOf(5)));
        assertTrue(cm.containsKey(Integer.valueOf(763)));
        assertTrue(cm.containsKey(Integer.valueOf(2)));

        assertEquals(Integer.valueOf(67), cm.remove(new Integer(763)));
        assertNull(cm.get(Integer.valueOf(5)));
        assertNull(cm.get(Integer.valueOf(763)));
        assertNull(cm.get(Integer.valueOf(2)));
        assertFalse(cm.containsKey(Integer.valueOf(5)));
        assertFalse(cm.containsKey(Integer.valueOf(763)));
        assertTrue(cm.containsKey(Integer.valueOf(2)));

        assertNull(cm.remove(Integer.valueOf(2)));
        assertNull(cm.get(Integer.valueOf(5)));
        assertNull(cm.get(Integer.valueOf(763)));
        assertNull(cm.get(Integer.valueOf(2)));
        assertFalse(cm.containsKey(Integer.valueOf(5)));
        assertFalse(cm.containsKey(Integer.valueOf(763)));
        assertFalse(cm.containsKey(Integer.valueOf(2)));
    }
}
