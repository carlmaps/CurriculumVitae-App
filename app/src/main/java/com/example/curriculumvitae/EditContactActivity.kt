package com.example.curriculumvitae

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_edit_about.*
import kotlinx.android.synthetic.main.activity_edit_contact.*
import kotlinx.android.synthetic.main.fragment_about_me.*

class EditContactActivity : AppCompatActivity() {

    lateinit var spf: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

        var filename = intent.getStringExtra("username")
        spf = getSharedPreferences(filename, Context.MODE_PRIVATE)

        val mobile = spf?.getString("phoneNum", "")
        val email = spf?.getString("username", "")
        val li = spf?.getString("linkedIn", "")
        val gh = spf?.getString("github", "")
        val med = spf?.getString("medium", "")

        etMobile.setText(mobile)
        etEmail.setText(email)
        etLinkedIn.setText(li)
        etGithub.setText(gh)
        etmedium.setText(med)

        btnSaveContact.setOnClickListener{
            filename = intent.getStringExtra("username")
            spf = getSharedPreferences(filename, Context.MODE_PRIVATE)
            val spe = spf.edit()

            spe.putString("phoneNum", etMobile.text.toString())
            spe.putString("username", etEmail.text.toString())
            spe.putString("linkedIn", etLinkedIn.text.toString())
            spe.putString("github", etGithub.text.toString())
            spe.putString("medium", etmedium.text.toString())

            spe.apply()

            Snackbar.make(it, "Successfully Saved", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        val fragIntent = Intent()
        setResult(RESULT_OK, fragIntent)
        finish()
    }
}