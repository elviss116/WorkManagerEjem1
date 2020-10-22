package com.eapps.workmanagerejem1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eapps.workmanagerejem1.viewmodel.GpsWorkViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel : GpsWorkViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel.setUpSynchronization()
    }
}