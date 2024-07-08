package com.example;

public interface VendingMachineState {
    public void selectProduct(Product product);
    public void insertNote(Note note);
    public void insertCoin(Coin coin);
    public void dispenseProduct();
    public void returnChange();
    
}
