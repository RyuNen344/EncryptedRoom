package com.ryunen344.crypto.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ryunen344.crypto.room.databinding.ActivityMainBinding
import com.ryunen344.crypto.room.db.entity.DemoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.IO) {
            Timber.wtf("insert")

            MainApplication.database.demoDao().insert(DemoEntity("demo desc"))

            Timber.wtf("select")

            MainApplication.database.demoDao().select().collectIndexed { index, value ->
                Timber.wtf("index $index $value")
            }
        }
    }
}
