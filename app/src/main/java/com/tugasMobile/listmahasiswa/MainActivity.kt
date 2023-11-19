package com.tugasMobile.listmahasiswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvList: RecyclerView
    private val list=ArrayList<Mahasiswa>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvList=findViewById(R.id.rv_mahasiswa)
        rvList.setHasFixedSize(true)

        list.addAll(getListMember())
        showRecycleList()
    }
    private  fun getListMember():ArrayList<Mahasiswa>{
        val dataPhoto=resources.obtainTypedArray(R.array.data_photo)
        val dataName=resources.getStringArray(R.array.data_name)
        val dataNim=resources.getStringArray(R.array.data_nim)
        val dataProdi=resources.getStringArray(R.array.data_prodi)
        val DataTambahan=resources.getStringArray(R.array.data_informasiTambahan)
        val listMember=ArrayList<Mahasiswa>()
        for(i in dataName.indices){
            val member=Mahasiswa(dataPhoto.getResourceId(i,-1),dataName[i],dataNim[i],dataProdi[i],DataTambahan[i])
            listMember.add(member)
        }
        return listMember
    }
    private fun showRecycleList(){
        rvList.layoutManager= LinearLayoutManager(this)
        val listAdapter=ListAdapter(list)
        rvList.adapter=listAdapter
    }
}