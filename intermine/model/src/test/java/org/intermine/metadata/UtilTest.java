package org.intermine.metadata;

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

public class UtilTest extends TestCase
{
    public UtilTest(String arg) {
        super(arg);
    }

    public void testEquals() {
        assertTrue(org.intermine.metadata.Util.equals(null, null));
        assertTrue(org.intermine.metadata.Util.equals(Integer.valueOf(10), new Integer(10)));
        assertTrue(org.intermine.metadata.Util.equals(Integer.valueOf(20), new Integer(10)) == false);
        assertTrue(org.intermine.metadata.Util.equals(null, Integer.valueOf(10)) == false);
        assertTrue(org.intermine.metadata.Util.equals(Integer.valueOf(10), null) == false);
    }

    public void testHashCode() {
        assertTrue(org.intermine.metadata.Util.hashCode(null) == 0);
        assertTrue(org.intermine.metadata.Util.hashCode(Integer.valueOf(10)) != 0);
    }



}
