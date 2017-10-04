
package com.ejercicio.author;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;


@Stateless
@LocalBean
public class AuthorBean {

   public Author GetAuthor(){
       return new Author("232","El libro de la selva");
   }
}
