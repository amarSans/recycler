package com.tugasMobile.listmahasiswa

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout.JUSTIFICATION_MODE_INTER_WORD
import android.widget.ImageView
import android.widget.TextView

class DetailMahasiswa : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_mahasiswa)

        val receivedData = if (Build.VERSION.SDK_INT >= 33) {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Mahasiswa>("data")
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Mahasiswa>("data")
        }


        val tvImage: ImageView = findViewById(R.id.detailImageMahasiswa)
        val tvNama: TextView = findViewById(R.id.detailTextNamaMahasiswa)
        val tvNim: TextView = findViewById(R.id.detailTextNIM)
        val tvProdi: TextView = findViewById(R.id.detailTextProgramStudi)
        val tvinfo:TextView=findViewById(R.id.detailTextInfoTambahan)


        if (receivedData != null) {
            tvImage.setImageResource(receivedData.photo)
            tvNama.text ="Nama : "+receivedData.nama
            tvNim.text  ="Nim        : "+receivedData.nim
            tvProdi.text="Prodi      : "+receivedData.prodi
            tvinfo.text="informasi Tambahan:\n"+receivedData.info
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                tvinfo.justificationMode = JUSTIFICATION_MODE_INTER_WORD
            }
        }

    }
}