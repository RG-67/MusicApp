package com.project.musicapp.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.window.OnBackInvokedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.project.musicapp.R
import com.project.musicapp.adapter.otherAdapter.MusicListAdapter
import com.project.musicapp.databinding.ActivityPlayMusicBinding
import com.project.musicapp.model.otherModel.MusicItemModel

class PlayMusicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayMusicBinding
    private var pos = ""
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pos = intent.getStringExtra("pos").toString()
        binding.songName.text = intent.getStringExtra("songName").toString()
        binding.artistName.text = intent.getStringExtra("artistName").toString()
        when(pos) {
            "0" -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.the_nights)
            }
            "1" -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.sweet_dreams)
            }
            "2" -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.calm_down)
            }
            "3" -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.habibi)
            }
            "4" -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.believer)
            }
        }
        mediaPlayer?.start()
        binding.playPauseBtn.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                binding.playImg.setImageResource(R.drawable.pause)
                mediaPlayer?.pause()
            } else {
                binding.playImg.setImageResource(R.drawable.music_play)
                mediaPlayer?.start()
            }
        }
        binding.hideBtn.setOnClickListener {
            onBackPressed()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        super.onBackPressed()
    }

}