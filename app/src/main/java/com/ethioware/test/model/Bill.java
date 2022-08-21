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
    private int Time;


    public Bill() {

    }

    public Bill(@NotNull String customerName, @NotNull String itemName, int amount, int price, int product, int total, int Time) {

        CustomerName = customerName;
        ItemName = itemName;
        Amount = amount;
        Price = price;
        Product = product;
        Total = total;
        this.Time = Time;
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

    public int getTime() {
        return Time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setProduct(int product) {
        Product = product;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public void setTime(int time) {
        Time = time;
    }
}
