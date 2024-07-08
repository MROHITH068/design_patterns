package com.example;

public class VendingMachine {
    private static  VendingMachine instance;
    Inventory inventory;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;
    private VendingMachineState currentState;
    private double payment = 0.0;
    private Product selectedProduct;

    private VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
        selectedProduct = null;
        payment = 0.0;
    }

    public static synchronized VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }

    public void setState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    Product getSelectedProduct() {
        return selectedProduct;
    }

    double getPayment() {
        return payment;
    }

    VendingMachineState getIdleState() {
        return idleState;
    }

    VendingMachineState getReadyState() {
        return readyState;
    }

    VendingMachineState getDispenseState() {
        return dispenseState;
    }

    VendingMachineState getReturnChangeState() {
        return returnChangeState;
    }

    void setSelectedProduct (Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    void resetSelectedProduct() {
        this.selectedProduct = null;
    }
    
    double getTotalPayment() {
        return payment;
    }

    void addCoin(Coin coin) {
        payment += coin.getValue();
    }

    void addNote(Note note) {
        payment += note.getValue();
    }
    void resetPayment() {
        payment = 0.0;
    }
}
