/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.geolocalisation

import android.app.Activity
import retrofit2.Call
import android.os.Bundle
import android.webkit.WebView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.geolocalisation.ui.ReceivedDataApp
import com.example.geolocalisation.ui.theme.GeolocationAppTheme
import java.util.Properties

class MainActivity : ComponentActivity() {

    private var activity: Activity? = null
    private var callBatiment: Call<Building>? = null
    private var spinner: Spinner? = null
    private var btn_chercher: ImageButton? = null
    private var btn_scan: ImageButton? = null
    private var adapter: ArrayAdapter<String>? = null
    private var properties: Properties? = null
    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            GeolocationAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ReceivedDataApp()
                }
            }
        }
    }
}
