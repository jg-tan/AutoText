package com.jgt.autotext.database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertItem(Item item);

    @Query("SELECT * FROM item_table")
    List<Item> queryAll();

    @Query("DELETE FROM item_table " +
            "WHERE item_name == :itemName")
    void deleteItem(String itemName);
}
