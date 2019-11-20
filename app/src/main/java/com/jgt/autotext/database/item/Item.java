package com.jgt.autotext.database.item;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item_table")
public class Item {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "item_name")
    private String itemName;
    @ColumnInfo(name = "item_number")
    private String itemNumber;
    @ColumnInfo(name = "item_message")
    private String itemMessage;
    @ColumnInfo(name = "item_count")
    private int itemCount;

    public Item(@NonNull String itemName, String itemNumber, String itemMessage) {
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.itemMessage = itemMessage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemMessage() {
        return itemMessage;
    }

    public void setItemMessage(String itemMessage) {
        this.itemMessage = itemMessage;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
}
