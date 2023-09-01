package com.example.somewordtranslation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 data class kelimeler(@SerializedName("kelime_id")
               @Expose
               var kelimeid:Int,
                @SerializedName("ingilizce")
              @Expose
              var ingilisce:String,
                @SerializedName("turkce")
              @Expose
              var turkce:String

) {
}