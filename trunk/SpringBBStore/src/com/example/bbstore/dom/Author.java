package com.example.bbstore.dom;

import javax.persistence.Entity;



@Entity
public class Author extends BaseEntity {
    private String name;
    private String forname;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getForname() {
        return forname;
    }
    public void setForname(String forname) {
        this.forname = forname;
    }
    
    public String getFullName()
    {
    	return name+" "+forname;
    }
}
