package com.ethioware.test.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.ethioware.test.model.Bill;
import com.ethioware.test.util.BillDB;

import java.util.List;

// this is a place to access clean data from our Dao
public class BillRepo {
    private BillDao dao;
    private LiveData<List<Bill>> allBill;

    public BillRepo(Application application) {
        // getting instance of our database class (abstraction)
        BillDB database = BillDB.billDB(application);
        // getting instance of our Dao through instance of our database class (higher abstraction)
        dao = database.billDao();
        // finally, all data in our dao will be delivered cleanly to our repo, then be accessed when needed. :)
        allBill = dao.getAllBill();
    }
        // a method to get ALL our data (from all the abstractions prior)
    public LiveData<List<Bill>> getAllBill(){return allBill;}
    public void insert(Bill bill){
        // to insert the data in the background without polluting the main/ui thread
        BillDB.DBExecutor.execute(()-> dao.insert(bill));
    }
}
