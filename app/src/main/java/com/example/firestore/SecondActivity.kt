package com.example.firestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firestore.databinding.ActivitySecondBinding
import com.google.firebase.auth.FirebaseAuth

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()
        binding. btOne.setOnClickListener({
            firebaseAuth.signOut()
            checkUser()
        })
        binding.btnFireStore.setOnClickListener {
            startActivity(Intent(this,ThirdActivity::class.java))
        }
    }
    private fun checkUser() {
        val firebaseUser= firebaseAuth.currentUser
        if(firebaseUser==null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        else{

            val email = firebaseUser.email
            binding.tViewTwo.setText(email)

        }
    }
}