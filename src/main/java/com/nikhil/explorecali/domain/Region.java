package com.nikhil.explorecali.domain;

/**
 * Enumeration of the region of California.
 */
public enum Region {
    Central_Coast("Central Coast"), Southern_California("Southern California"), Northern_California("Northern California"), Varies("Varies");

    private String label;

    Region(String label) {
        this.label = label;
    }

    public static Region findByLabel(String label)
    {
        for(Region r: Region.values())
        {
            if(r.label.equalsIgnoreCase(label))
            {
                return r;
            }
        }
        return null;
    }
}
