package com.ethioware.test.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.ethioware.test.data.BillDao;
import com.ethioware.test.model.Bill;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// All database stuff (connection with Dao, handling the info...) is done here!
// the annotation tells this is a DB class with an entity/table modeled/schema by 'Bill' class having version no of 1
@Database(entities = {Bill.class}, version=1,exportSchema = false)
public abstract class BillDB extends RoomDatabase {
    public static final int NUMBER_OF_THREADS = 4;

    // we need the Dao class inorder to access the 'Data' from our SQlite database
    public abstract BillDao billDao();

    // only a 'Single' instance/object of our database is needed
    private static volatile BillDB INSTANCE;
    // to run our DB in the background by allocating resources (Threads) of its own
    public static final ExecutorService DBExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    // Function to return our non null/empty Database
    public static BillDB billDB(final Context context) {
        // if our database instance is empty
        if (INSTANCE == null) {
            // pass instance of the database synchronically (securely) to be built
            synchronized (BillDB.class) {
                // if instance of the passed DB is empty
                if (INSTANCE == null) {
                    // Building the empty instance of our DB by providing (the context/ the scope of its function, the DB class, the name of DB)
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BillDB.class, "Bill_database").addCallback(sRoomDatabaseCallback).build();
                }
            }

        }
        // return our Non-null instance
        return INSTANCE;
    }
    // this method is called above as a callback to build and populate our database
    public static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // to populate the database in the background
            DBExecutor.execute(()->{
                // get the data from Dao
                BillDao billdao= INSTANCE.billDao();
                // clean slate when doing it initially
                billdao.deleteAll();
                // add some data manually
                Bill alex = new Bill("Alex","milik", 2,26,32,32, "2/12/2022","2:30");
                billdao.insert(alex);
                Bill alex2 = new Bill("Alex2","milik", 4,40,160,160, "2/12/2022","2:32");
                billdao.insert(alex2);

            });
        }
    };
}
