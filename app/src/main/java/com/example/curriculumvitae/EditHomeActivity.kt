package com.example.curriculumvitae

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_edit_home.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.fragment_home.*

class EditHomeActivity : AppCompatActivity() {

    lateinit var spf: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_home)

        val filename = intent.getStringExtra("username")
        val spf = getSharedPreferences(filename, Context.MODE_PRIVATE)

        val role = spf?.getString("role", "")
        val summary = spf?.getString("summary", "")
        val profilepic = spf?.getString("profile", "")

        etJobRole.setText(role)
        etprofile.setText(profilepic)
        etSummary.setText(summary)

        btnSaveHome.setOnClickListener{
            val filename = intent.getStringExtra("username")
            val spf = getSharedPreferences(filename, Context.MODE_PRIVATE)
            val spe = spf.edit()
            spe.putString("role", etJobRole.text.toString())
            spe.putString("profile", etprofile.text.toString())
            spe.putString("summary", etSummary.text.toString())
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