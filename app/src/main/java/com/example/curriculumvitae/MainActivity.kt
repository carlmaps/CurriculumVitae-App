package com.example.curriculumvitae

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    var primUser: User = User("Carl Michael", "Mapada", "cmmapada@gmail.com", "rockNroll!")
    lateinit var spfFileName: String
    lateinit var username: String

    lateinit var spf: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signInBtn.setOnClickListener{
            spfFileName = editEmailSignIN.text.toString()
            spf= getSharedPreferences(spfFileName, Context.MODE_PRIVATE)

            if(validateUser()){
                val cv = Intent(this, CurrVitaeActivity::class.java)
                username = editEmailSignIN.text.toString()
                cv.putExtra("username", username)
                startActivity(cv)
            }
            else{
                Snackbar.make(it, "Invalid username or password", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }

        signUpText.setOnClickListener{
            val regIntent = Intent(this, RegisterActivity::class.java)
            startActivity(regIntent)
        }
    }

//    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
//        outState.putString("username", username)
//        super.onSaveInstanceState(outState, outPersistentState)
//    }

    fun validateUser() : Boolean{
        val name = spf.getString("username", "")
        val pwd = spf.getString("pass", "")

        if((name.equals(editEmailSignIN.text.toString(), ignoreCase = true)) && (pwd.equals(editPassSignIn.text.toString()))){
            return true
        }

        return false
    }

//    fun initdummyData(primUser: User): User{
//        primUser.summary = R.string.intro.toString()
//
//        //initialize dummy skill data
//        var skills: ArrayList<Skills> = arrayListOf(
//            Skills("Microsoft.NET", 10),
//            Skills("Java", 10),
//            Skills("SpringBoot", 5),
//            Skills("Python", 5)
//        )
//
//        //initialize dummy skill data
//        var education: ArrayList<Education> = arrayListOf(
//            Education("Master of Science in Computer Science","Maharishi International University", "In progress via distance education; expected completion October 2023"),
//            Education("BS Electronics & Communications Engineering","University of San Carlos", "March 2001"),
//        )
//        //initialize dummy skill data
//        var certificate: ArrayList<Certificate> = arrayListOf(
//            Certificate("IT Service Management v2 Certification, ITIL Foundations"),
//            Certificate("Microsoft Exam 774: Performing Cloud Data Science using Azure Machine Learning"),
//            Certificate("Microsoft Exam 462: Administering Microsoft SQL Server 2012 / 2014 Databases"),
//            Certificate("Microsoft Exam 461: Querying Microsoft SQL Server 2012 / 2014 Databases")
//        )
//
//        var aboutInfo = AboutInfo()
//        aboutInfo.skills = skills
//        aboutInfo.education = education
//        aboutInfo.certificate = certificate
//
//        return primUser
//    }
}