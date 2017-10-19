/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejercicio.author;

/**
 *
 * @author Fede2
 */
public class Author {
    
    public Author(){
        
    }
     public Author(String anId, String aName){
        this.id = anId;
        this.name = aName;
        
    }
    public String id;
    public String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name + '}';
    }
}
