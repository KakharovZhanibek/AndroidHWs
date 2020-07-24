package com.example.androidhws.hw2

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.iterator
import com.example.androidhws.R


class ShoppingListActivity :AppCompatActivity(){

    var checkButton:Button?=null
    var checkListView: ListView?=null
    var productListView:ListView?=null

    var selectedList : ArrayList<String> = arrayListOf()

    var productList : ArrayList<String> = arrayListOf("Product 1",
        "Product 2","Product 3","Product 4",
        "Product 5","Product 6","Product 7",
        "Product 8","Product 9","Product 10",
        "Product 11","Product 12","Product 13",
        "Product 14","Product 15","Product 16")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)

        initializeViews()

        val productListViewAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, productList
        )
        productListView?.adapter=productListViewAdapter
        initializeListeners()

    }

    fun initializeViews(){
        checkListView=findViewById(R.id.listview_activity_shopping_list_check_list)
        productListView=findViewById(R.id.listview_activity_shopping_list_products_list)
        checkButton=findViewById(R.id.button_activity_shoppinglist_check_button)
    }

    fun initializeListeners(){


        productListView!!.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            val checkListViewAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_checked, selectedList
            )
            checkListView?.adapter=checkListViewAdapter
            //checkListViewAdapter.remove("")
            checkListViewAdapter.add(productList[position])
            checkListViewAdapter.notifyDataSetChanged()
        })

        checkListView!!.setOnItemClickListener(AdapterView.OnItemClickListener{parent,view,position,id->

            val v = view as CheckedTextView
            if(v.isChecked){
                v.isChecked=false
            }
            else{
                v.isChecked=true
            }
        })

        checkButton!!.setOnClickListener(View.OnClickListener {
            for(item in checkListView!!){
                var element:CheckedTextView=item as CheckedTextView
                if(element.isChecked==false){
                    item.setBackgroundResource(R.drawable.incorrectchoiceborder)
                }
                else{
                    item.setBackgroundResource(R.drawable.correctchoiceborder)
                }
            }
        })

    
    }
}