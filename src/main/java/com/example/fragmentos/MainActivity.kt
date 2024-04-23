package com.example.fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private var FragmentoActual : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val BtnFragmento2 = findViewById<Button>(R.id.aFragmento2)
        val BtnFragmento3 = findViewById<Button>(R.id.aFragmento3)

        if(savedInstanceState != null){
            if(savedInstanceState.getString("Fragmento") == "Fragmento1"){
                actualizarFragment(Fragmento1(), "Fragmento1")
            }
            else if(savedInstanceState.getString("Fragmento") == "Fragmento2"){
                actualizarFragment(Fragmento2(),"Fragmento2")
            }else{
                actualizarFragment(Fragmento3(), "Fragmento3")
            }

        }else{
            actualizarFragment(Fragmento1(), "Fragmento1")
        }


        //actualizarFragment(Fragmento1(), "Fragmento1")

        BtnFragmento2.setOnClickListener(){actualizarFragment(Fragmento2(),"Fragmento2")}
        BtnFragmento3.setOnClickListener(){actualizarFragment(Fragmento3(), "Fragmento3")}
    }

    fun actualizarFragment(Fragmento: Fragment, etiqueta:String){
        val manager = supportFragmentManager
        val transaction =  manager.beginTransaction()
        transaction.replace(R.id.Fragmentos, Fragmento)
        transaction.commit()
        FragmentoActual = etiqueta
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Fragmento", FragmentoActual)
    }

}