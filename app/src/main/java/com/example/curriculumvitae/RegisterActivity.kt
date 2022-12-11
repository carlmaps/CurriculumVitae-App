package com.example.curriculumvitae

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        signInText.setOnClickListener{
            val signIntent = Intent(this, MainActivity::class.java)
            startActivity(signIntent)
        }
    }

    fun signup(view: View){
        val spf = getSharedPreferences(editEmailSignUp.text.toString(), Context.MODE_PRIVATE)
        val spe = spf.edit()

        spe.putString("name", editNameSignUp.text.toString())
        spe.putString("pass", editPassSignUp.text.toString())
        spe.putString("username", editEmailSignUp.text.toString())
        spe.putString("phoneNum", editNumberSignUp.text.toString())
        spe.commit()

        Snackbar.make(view, "Successfully Registered", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
        finish()
    }
}