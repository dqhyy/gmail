package com.example.gmail

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.StudentModel
import org.w3c.dom.Text

class StudentAdapter(val students: List<StudentModel>): BaseAdapter() {
    override fun getCount(): Int = students.size

    override fun getItem(position: Int): Any = students[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_item, parent, false)
            Log.v("TAG", "Create layout item $position")
            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = itemView.tag as ViewHolder
        }

        val student = students[position]
        val context = parent?.context
        context?.let {
            val resourceId = it.resources.getIdentifier("thumb1", "drawable", it.packageName)
            viewHolder.imageAvatar.setImageResource(resourceId)
        }
        viewHolder.textName.text = student.name
        viewHolder.textSubject.text = student.subject
        viewHolder.textBody.text = student.body
        viewHolder.textTime.text = student.time
        //viewHolder.checkSelected.isChecked = student.selected

//        viewHolder.checkSelected.setOnClickListener {
//            student.selected = viewHolder.checkSelected.isChecked
//            notifyDataSetChanged()
//        }

        return itemView
    }

    class ViewHolder(itemView: View) {
        val imageAvatar: ImageView
        val textName: TextView
        val textSubject: TextView
        val textBody: TextView
        val textTime: TextView
        init {
            imageAvatar = itemView.findViewById(R.id.image_avatar)
            textName = itemView.findViewById(R.id.name_tv)
            textSubject = itemView.findViewById(R.id.subject_tv)
            textBody = itemView.findViewById(R.id.body_tv)
            textTime = itemView.findViewById(R.id.time_tv)
        }
    }
}