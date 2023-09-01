package com.example.somewordtranslation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class KelimelerCavab(
    @SerializedName("kelimeler")
    @Expose
     var list:List<kelimeler>,
     @SerializedName("success")
     @Expose
     var success:String

) {
}