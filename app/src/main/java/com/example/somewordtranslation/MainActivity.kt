package com.example.somewordtranslation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.somewordtranslation.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener {

private lateinit var  binding: ActivityMainBinding
lateinit var mylist: ArrayList<kelimeler>

lateinit var  kdi:KisilerDao
lateinit var  adapter:Reycelview
lateinit var  rw:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.toolbar.title="MyVocabulary"
        setSupportActionBar(binding.toolbar)
          kdi=ApiUtils.daomethods()
          rw=binding.recycelview
          rw.layoutManager=LinearLayoutManager(this)
          allword()








    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)


        val item=menu?.findItem(R.id.filter)
        val searchView=item?.actionView as SearchView

        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {

        searchoperations(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        searchoperations(newText)

        return true
    }


    fun allword(){


         kdi.allword().enqueue(object :Callback<KelimelerCavab>{
             override fun onResponse(call: Call<KelimelerCavab>?, response: Response<KelimelerCavab>?) {
                 if (response!=null){
                     var list=response.body().list
                     var message=response.body().success
                     var arrayList=list as ArrayList<kelimeler>
                     mylist= ArrayList()
                     mylist=arrayList

                     adapter= Reycelview(this@MainActivity,mylist)
                     rw.adapter=adapter

                 }

             }

             override fun onFailure(call: Call<KelimelerCavab>?, t: Throwable?) {

             }


         })

    }

    fun searchoperations(searchingcharacter:String){

        kdi.searchword(searchingcharacter).enqueue(object :Callback<KelimelerCavab>{
            override fun onResponse(call: Call<KelimelerCavab>?, response: Response<KelimelerCavab>?) {
                if (response!=null){
                    var list=response.body().list
                    adapter=Reycelview(this@MainActivity, list as ArrayList<kelimeler>)
                    rw.adapter=adapter


                }

            }

            override fun onFailure(call: Call<KelimelerCavab>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }
}