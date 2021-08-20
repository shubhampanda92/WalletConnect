package com.hike.walletconnect

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.net.URLEncoder
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val key = ByteArray(32).also { Random().nextBytes(it) }.toNoPrefixHexString()
        val config = Config(UUID.randomUUID().toString(), "https://bridge.walletconnect.org", key)
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(config.toWCUri())
        startActivity(i)
    }

    data class Config(
        val handshakeTopic: String,
        val bridge: String? = null,
        val key: String? = null,
        val protocol: String = "wc",
        val version: Int = 1
    ){
        fun toWCUri() = "wc:$handshakeTopic@$version?bridge=${URLEncoder.encode(bridge, "UTF-8")}&key=$key"
    }
}