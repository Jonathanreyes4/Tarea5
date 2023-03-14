package com.example.vamos;

import android.provider.BaseColumns;

public final class TableContract {
    private TableContract() {}

    public static class TableEntry implements BaseColumns {
        public static final String TABLE_NAME = "table_list";
        public static final String COLUMN_NAME = "name";
    }
}

