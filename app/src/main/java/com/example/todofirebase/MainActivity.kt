package com.example.todofirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var itemlist = arrayListOf<String>()
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,itemlist)

        val add_btn = findViewById<Button>(R.id.add)
        val editText = findViewById<EditText>(R.id.editText)
        val delete = findViewById<Button>(R.id.delete)
        val clear = findViewById<Button>(R.id.clear)
//        val itemText = editText.text.toString()
        val listView = findViewById<ListView>(R.id.listView)

        // adding item
        add_btn.setOnClickListener(){
                if (editText.text.length <=0 ){
                    Toast.makeText(this,"Please enter a valid text",Toast.LENGTH_SHORT).show()

                }else {
                    itemlist.add(editText.text.toString())
                    listView.adapter = adapter
                    adapter.notifyDataSetChanged()

                    // clearing editText
                    editText.text.clear()
                }
        }

        // deleting item from the list.
        delete.setOnClickListener(){
            val position: SparseBooleanArray = listView.checkedItemPositions
            val count = listView.count
            var item = count -1

            while (item >= 0){
                if(position.get(item))
                {
                    adapter.remove(itemlist.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()
        }// delete end

        // clear item

        clear.setOnClickListener(){
            itemlist.clear()
            adapter.notifyDataSetChanged()
            Toast.makeText(this,"All Tasks cleared",Toast.LENGTH_SHORT).show()
        }

        // clear end

    }



}