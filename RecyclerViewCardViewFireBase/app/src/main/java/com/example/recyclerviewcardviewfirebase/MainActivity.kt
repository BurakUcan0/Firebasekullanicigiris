package com.example.recyclerviewcardviewfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.recyclerviewcardviewfirebase.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var database = FirebaseDatabase.getInstance().reference

        binding.buttonkaydet.setOnClickListener {

            var etadsoyad = binding.etadsoyad.text.toString().trim()
            var etyas = binding.etyas.text.toString().trim()
            var etbio = binding.etbio.text.toString().trim()



            if (TextUtils.isEmpty(etadsoyad)) {
                binding.etadsoyad.error = "Lütfen boş bırakmayınız"
            }
            if (TextUtils.isEmpty(etyas)) {
                binding.etyas.error = "Lütfen boş bırakmayınız"
            }
            if (TextUtils.isEmpty(etbio)) {
                binding.etbio.error = "Lütfen boş bırakmayınız"
            } else {
                var database = FirebaseDatabase.getInstance() // database bağlantısı kurduk
                var databaseReference = database.reference.child("Users")
                var id = databaseReference.push() // database rastgele bir id ataması yapıyor

                id.child("id").setValue(id.key.toString())
                id.child("adisoyadi").setValue(etadsoyad)
                id.child("yasi").setValue(etyas)
                id.child("biyografi").setValue(etbio)
                Toast.makeText(applicationContext, "Kayıt Başarılı", Toast.LENGTH_LONG).show()
            }


            }
        }


    }





