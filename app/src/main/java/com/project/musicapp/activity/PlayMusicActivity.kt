package com.project.musicapp.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.project.musicapp.R
import com.project.musicapp.databinding.ActivityPlayMusicBinding
import java.util.Timer
import java.util.TimerTask

class PlayMusicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayMusicBinding
    private var pos = ""
    private var mediaPlayer: MediaPlayer? = null
    private var isUserSeeking = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pos = intent.getStringExtra("pos").toString()
        binding.songName.text = intent.getStringExtra("songName").toString()
        binding.artistName.text = intent.getStringExtra("artistName").toString()
        when (pos) {
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
        binding.suffleBtn.setOnClickListener {
            Snackbar.make(it, "Service not available", Snackbar.LENGTH_SHORT).show()
        }
        binding.timerBtn.setOnClickListener {
            Snackbar.make(it, "Service not available", Snackbar.LENGTH_SHORT).show()
        }
        binding.aboutBtn.setOnClickListener {
            Snackbar.make(it, "Service not available", Snackbar.LENGTH_SHORT).show()
        }
        binding.shareBtn.setOnClickListener {
            Snackbar.make(it, "Service not available", Snackbar.LENGTH_SHORT).show()
        }
        binding.originalLength.text = mediaPlayer?.duration?.let { setTimer(it) }
        binding.currentLength.text = mediaPlayer?.duration?.let { setTimer(it) }
        setProgressBar()
        mediaPlayer?.duration?.let { setForAndBackClick(it) }
    }

    private fun setTimer(duration: Int): String {
        var finalTimer = ""
        var secondTimer = ""

        // Convert total duration into time
        var hours = (duration).div(1000 * 60 * 60)
        var minutes = ((duration).rem(1000 * 60 * 60).div(1000 * 60))
        var seconds = ((duration).rem(1000 * 60 * 60).rem(1000 * 60).div(1000))

        // Add hours if there
        if (hours > 0) {
            finalTimer = hours.toString()
        }

        // 0 to seconds if it is one digit
        secondTimer = if (seconds < 10) {
            "0$seconds"
        } else {
            seconds.toString()
        }

        finalTimer = "$finalTimer$minutes:$secondTimer"
        return finalTimer
    }

    private fun setProgressBar() {
        binding.progressSeekBar.max = mediaPlayer?.duration as Int
        binding.progressSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2) {
                    isUserSeeking = true
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                isUserSeeking = true
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                isUserSeeking = false
                val newPosition = p0?.progress ?: 0
                mediaPlayer?.seekTo(newPosition)
            }
        })
        mediaPlayer?.start()
        setTimeAccordingSeekbar()
    }

    private fun setTimeAccordingSeekbar() {
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    try {
                        if (!isUserSeeking) {
                            binding.progressSeekBar.progress =
                                mediaPlayer?.currentPosition!!
                        }
                        binding.currentLength.text =
                            mediaPlayer?.duration?.let {
                                mediaPlayer?.currentPosition?.let { it1 ->
                                    calculateRemainingTime(
                                        it,
                                        it1
                                    )
                                }
                            }?.let {
                                setTimer(
                                    it
                                )
                            }
                    } catch (e: Exception) {

                    }
                }
            }
        }, 0, 1000)
    }

    private fun calculateRemainingTime(originalDur: Int, currentDur: Int): Int {
        return originalDur - currentDur
    }

    private fun setForAndBackClick(duration: Int) {
        binding.backwardBtn.setOnClickListener {
            val backward = 15000
            val newPosition = mediaPlayer?.currentPosition?.minus(backward)
            if (newPosition != null) {
                if (newPosition > 0) {
                    mediaPlayer?.seekTo(newPosition)
                    if (!isUserSeeking) {
                        binding.progressSeekBar.progress = newPosition
                    }
                } else {
                    mediaPlayer?.seekTo(0)
                    if (!isUserSeeking) {
                        binding.progressSeekBar.progress = 0
                    }
                }
            }
        }
        binding.forwardBtn.setOnClickListener {
            val forwardTime = 15000
            val newPosition = mediaPlayer?.currentPosition?.plus(forwardTime)
            if (newPosition != null) {
                if (newPosition < duration) {
                    mediaPlayer?.seekTo(newPosition)
                    if (!isUserSeeking) {
                        binding.progressSeekBar.progress = newPosition
                    }
                } else {
                    mediaPlayer?.seekTo(duration)
                    if (!isUserSeeking) {
                        binding.progressSeekBar.progress = duration
                    }
                }
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        super.onBackPressed()
    }

}