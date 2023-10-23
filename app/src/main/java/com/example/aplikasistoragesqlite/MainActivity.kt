package com.example.aplikasistoragesqlite

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.aplikasistoragesqlite.db.DBHelper

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputName: EditText = findViewById(R.id.inputName)
        val inputAge: EditText = findViewById(R.id.inputAge)
        val ibAddName: ImageButton = findViewById(R.id.ibAddName)
        val ibPrintName: ImageButton = findViewById(R.id.ibPrintName)
        val nama: TextView = findViewById(R.id.nama)
        val umur: TextView = findViewById(R.id.umur)

        ibAddName.setOnClickListener {
            val db = DBHelper(this,null)
            val name = inputName.text.toString()
            val umur = inputAge.text.toString()
//            Insert & Notif
            db.addName(name,umur)
            Toast.makeText(this, "Added to Database", Toast.LENGTH_LONG).show()
//            Clear input
            inputName.text.clear()
            inputAge.text.clear()
        }

//        Action untuk print nama
        ibPrintName.setOnClickListener {
            val db = DBHelper(this,null)
//            Gunakan cursor untuk menampilkan data
            val cursor = db.getName()
            if(cursor!!.moveToFirst()) {
                cursor.moveToFirst()
                nama.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COL))+"\n")
                umur.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL))+"\n")
            }
            if (cursor.moveToNext()) {
                nama.text=""
                umur.text=""

//                Looping untuk menunjukkan lebih dari 1 data
                while (cursor.moveToNext()) {
                    nama.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COL)) + "\n")
                    umur.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")
                }
            }
            cursor.close()
        }
    }
}