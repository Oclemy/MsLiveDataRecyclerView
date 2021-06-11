package info.camposha.ms_livedatarecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import info.camposha.ms_livedatarecyclerview.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), LifecycleOwner {
    var viewModel: MainViewModel? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewAdapter: RecyclerViewAdapter? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.rvMain

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel?.userMutableLiveData?.observe(this, userListUpdateObserver)
    }

    var userListUpdateObserver: Observer<ArrayList<User>?> =
        Observer<ArrayList<User>?> { userArrayList ->
            recyclerViewAdapter = RecyclerViewAdapter(this@MainActivity, userArrayList)
            recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView!!.adapter = recyclerViewAdapter
        }
}