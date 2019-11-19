package com.jgt.autotext.database;

import com.jgt.autotext.utils.AppContext;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Item.class, version = 1, exportSchema = false)
public abstract class ItemDatabase extends RoomDatabase {
    private static ItemDatabase instance;

    public static ItemDatabase getInstance() {
        if(null == instance) {
            synchronized (ItemDatabase.class) {
                instance = Room.databaseBuilder(AppContext.getContext(),
                        ItemDatabase.class, "item_database")
                        .build();
            }
        }
        return instance;
    }

    public abstract ItemDao itemDao();
}
