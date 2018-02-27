package com.radhika.salestaxproblem.model;

import java.io.Serializable;

/**
 *
 * @author rabhala
 */
public class InputFile implements Serializable {

    private static final long serialVersionUID = -8362360228986819881L;
    private String resourceLocation;
    
    public InputFile(String resourceLocation) {
        this.resourceLocation = resourceLocation;
    }
      
    public String getResourceLocation() {
        return resourceLocation;
    }

    public void setResourceLocation(String resourceLocation) {
        this.resourceLocation = resourceLocation;
    }   
    
}
