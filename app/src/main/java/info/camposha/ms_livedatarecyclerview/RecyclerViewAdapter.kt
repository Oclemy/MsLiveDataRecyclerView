package info.camposha.ms_livedatarecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class RecyclerViewAdapter(context: Context?, userArrayList: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
    var context: Context? = context
    var users: ArrayList<User> = userArrayList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val rootView: View = LayoutInflater.from(context).inflate(R.layout.model, parent, false)
        return RecyclerViewViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users[position]
        val viewHolder = holder as RecyclerViewViewHolder
        viewHolder.nameTV.text = user.name
        viewHolder.descTV.text = user.description
        viewHolder.mImg.setImageResource(user.img)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    internal inner class RecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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