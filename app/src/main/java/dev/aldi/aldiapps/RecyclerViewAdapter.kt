package dev.aldi.aldiapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class RecyclerViewAdapter(data: List<DailyActivity>, view: Int, item1: Int, item2: Int, lifecycle: Lifecycle? = null): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val mData = data
    private val mView = view
    private var mItem1 = item1
    private var mItem2 = item2
    private var mLifecycle = lifecycle

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(mView, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder.dailyActivityText is TextView) {
            holder.dailyActivityText?.text = mData[position].name
        }

        if (holder.dailyActivityImg is ImageView) {
            holder.dailyActivityImg?.setImageResource(mData[position].imageId)
        }

        if(holder.dailyActivityText is YouTubePlayerView) {
            holder.cueVideo(mData[position].name)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dailyActivityText: Any? = view.findViewById(mItem1)
        val dailyActivityImg: Any? = view.findViewById(mItem2)
        lateinit var youtubePlayer: YouTubePlayer
        lateinit var currentVideoId: String

        init {
            if (dailyActivityText is YouTubePlayerView) {
                dailyActivityText.addYouTubePlayerListener(object: AbstractYouTubePlayerListener() {
                    override fun onReady(initializedYouTubePlayer: YouTubePlayer) {
                        youtubePlayer = initializedYouTubePlayer
                        youtubePlayer.cueVideo(currentVideoId, 0f)
                    }
                })
            }
        }

        fun cueVideo (videoId: String) {
            currentVideoId = videoId
            if (!this::youtubePlayer.isInitialized) return
            if (youtubePlayer == null) return

            youtubePlayer.cueVideo(videoId, 0f)
        }
    }
}