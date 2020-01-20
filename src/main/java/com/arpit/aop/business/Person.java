package com.arpit.aop.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String id;

    private String name;

    private int age;
}
