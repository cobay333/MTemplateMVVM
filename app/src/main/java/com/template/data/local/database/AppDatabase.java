package com.template.data.local.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.template.data.local.database.dao.UserDao;
import com.template.data.model.db.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {


    public abstract UserDao userDao();
}