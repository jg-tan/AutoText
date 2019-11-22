package com.jgt.autotext.database.item;

import android.os.AsyncTask;

import com.jgt.autotext.database.DatabaseTaskListener;

import java.util.List;

public class ItemRepository {
    private static ItemRepository instance;
    private ItemDao itemDao;
    private List<Item> itemList;

    private ItemRepository() {
        ItemDatabase db = ItemDatabase.getInstance();
        itemDao = db.itemDao();
    }

    public static ItemRepository getInstance() {
        if (null == instance) {
            synchronized (ItemRepository.class) {
                instance = new ItemRepository();
            }
        }
        return instance;
    }

    public void insertItem(Item item, DatabaseTaskListener listener) {
        new InsertItemAsyncTask(item, itemDao, listener).execute();
    }

    public void populateItemList(DatabaseTaskListener listener) {
        new QueryItemAsyncTask(itemDao, listener).execute();
    }

    public void deleteItem(String itemName, DatabaseTaskListener listener) {
        new DeleteItemAsyncTask(itemName, itemDao, listener).execute();
    }

    public void deleteAll(DatabaseTaskListener listener) {
        new DeleteItemAsyncTask("", itemDao, listener).execute();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void addCount(String itemName, DatabaseTaskListener listener) {
        new AddItemCountAsyncTask(itemName, itemDao, listener).execute();
    }

    class InsertItemAsyncTask extends AsyncTask<Void, Void, Void> {
        private Item item;
        private ItemDao itemDao;
        private DatabaseTaskListener listener;

        public InsertItemAsyncTask(Item item, ItemDao itemDao, DatabaseTaskListener listener) {
            this.item = item;
            this.itemDao = itemDao;
            this.listener = listener;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            itemDao.insertItem(item);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            listener.onFinish();
            super.onPostExecute(aVoid);
        }
    }

    class AddItemCountAsyncTask extends AsyncTask<Void, Void, Void> {
        private String itemName;
        private ItemDao itemDao;
        private DatabaseTaskListener listener;

        public AddItemCountAsyncTask(String itemName, ItemDao itemDao, DatabaseTaskListener listener) {
            this.itemName = itemName;
            this.itemDao = itemDao;
            this.listener = listener;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            itemDao.addCount(itemName);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            listener.onFinish();
            super.onPostExecute(aVoid);
        }
    }

    class DeleteItemAsyncTask extends AsyncTask<Void, Void, Void> {
        private String itemName;
        private ItemDao itemDao;
        private DatabaseTaskListener listener;

        public DeleteItemAsyncTask(String itemName, ItemDao itemDao, DatabaseTaskListener listener) {
            this.itemName = itemName;
            this.itemDao = itemDao;
            this.listener = listener;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            if (itemName.isEmpty()) {
                itemDao.deleteAll();
                return null;
            }

            itemDao.deleteItem(itemName);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            listener.onFinish();
            super.onPostExecute(aVoid);
        }
    }

    class QueryItemAsyncTask extends AsyncTask<Void, Void, Void> {
        private ItemDao itemDao;
        private DatabaseTaskListener listener;

        public QueryItemAsyncTask(ItemDao itemDao, DatabaseTaskListener listener) {
            this.itemDao = itemDao;
            this.listener = listener;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            itemList = itemDao.queryAll();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            listener.onFinish();
            super.onPostExecute(aVoid);
        }
    }
}
