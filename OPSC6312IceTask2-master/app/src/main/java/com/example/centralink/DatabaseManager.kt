package com.example.centralink

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log

object DatabaseManager {
    private const val TAG = "DatabaseManager"
    private const val DB_NAME = "UserDB"
    private const val TABLE_NAME = "users"
    private const val COL_ID = "id"
    private const val COL_NAME = "name"
    private const val COL_PASSWORD = "password"

    private fun getDatabase(context: Context): SQLiteDatabase {
        val db = context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null)
        db.execSQL("CREATE TABLE IF NOT EXISTS $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_NAME TEXT, $COL_PASSWORD TEXT)")
        return db
    }

    fun registerUser(context: Context, name: String, pass: String): Long {
        val db = getDatabase(context)
        val values = ContentValues().apply {
            put(COL_NAME, name)
            put(COL_PASSWORD, pass)
        }
        val id = db.insert(TABLE_NAME, null, values)
        db.close()
        return id
    }

    fun loginUser(context: Context, name: String, pass: String): Boolean {
        val db = getDatabase(context)
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COL_NAME=? AND $COL_PASSWORD=?", arrayOf(name, pass))
        val exists = cursor.count > 0
        cursor.close()
        db.close()
        return exists
    }

    fun getAllUsers(context: Context): List<String> {
        val db = getDatabase(context)
        val userList = mutableListOf<String>()
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        
        cursor.use { c ->
            val nameIndex = c.getColumnIndex(COL_NAME)
            if (nameIndex != -1) {
                while (c.moveToNext()) {
                    userList.add(c.getString(nameIndex))
                }
            }
        }
        db.close()
        return userList
    }

    fun manageUserData(context: Context) {
        val db = getDatabase(context)
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        cursor.use { c ->
            val idColumnIndex = c.getColumnIndex(COL_ID)
            val nameColumnIndex = c.getColumnIndex(COL_NAME)
            if (idColumnIndex != -1 && nameColumnIndex != -1) {
                while (c.moveToNext()) {
                    Log.d(TAG, "User ID: ${c.getInt(idColumnIndex)}, Name: ${c.getString(nameColumnIndex)}")
                }
            }
        }
        db.close()
    }
}
