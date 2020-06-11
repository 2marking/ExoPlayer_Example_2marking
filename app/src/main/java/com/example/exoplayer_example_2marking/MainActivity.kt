package com.example.exoplayer_example_2marking

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayerFactory.newSimpleInstance
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util


class MainActivity : AppCompatActivity() {
    private val exoPlayerView: PlayerView? = null
    private var player: SimpleExoPlayer? = null

    var playWhenReady:Boolean = true
    var currentWindow:Int = 0
    var playbackPosition:Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initializePlayer()
    }

    override fun onStop(){
        super.onStop()
        releasePlayer()
    }

    fun initializePlayer(){
        if (player == null){
            player = newSimpleInstance(this.applicationContext)
            exoPlayerView?.player = player
        }

        val sampleURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

        val mediaSource:MediaSource = this!!.buildMediaSource(Uri.parse(sampleURL))!!

        player?.prepare(mediaSource, true, false)

        player?.playWhenReady = playWhenReady
    }

    private fun buildMediaSource(uri: Uri): MediaSource? {
        val userAgent = Util.getUserAgent(this, "blackJin")
        return if (uri.lastPathSegment!!.contains("mp3") || uri.lastPathSegment!!.contains("mp4")) {
            ExtractorMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent))
                .createMediaSource(uri)
        } else if (uri.lastPathSegment!!.contains("m3u8")) {
            //com.google.android.exoplayer:exoplayer-hls 확장 라이브러리를 빌드 해야 합니다.
            HlsMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent))
                .createMediaSource(uri)
        } else {
            ExtractorMediaSource.Factory(DefaultDataSourceFactory(this, userAgent))
                .createMediaSource(uri)
        }
    }

    private fun releasePlayer() {
        player?.let{
            playbackPosition = it.currentPosition
            currentWindow = it.currentWindowIndex
            playWhenReady = it.playWhenReady

            exoPlayerView?.player = null
            it.release()
            player = null
        }
    }
}
