package com.application.proxumer

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.github.nkzawa.emitter.Emitter
import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navView: BottomNavigationView
    private lateinit var mSocket: Socket
    private var notificationCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        mSocket = IO.socket("https://px-socket-api.herokuapp.com")
        mSocket.on("new-notification") {
            notificationCount++
            addBadge(notificationCount)

        }
        mSocket.connect()
    }

    private fun addBadge(count: Int) {
        val badge = navView.getOrCreateBadge(R.id.navigation_profile)
        badge.number = count
        badge.isVisible = true
    }
}