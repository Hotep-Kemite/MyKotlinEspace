package com.example.films

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: MyAdapter
    lateinit var lv: ListView
    var webService: WebService? = null
    lateinit var edtSearch: EditText
    lateinit var btnSearch: Button
    var name: String? = null
    lateinit var list: Call<ListFilms>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webService = WebService()
        lv = findViewById(R.id.listView)
        edtSearch = findViewById(R.id.edtSearch)
        btnSearch = findViewById(R.id.btnSearch)
        btnSearch.setOnClickListener(View.OnClickListener { //System.out.println("bb");
            name = edtSearch.getText().toString()
            if (name != "") {
                val list = webService!!.service.getTotalResults("fr", name)
                if (list != null) {
                    list.enqueue(object : Callback<ListFilms?> {
                        override fun onResponse(call: Call<ListFilms?>, response: Response<ListFilms?>) {
                            adapter = MyAdapter(this@MainActivity, response.body())
                            lv.setAdapter(adapter)
                        }

                        override fun onFailure(call: Call<ListFilms?>, t: Throwable) {
                            Log.i("List", t.message.toString())
                        }
                    })
                }
            } else {
                Toast.makeText(this@MainActivity, "Veuillez entrer un texte pour la recherche", Toast.LENGTH_SHORT).show()
            }
        })
        lv.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            val r = parent.getItemAtPosition(position) as Result
            println(r.title)
            val intent = Intent(this@MainActivity, DisplayFilm::class.java)
            intent.putExtra("filmItem", r)
            startActivity(intent)
        })
        val itemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_search -> Toast.makeText(this@MainActivity, "Veuillez entrer un texte pour la recherche", Toast.LENGTH_SHORT).show()
                R.id.action_favori -> println("Pérès Pérès Pérès Pérès Pérès Pérès Pérès Pérès Pérès Pérès Pérès Pérès Pérès")
                R.id.action_new -> println("Pérès Pérès Pérès Pérès Pérès Pérès Pérès Pérès Pérès Pérès Pérès Pérès Pérès")
            }
            true
        }
    }
}