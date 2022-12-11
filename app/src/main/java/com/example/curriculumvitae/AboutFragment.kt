package com.example.curriculumvitae

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_edit_about.*
import kotlinx.android.synthetic.main.fragment_about_me.*
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AboutMeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutMeFragment : Fragment() {

    lateinit var spf: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_me, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val filename = arguments?.getString("username")
        val spf = this.activity?.getSharedPreferences(filename, Context.MODE_PRIVATE)

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
        val maseterDeg = spf?.getString("masterDeg", "")

        textView3.text = aboutMe

        //skill1
        tvSkill1.text = skill1
        tvSkill2.text = skill2
        tvSkill3.text = skill3
        tvSkill5.text = skill4
        tvSkill5.text = skill5

        //progressbar
        if (skill1Level != null) {
            pb1.setProgress(skill1Level * 10)
        }
        pb1.max = 100

        if (skill2Level != null) {
            pb2.setProgress(skill2Level * 10)
        }
        pb2.max = 100

        if (skill3Level != null) {
            pb3.setProgress(skill3Level * 10)
        }
        pb3.max = 100

        if (skill4Level != null) {
            pb4.setProgress(skill4Level * 10)
        }
        pb4.max = 100

        if (skill5Level != null) {
            pb5.setProgress(skill5Level * 10)
        }
        pb5.max = 100

        //School
        tvCollege.text = collegeEd
        tvCollegeDeg.text = collegeDeg

        tvMaster.text = maseterEd
        tvMasterDeg.text = maseterDeg

        if(collegeEd != "") {
            val res = collegeEd?.split(" ")
            val firstCharList = res?.map { it.first().lowercase() }
            var collegelogo = ""
                firstCharList?.forEach { collegelogo = collegelogo + it}

            school1.setImageResource(getDrawableIntByFileName(this.activity?.baseContext,collegelogo))
        }

        if(maseterEd != "") {
            val res = maseterEd?.split(" ")
            val firstCharList = res?.map { it.first().lowercase() }
            var masterlogo = ""
            firstCharList?.forEach { masterlogo = masterlogo + it}

            school2.setImageResource(getDrawableIntByFileName(this.activity?.baseContext,masterlogo))
        }

        btnEditAbout.setOnClickListener{
            val editAboutIntent = Intent(context, EditAboutActivity::class.java)
            editAboutIntent.putExtra("username", filename)
            Snackbar.make(view, "Edit button clicked", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            startActivityForResult(editAboutIntent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 1){
            val filename = arguments?.getString("username")
            val spf = this.activity?.getSharedPreferences(filename, Context.MODE_PRIVATE)
            this.activity?.baseContext

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
            val maseterDeg = spf?.getString("masterDeg", "")

            textView3.text = aboutMe

            //skill1
            tvSkill1.text = skill1
            tvSkill2.text = skill2
            tvSkill3.text = skill3
            tvSkill5.text = skill4
            tvSkill5.text = skill5

            //progressbar
            if (skill1Level != null) {
                pb1.setProgress(skill1Level * 10)
            }
            pb1.max = 100

            if (skill2Level != null) {
                pb2.setProgress(skill2Level * 10)
            }
            pb2.max = 100

            if (skill3Level != null) {
                pb3.setProgress(skill3Level * 10)
            }
            pb3.max = 100

            if (skill4Level != null) {
                pb4.setProgress(skill4Level * 10)
            }
            pb4.max = 100

            if (skill5Level != null) {
                pb5.setProgress(skill5Level * 10)
            }
            pb5.max = 100

            //School
            tvCollege.text = collegeEd
            tvCollegeDeg.text = collegeDeg

            tvMaster.text = maseterEd
            tvMasterDeg.text = maseterDeg

            if(collegeEd != "") {
                val res = collegeEd?.split(" ")
                val firstCharList = res?.map { it.first().lowercase() }
                var collegelogo = ""
                firstCharList?.forEach { collegelogo = collegelogo + it}

                school1.setImageResource(getDrawableIntByFileName(this.activity?.baseContext,collegelogo))
            }

            if(maseterEd != "") {
                val res = maseterEd?.split(" ")
                val firstCharList = res?.map { it.first().lowercase() }
                var masterlogo = ""
                firstCharList?.forEach { masterlogo = masterlogo + it}

                school2.setImageResource(getDrawableIntByFileName(this.activity?.baseContext,masterlogo))
            }
        }
    }

    private fun getDrawableIntByFileName(context: Context?, fileName: String?): Int {

        if (context != null) {
            return context.resources.getIdentifier(fileName, "drawable", context?.packageName)
        }
        return 0
    }

    private fun parseLevel(level: String) : Int{
        if(level == "") {
            return 0
        }
        return level.toInt()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AboutMeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AboutMeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}