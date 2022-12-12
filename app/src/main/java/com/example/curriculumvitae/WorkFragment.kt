package com.example.curriculumvitae

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_work.*



class WorkFragment : Fragment() {

    var layoutManager: RecyclerView.LayoutManager? = null
    var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null

    private lateinit var experienceList: ArrayList<WorkExperience>
//    private var experienceList: ArrayList<WorkExperience> = arrayListOf(
//        WorkExperience( "Application Dev Lead","Bank of America","Nov 2021","present","Provided technical direction for the development team for the new DTS-Transact 2.0 Application"),
//        WorkExperience("Application Dev Lead", "Accenture", "Sep 2010", "Oct 2021", "Supervised end-to-end development lifecycle for State Farm client project."),
//        WorkExperience("Application Dev Lead", "NCR", "Sep 2010", "Oct 2021", "Supervised end-to-end development lifecycle for State Farm client project."),
//    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        experienceList = ArrayList()
        val bundle = arguments
        val tempExp = bundle?.getSerializable("workExp")
        if(tempExp != null){
            experienceList.add(tempExp as WorkExperience)
        }
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = WorkRecyclerAdapter(experienceList, context)
        }

        btnAddWork.setOnClickListener{
            val addWorkIntent = Intent(context, AddWorkActivity::class.java)
            Snackbar.make(view, "Add work button clicked", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            startActivityForResult(addWorkIntent, 1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 1){
            var tempData = data?.getSerializableExtra("work")
            if(tempData != null){
               experienceList.add(tempData as WorkExperience)
                rv.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = WorkRecyclerAdapter(experienceList, context)
                }
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