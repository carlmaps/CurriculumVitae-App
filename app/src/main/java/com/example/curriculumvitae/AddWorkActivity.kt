package com.example.curriculumvitae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add_work.*

class AddWorkActivity : AppCompatActivity() {
    lateinit var wList: ArrayList<WorkExperience>
    lateinit var jobRole:String
    lateinit var company:String
    lateinit var startDt:String
    lateinit var endDt:String
    lateinit var workDesc:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_work)

        // Declaring fragment manager from making data
        // transactions using the custom fragment
//        val wFragmentManager =  supportFragmentManager
//        val wFragmentTransaction = wFragmentManager.beginTransaction()
//        val wFragment = WorkFragment()
//        val temp = intent.getSerializableExtra("worklist")
//
//        if(temp != null){
//            wList = temp as ArrayList<WorkExperience>
//        }

        // On button click, a bundle is initialized and the
        // text from the EditText is passed in the custom
        // fragment using this bundle
        addWorkBtn.setOnClickListener {
//            val mBundle = Bundle()
            jobRole = etJobRole.text.toString()
            company = etCompNm.text.toString()
            startDt = etStartDt.text.toString()
            endDt = etEndDt.text.toString()
            workDesc = etWorkDesc.text.toString()


//            val workExperience = WorkExperience(jobRole, company, startDt, endDt, workDesc)
//            mBundle.putSerializable("workExp",workExperience)
//            wFragment.arguments = mBundle
//            wFragmentTransaction.replace(R.id.wrk_frame_layout, wFragment).addToBackStack( null ).commit()
            Snackbar.make(it, "Work Experience Added", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        val workExperience = WorkExperience(jobRole, company, startDt, endDt, workDesc)
        val fragIntent = Intent()
        fragIntent.putExtra("work", workExperience)
        setResult(RESULT_OK, fragIntent)
        finish()
    }
}