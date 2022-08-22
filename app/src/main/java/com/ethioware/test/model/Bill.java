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
    private String Time;
    private String Date;

    public Bill(@NotNull String customerName, @NotNull String itemName, int amount, int price, int product, int total, String Time, String Date) {

        CustomerName = customerName;
        ItemName = itemName;
        Amount = amount;
        Price = price;
        Product = product;
        Total = total;
        this.Time = Time;
        this.Date = Date;
    }

    public Bill() {

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

    public void setTime(String time) {
        Time = time;
    }

    public String getTime() {
        return Time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
