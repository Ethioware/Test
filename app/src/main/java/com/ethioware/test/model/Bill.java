package com.ethioware.test.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "BillTable")

public class Bill {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String CustomerName;
    private String ItemName;
    private int Amount;
    private int Price;
    private int Product;
    private int Total;

    public Bill() {

    }

    public Bill(@NotNull String customerName, @NotNull String itemName, int amount, int price, int product, int total) {


        CustomerName = customerName;
        ItemName = itemName;
        Amount = amount;
        Price = price;
        Product = product;
        Total = total;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getItemName() {
        return ItemName;
    }

    public int getAmount() {
        return Amount;
    }

    public int getPrice() {
        return Price;
    }

    public int getProduct() {
        return Product;
    }

    public int getTotal() {
        return Total;
    }
}
