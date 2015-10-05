package infra.controller;

import android.content.Context;

import infra.dao.ManagerDAO;

/**
 * Created by theo on 15/09/15.
 */
public class ManagerController <T extends ManagerDAO>{

    Context context;
    T dao;

    public ManagerController(Context context, T newDao){

        this.context = context;
        dao = newDao;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public T getDao() {
        return dao;
    }

}
