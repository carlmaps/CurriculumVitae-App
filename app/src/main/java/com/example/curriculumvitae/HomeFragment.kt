package com.example.curriculumvitae

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_curr_vitae.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_work.*
import kotlinx.android.synthetic.main.work_experience_list.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    lateinit var spf: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val filename = arguments?.getString("username")
        val spf = this.activity?.getSharedPreferences(filename, Context.MODE_PRIVATE)

        val name = spf?.getString("name", "")
        val role = spf?.getString("role", "")
        val summary = spf?.getString("summary", "")
        val profilepic = spf?.getString("profile", "")
        tvName.text = name
        tvCurrentRole.text = role
        tvsummary.text = summary

        if(profilepic != ""){
            profile.setImageResource(getDrawableIntByFileName(this.activity?.baseContext,profilepic))
        }

        btnEditHome.setOnClickListener{
            val editHomeIntent = Intent(context, EditHomeActivity::class.java)
            editHomeIntent.putExtra("username", filename)
            Snackbar.make(view, "Edit button clicked", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            startActivityForResult(editHomeIntent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 1){
            val filename = arguments?.getString("username")
            val spf = this.activity?.getSharedPreferences(filename, Context.MODE_PRIVATE)
            this.activity?.baseContext

            val name = spf?.getString("name", "")
            val role = spf?.getString("role", "")
            val summary = spf?.getString("summary", "")
            val profilepic = spf?.getString("profile", "")
            tvName.text = name
            tvCurrentRole.text = role
            tvsummary.text = summary
            profile.setImageResource(getDrawableIntByFileName(this.activity?.baseContext,profilepic))
        }
    }

    fun getDrawableIntByFileName(context: Context?, fileName: String?): Int {

        if (context != null) {
            return context.resources.getIdentifier(fileName, "drawable", context?.packageName)
        }
        return 0
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.mymenu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.actionLogout -> {
                Toast.makeText(context, "Logout option selected", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.actionSetting -> {
                Toast.makeText(context, "Setting option Selected", Toast.LENGTH_LONG).show()
                return true
            }


        }
        return super.onOptionsItemSelected(item)
    }

}
