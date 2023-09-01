package com.example.somewordtranslation

class ApiUtils {

    companion object{
        val baseurl="http://kasimadalan.pe.hu/"

        fun daomethods():KisilerDao{

            return RetrofitClient.retrofitbuilder(baseurl).create(KisilerDao::class.java)
        }
    }
}