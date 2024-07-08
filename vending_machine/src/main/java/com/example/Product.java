package com.example;

public class Product {
    private String name;
    private double price;

   Product(String name, double d) {
     this.name = name;
     this.price = d;
   }

   public String getProductName() {
     return this.name;
   }

   public double getProductPrice(){
    return this.price;
   }

}
