package com.ethioware.test.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ethioware.test.model.Bill;

import java.util.List;
@Dao
public interface BillDao {
    // must be implemented somewhere else
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Bill bill);
    @Query("DELETE FROM Billtable")
    void deleteAll();
    @Query("SELECT * FROM BillTable ORDER BY Time ASC")
    LiveData<List<Bill>> getAllBill();
}
