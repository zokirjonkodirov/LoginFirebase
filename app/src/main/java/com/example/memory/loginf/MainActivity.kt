package com.example.memory.loginf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        Handler().postDelayed({
            if (user != null) {
                val dashboardIntent = Intent(this, DashboardActivity::class.java)
                startActivity(dashboardIntent)
                finish()
            } else {
                val signinIntent = Intent(this, SiginActivity::class.java)
                startActivity(signinIntent)
                finish()
            }
        }, 2000)
    }
}