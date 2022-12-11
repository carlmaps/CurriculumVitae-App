package com.example.curriculumvitae

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_edit_about.*
import kotlinx.android.synthetic.main.activity_edit_home.*
import kotlinx.android.synthetic.main.fragment_about_me.*

class EditAboutActivity : AppCompatActivity() {

    lateinit var spf: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_about)

        var filename = intent.getStringExtra("username")
        spf = getSharedPreferences(filename, Context.MODE_PRIVATE)

        val aboutMe = spf?.getString("about", "")
        val skill1 = spf?.getString("skill1", "")
        val skill1Level = spf?.getInt("skLevel1", 0)
        val skill2 = spf?.getString("skill2", "")
        val skill2Level = spf?.getInt("skLevel2", 0)
        val skill3 = spf?.getString("skill3", "")
        val skill3Level = spf?.getInt("skLevel3", 0)
        val skill4 = spf?.getString("skill4", "")
        val skill4Level = spf?.getInt("skLevel4", 0)
        val skill5 = spf?.getString("skill5", "")
        val skill5Level = spf?.getInt("skLevel5", 0)

        val collegeEd = spf?.getString("college", "")
        val maseterEd = spf?.getString("master", "")

        val collegeDeg = spf?.getString("collegeDeg", "")
        val masterDeg = spf?.getString("masterDeg", "")

        etAbout.setText(aboutMe)

        //skill1
        etskill1.setText(skill1)
        etskillLevel1.setText(skill1Level.toString())

        //skill2
        etskill2.setText(skill2)
        etskillLevel2.setText(skill2Level.toString())

        //skill3
        etskill3.setText(skill3)
        etskillLevel3.setText(skill3Level.toString())

        //skill4
        etskill4.setText(skill4)
        etskillLevel4.setText(skill4Level.toString())

        //skill5
        etskill5.setText(skill5)
        etskillLevel5.setText(skill5Level.toString())

        etSchool1.setText(collegeEd)
        etSchool1Deg.setText(collegeDeg)

        etSchool2.setText(maseterEd)
        etSchool2Deg.setText(masterDeg)

        btnSaveAbout.setOnClickListener{
            filename = intent.getStringExtra("username")
            spf = getSharedPreferences(filename, Context.MODE_PRIVATE)
            val spe = spf.edit()

            spe.putString("about", etAbout.text.toString())
            spe.putString("skill1", etskill1.text.toString())
            spe.putInt("skLevel1", etskillLevel1.text.toString().toInt())

            spe.putString("skill2", etskill1.text.toString())
            spe.putInt("skLevel2", etskillLevel2.text.toString().toInt())

            spe.putString("skill3", etskill3.text.toString())
            spe.putInt("skLevel3", etskillLevel3.text.toString().toInt())

            spe.putString("skill4", etskill4.text.toString())
            spe.putInt("skLevel4", etskillLevel4.text.toString().toInt())

            spe.putString("skill5", etskill5.text.toString())
            spe.putInt("skLevel5", etskillLevel5.text.toString().toInt())

            spe.putString("college", etSchool1.text.toString())
            spe.putString("collegeDeg", etSchool1Deg.text.toString())

            spe.putString("master", etSchool2.text.toString())
            spe.putString("masterDeg", etSchool2Deg.text.toString())

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