package info.camposha.ms_livedatarecyclerview

//Our imports
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

//Create viewModel class
class MainViewModel : ViewModel() {
    //Our instance properties
    var userMutableLiveData: MutableLiveData<ArrayList<User>?> = MutableLiveData()
    var userArrayList: ArrayList<User>? = null

    //Initialize stuff
    fun init() {
        populateList()
        userMutableLiveData.value = userArrayList
    }

    //generate dummy users
    fun populateList() {
        var user = User()
        user.name = "John Doe"
        user.description = "A very great guy"
        user.img=R.drawable.male_young_64
        userArrayList = ArrayList()
        userArrayList!!.add(user)
        user = User()
        user.name = "Jane Doe"
        user.description = "A very good girl"
        user.img=R.drawable.female_64
        userArrayList!!.add(user)
        user = User()
        user.name = "Kael Doe"
        user.description = "A very powerful guy"
        user.img=R.drawable.male_office_64
        userArrayList!!.add(user)
        user = User()
        user.name = "Teresa Doe"
        user.description = "A very beautiful girl"
        user.img=R.drawable.feamle_avatar_64
        userArrayList!!.add(user)
        user = User()
        user.name = "Ronnie Doe"
        user.description = "A very kind guy"
        user.img=R.drawable.male_grandma_64
        userArrayList!!.add(user)
        user = User()
        user.name = "Mary Doe"
        user.description = "A very helpful girl"
        user.img=R.drawable.female_afro_mp4
        userArrayList!!.add(user)
    }

    init {
        init()
    }
}
//end