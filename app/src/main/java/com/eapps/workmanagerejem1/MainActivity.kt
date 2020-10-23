package com.eapps.workmanagerejem1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Data
import androidx.work.workDataOf
import com.eapps.workmanagerejem1.model.SumaWorkManager
import com.eapps.workmanagerejem1.viewmodel.GpsWorkViewModel
import com.eapps.workmanagerejem1.viewmodel.SumaWorkViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel : GpsWorkViewModel by viewModel()
    private val viewmodel2 : SumaWorkViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.setUpSynchronization()

        val myData: Data = workDataOf("N1" to 5,
        "N2" to 10)
        viewmodel2.setupSynchronization(myData)


    }
}