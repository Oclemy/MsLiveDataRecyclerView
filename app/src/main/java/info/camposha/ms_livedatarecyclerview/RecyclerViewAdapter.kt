package info.camposha.ms_livedatarecyclerview

//Our imports
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

//Create adapter by extending the recyclerview.adapter class
//We will receive a context and an arraylist of users
class RecyclerViewAdapter(context: Context?, userArrayList: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
        //declare instance fields
    var context: Context? = context
    var users: ArrayList<User> = userArrayList

    //Override onCreateViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //Inflate model layout
        val rootView: View = LayoutInflater.from(context).inflate(R.layout.model, parent, false)
        return RecyclerViewViewHolder(rootView)
    }

    //Override onBindViewholder
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //get current user
        val user = users[position]
        val viewHolder = holder as RecyclerViewViewHolder
        //set user details to views
        viewHolder.nameTV.text = user.name
        viewHolder.descTV.text = user.description
        viewHolder.mImg.setImageResource(user.img)
    }

    //number of items to be rendered in recyclerview
    override fun getItemCount(): Int {
        return users.size
    }

    //Create a viewholder class
    internal inner class RecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Views to be recycled
        var mImg: ImageView
        var nameTV: TextView
        var descTV: TextView

        init {
            mImg = itemView.findViewById(R.id.imgView_icon)
            nameTV = itemView.findViewById(R.id.txtView_title)
            descTV = itemView.findViewById(R.id.txtView_description)
        }
    }

}
//end