package com.template.data.local.database;

import com.template.data.model.db.User;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {
    Observable<List<User>> getAllUsers();
}