package com.example.myfirstactivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import android.widget.BaseAdapter

class MyFirstActivity: Activity() {
    lateinit var contador : TextView
    lateinit var btnContador : Button
    lateinit var myListView: ListView
    var i = 0;

    var arrayList : ArrayList<MyData> = ArrayList()
    var adapter : MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //En cada estado que ejecutemos, se tiene que poner este super obligatoriamente

        setContentView(R.layout.activity_my_first) //Enlaza nuestra vista (layout xml). R = recursos, layout = carpeta
        //btnContador = findViewById(R.id.btnContador)
        //contador = findViewById(R.id.contador)

        /**val arrayAdapter: ArrayAdapter<*>
        val games = arrayOf(
            "Mario", "Pacman", "Zelda", "Donkey Kong",
            "Sonic", "Crash"
        )


        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, games)
        myListView.adapter = arrayAdapter**/
        myListView = findViewById<ListView>(R.id.list_view)
        arrayList.add(MyData(1, "Sonic", 9.5f))
        arrayList.add(MyData(2, "Mario", 10.0f))
        arrayList.add(MyData(3, "Pacman", 7.8f))
        adapter = MyAdapter(this, arrayList)
        myListView.adapter = adapter



    }

    override fun onResume() {
        super.onResume()

        // TODO mandar mensaje
        //Toast.makeText(this, "Hola", Toast.LENGTH_LONG).show()
        /**val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.google.com/")
        startActivity(intent)**/

        //val intent = Intent(this, MySecondActivity::class.java)
        //startActivity(intent
        //btnContador.setOnClickListener { addNumber() }
    }

    fun addNumber(){
        i++;
        contador.setText(i.toString())
    }

}

class MyAdapter(private val context: Context, private val arrayList: java.util.ArrayList<MyData>): BaseAdapter() {
    lateinit var id : TextView
    lateinit var name : TextView
    lateinit var rating : TextView

    override fun getCount(): Int{
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        id = convertView.findViewById(R.id.id)
        name = convertView.findViewById(R.id.gameName)
        rating = convertView.findViewById(R.id.gameRating)

        id.text = " " + arrayList[position].id
        name.text = arrayList[position].name
        rating.text = " " + arrayList[position].rating
        return convertView
    }

}


class MyData(var id: Int, var name: String, var rating: Float)