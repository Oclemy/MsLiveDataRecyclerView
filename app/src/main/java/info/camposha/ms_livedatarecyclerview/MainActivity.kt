package info.camposha.ms_livedatarecyclerview

//Our imports
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import info.camposha.ms_livedatarecyclerview.databinding.ActivityMainBinding
import java.util.*

//Create Activity, then implement the LifecycleOwner interface
class MainActivity : AppCompatActivity(), LifecycleOwner {
    //Our instance properties
    var viewModel: MainViewModel? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewAdapter: RecyclerViewAdapter? = null
    //ViewBinding will generate us a class based on our layout name
    private lateinit var binding: ActivityMainBinding

    //Override oncreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflate our layout via Viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //set contentview
        setContentView(binding.root)
        //reference recylerview
        recyclerView = binding.rvMain

        //initialize our Viewmodel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //observe our users livedata
        viewModel?.userMutableLiveData?.observe(this, userListUpdateObserver)
    }
    //Users live data
    var userListUpdateObserver: Observer<ArrayList<User>?> =
        Observer<ArrayList<User>?> { userArrayList ->
            recyclerViewAdapter = RecyclerViewAdapter(this@MainActivity, userArrayList)
            recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView!!.adapter = recyclerViewAdapter
        }
}
//end