package dev.aldi.aldiapps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DailyActivityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class DailyActivity(name: String, imageId: Int) {
    val name = name
    val imageId = imageId
}

class DailyActivityFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dailyActivityList = listOf(
            DailyActivity("Work", R.drawable.ic_baseline_work_24),
            DailyActivity("Gaming", R.drawable.ic_baseline_games_24),
            DailyActivity("Study", R.drawable.ic_baseline_menu_book_24)
        )

        val friendList = listOf(
            DailyActivity("Anggawan Ridho", R.drawable.ic_baseline_face_24),
            DailyActivity("Alvian", R.drawable.ic_baseline_face_24),
            DailyActivity("Hongki", R.drawable.ic_baseline_face_24)
        )

        val recyclerViewDailyActivity: RecyclerView = view.findViewById(R.id.rvDailyActivity)
        val recyclerViewDailyActivityAdapter = RecyclerViewAdapter(dailyActivityList, R.layout.daily_activity_recyclerview_row, R.id.daily_activity_text, R.id.daily_activity_img)
        recyclerViewDailyActivity.adapter = recyclerViewDailyActivityAdapter

        val recyclerViewFriend: RecyclerView = view.findViewById(R.id.rvFriend)
        val recyclerViewFriendAdapter = RecyclerViewAdapter(friendList, R.layout.daily_activity_recyclerview_row, R.id.daily_activity_text, R.id.daily_activity_img)
        recyclerViewFriend.adapter = recyclerViewFriendAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DailyActivityFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DailyActivityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}