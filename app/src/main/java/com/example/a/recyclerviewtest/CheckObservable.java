package com.example.a.recyclerviewtest;


import android.database.Observable;

/**
 * Created by a on 2018/4/25.
 */

public class CheckObservable extends Observable<CheckObservable.Observer> {
    private static CheckObservable mInstance;

    private CheckObservable() {
    }

    public static CheckObservable getInstance() {
        if (mInstance == null) {
            synchronized (CheckObservable.class) {
                if (mInstance == null) {
                    mInstance = new CheckObservable();
                }
            }
        }
        return mInstance;
    }

    public void notifyChanged() {
        for (int i = 0; i < mObservers.size(); i++) {
            mObservers.get(i).changed();
        }
    }

    public interface Observer {
        void changed();
    }
}
