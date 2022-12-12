package com.example.curriculumvitae

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_edit_contact.*
import kotlinx.android.synthetic.main.fragment_contact.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ContactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var spf: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val filename = arguments?.getString("username")
        val spf = this.activity?.getSharedPreferences(filename, Context.MODE_PRIVATE)

        val mobile = spf?.getString("phoneNum", "")
        val email = spf?.getString("username", "")
        val li = spf?.getString("linkedIn", "")
        val gh = spf?.getString("github", "")
        val med = spf?.getString("medium", "")

        tvCont.text = mobile
        tvEmail.text = email
        tvLinkedIn.text = li
        tvGit.text =  gh
        tvMedium.text= med

        imageCont.setOnClickListener{
           if(tvCont.text.toString() == ""){
               Snackbar.make(it, "Phone Number is empty", Snackbar.LENGTH_LONG)
                   .setAction("Action", null).show()
           }
           else {
               val dialIntent = Intent(Intent.ACTION_DIAL)
               dialIntent.data = Uri.parse("tel:" + tvCont.text.toString())
               startActivity(dialIntent)
           }
        }

        imageEmail.setOnClickListener{
            if(tvEmail.text.toString() == ""){
                Snackbar.make(it, "Email Address is empty", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
            else {
                val sendEmailIntent = Intent(Intent.ACTION_SEND)
                Uri.parse("mailto:" + tvEmail.text.toString()).also { sendEmailIntent.data = it }
                sendEmailIntent.type = "text/plain"
                startActivity(Intent.createChooser(sendEmailIntent, "Select your Email app"))
            }
        }

        imageLinkedIn.setOnClickListener{

            if(tvLinkedIn.text.toString() == ""){
                Snackbar.make(it, "URL Address is empty", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
            else {
                val url = tvLinkedIn.text.toString()
                val uri = Uri.parse(url)
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
        }

        imageGit.setOnClickListener{
            if(tvGit.text.toString() == ""){
                Snackbar.make(it, "URL Address is empty", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
            else {
                val url = tvGit.text.toString()
                val uri = Uri.parse(url)
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
        }

        imageMedium.setOnClickListener{
            if(tvMedium.text.toString() == ""){
                Snackbar.make(it, "URL Address is empty", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
            else {
                val url = tvMedium.text.toString()
                val uri = Uri.parse(url)
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
        }

        btnEditContact.setOnClickListener{
            val editcontactIntent = Intent(context, EditContactActivity::class.java)
            editcontactIntent.putExtra("username", filename)
            Snackbar.make(view, "Edit button clicked", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            startActivityForResult(editcontactIntent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            val filename = arguments?.getString("username")
            val spf = this.activity?.getSharedPreferences(filename, Context.MODE_PRIVATE)

            val mobile = spf?.getString("phoneNum", "")
            val email = spf?.getString("username", "")
            val li = spf?.getString("linkedIn", "")
            val gh = spf?.getString("github", "")
            val med = spf?.getString("medium", "")

            tvCont.text = mobile
            tvEmail.text = email
            tvLinkedIn.text = li
            tvGit.text =  gh
            tvMedium.text= med
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ContactFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContactFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
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