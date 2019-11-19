package com.jgt.autotext.database;

import android.os.AsyncTask;

import java.util.List;

public class ItemRepository {
    private ItemDao itemDao;
    private static ItemRepository instance;

    private ItemRepository() {
        ItemDatabase db = ItemDatabase.getInstance();
        itemDao = db.itemDao();
    }

    public static ItemRepository getInstance() {
        if(null == instance) {
            synchronized (ItemRepository.class) {
                instance = new ItemRepository();
            }
        }
        return instance;
    }

    public void insertItem(Item item) {
        new InsertItemAsyncTask(itemDao, item).execute();
    }

    public List<Item> getItemList() {
        return itemDao.queryAll();
    }

    public void deleteItem(String itemName) {
        new DeleteItemAsyncTask(itemDao, itemName).execute();
    }

    class InsertItemAsyncTask extends AsyncTask<Void, Void, Void> {
        private Item item;
        private ItemDao itemDao;

        InsertItemAsyncTask(ItemDao itemDao, Item item) {
            this.itemDao = itemDao;
            this.item = item;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            itemDao.insertItem(item);
            return null;
        }
    }

    class DeleteItemAsyncTask extends AsyncTask<Void, Void, Void> {
        private String itemName;
        private ItemDao itemDao;

        DeleteItemAsyncTask(ItemDao itemDao, String itemName) {
            this.itemDao = itemDao;
            this.itemName = itemName;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            itemDao.deleteItem(itemName);
            return null;
        }
    }
}
