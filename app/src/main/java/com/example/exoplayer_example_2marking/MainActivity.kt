package com.example.exoplayer_example_2marking

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.Timeline
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Log
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), Player.EventListener{
//    private val exoPlayerView: PlayerView? = null
    private var player1: SimpleExoPlayer? = null
    private var player2: SimpleExoPlayer? = null

    private var playWhenReady:Boolean = true
    private var currentWindow:Int = 0
    private var playbackPosition:Long = 0L
    private val videoDataSize:Int = 2

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

    private fun setPlayerEventListener(){
//        player1!!.addListener(object : Player.EventListener {
//            fun onTimelineChanged(
//                timeline: Timeline?,
//                manifest: Any?
//            ) {
//                Log.e("onTimelineChanged","call")
//            }
//
//            override fun onTracksChanged(
//                trackGroups: TrackGroupArray,
//                trackSelections: TrackSelectionArray
//            ) {
//                Log.e("onTracksChanged","call")
//            }
//
//            override fun onLoadingChanged(isLoading: Boolean) {
//                Log.e("onLoadingChanged","call")
//            }
//            override fun onPlayerStateChanged(
//                playWhenReady: Boolean,
//                playbackState: Int
//            ) {
//                Log.e("onPlayerStateChanged","call")
//            }
//
//            override fun onPlayerError(error: ExoPlaybackException) {
//                //Catch here, but app still crash on some errors!
//                Log.e("onPlayerError","call")
//            }
//
//            fun onPositionDiscontinuity() {}
//        })
    }
    private fun initializePlayer(){
        if (player1 == null){
            player1 = SimpleExoPlayer.Builder(this).build()
            setPlayerEventListener()
            testExoPlayerView1?.player = player1
        }

        val sampleURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

        val mediaSource:MediaSource = this!!.buildMediaSource(Uri.parse(sampleURL))!!

        player1?.prepare(mediaSource, true, false)
        player1?.playWhenReady = playWhenReady

        if (player2 == null){
            player2 = SimpleExoPlayer.Builder(this).build()
            testExoPlayerView2?.player = player2
        }
        val mediaSource2:MediaSource = this!!.buildMediaSource(Uri.parse(sampleURL))!!
        player2?.prepare(mediaSource2, true, false)
        player2?.playWhenReady = playWhenReady
    }

    private fun buildMediaSource(uri: Uri): MediaSource? {
        val userAgent = Util.getUserAgent(this, "blackJin")
        return if (uri.lastPathSegment!!.contains("mp3") || uri.lastPathSegment!!.contains("mp4")) {
            Log.e("if case","first")
            ProgressiveMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent))
                .createMediaSource(uri)
        } else if (uri.lastPathSegment!!.contains("m3u8")) {
            //com.google.android.exoplayer:exoplayer-hls 확장 라이브러리를 빌드 해야 합니다.
            Log.e("if case","second")

            HlsMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent))
                .createMediaSource(uri)
        } else {
            Log.e("if case","else")

            ProgressiveMediaSource.Factory(DefaultDataSourceFactory(this, userAgent))
                .createMediaSource(uri)
        }
    }

    private fun releasePlayer() {
        player1?.let{
            playbackPosition = it.currentPosition
            currentWindow = it.currentWindowIndex
            playWhenReady = it.playWhenReady
            testExoPlayerView1?.player = null

            it.release()
            player1 = null
        }
        player2?.let{
            playbackPosition = it.currentPosition
            currentWindow = it.currentWindowIndex
            playWhenReady = it.playWhenReady

            testExoPlayerView2?.player = null

            it.release()
            player2 = null
        }
    }
}
