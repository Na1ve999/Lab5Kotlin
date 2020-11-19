package com.example.lab5kotlin

import android.app.AlertDialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.button)
        btn.setOnClickListener {
            val dialog = AlertDialog.Builder(this).setTitle("請選擇功能").setMessage("請根據下方按鈕選擇要顯示的動作")

            dialog.setNeutralButton("取消") {
                dialogInterface, i ->
                Toast.makeText(this, "dialog關閉", Toast.LENGTH_SHORT).show()
            }
            dialog.setNegativeButton("自定義Toast") {
                dialogInterface, i ->
                showToast()
            }
            dialog.setPositiveButton("顯示List") {
                dialogInterface, i ->
                showListDialog()
            }
            dialog.show()
        }
    }

    private fun showToast() {
        val toast = Toast(this)
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_root))
        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf("message1", "message2", "message3", "message4", "message5")
        val dialog_list: AlertDialog.Builder = AlertDialog.Builder(this).setTitle("使用LTST呈現").setItems(list) {
            dialogInterface, i ->
            Toast.makeText(this, "你選的是" + list[i], Toast.LENGTH_SHORT).show()
        }
        dialog_list.show()
    }
}