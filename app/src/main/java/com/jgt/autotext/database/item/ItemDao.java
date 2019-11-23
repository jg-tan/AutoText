package com.jgt.autotext.database.item;

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

    @Query("DELETE FROM item_table")
    void deleteAll();

    @Query("UPDATE item_table " +
            "SET item_count = item_count + 1 " +
            "WHERE item_name == :itemName")
    void addCount(String itemName);

    @Query("UPDATE item_table " +
            "SET item_number = :itemNumber, item_message = :itemMessage " +
            "WHERE item_name == :itemName")
    void updateItem(String itemName, String itemNumber, String itemMessage);
}
