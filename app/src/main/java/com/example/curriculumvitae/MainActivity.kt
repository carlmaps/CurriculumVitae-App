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


}