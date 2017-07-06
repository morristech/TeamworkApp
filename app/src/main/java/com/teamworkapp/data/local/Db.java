package com.teamworkapp.data.local;

/**
 * @author Tosin Onikute.
 */

public class Db {

    public Db() { }

    public abstract static class TaskTable {

        public static final String TABLE_NAME = "hello_table";

        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_FIRST_NAME = "first_name";
        public static final String COLUMN_LAST_NAME = "last_name";

        public static final String CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_EMAIL + " TEXT PRIMARY KEY, " +
                        COLUMN_FIRST_NAME + " TEXT NOT NULL, " +
                        COLUMN_LAST_NAME + " TEXT NOT NULL, " +
                        " ); ";

        /*
        Set ContentValues and parse your Cursor methods below
         */

    }
}
