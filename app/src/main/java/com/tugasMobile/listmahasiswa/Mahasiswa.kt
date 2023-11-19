package com.tugasMobile.listmahasiswa

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
 data class Mahasiswa (
    val photo:Int,
    val nama:String,
    val nim:String,
    val prodi:String,
    val info:String
) : Parcelable