package com.matthewblott.jimlog

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import dev.hotwire.navigation.activities.HotwireActivity
import dev.hotwire.navigation.navigator.NavigatorConfiguration
import dev.hotwire.navigation.util.applyDefaultImeWindowInsets
import com.masilotti.bridgecomponents.shared.Bridgework
import dev.hotwire.core.bridge.KotlinXJsonConverter
import dev.hotwire.core.config.Hotwire
import dev.hotwire.navigation.config.registerBridgeComponents
import dev.hotwire.core.bridge.BridgeComponentFactory
import com.matthewblott.jimlog.components.ButtonComponent

class MainActivity : HotwireActivity() {
  companion object {
    private const val REQUEST_CODE_LOCAL_NETWORK = 1001
  }
  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()

    Hotwire.config.jsonConverter = KotlinXJsonConverter()
    Hotwire.registerBridgeComponents(*Bridgework.coreComponents)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    findViewById<View>(R.id.main_nav_host).applyDefaultImeWindowInsets()

    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_LOCAL_NETWORK)
      != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(
        this,
        arrayOf(Manifest.permission.ACCESS_LOCAL_NETWORK),
        REQUEST_CODE_LOCAL_NETWORK
      )
    }
  }

  override fun navigatorConfigurations() = listOf(
    NavigatorConfiguration(
      name = "main",
      startLocation = "http://10.0.2.2:5173",
      navigatorHostId = R.id.main_nav_host
    )
  )
}