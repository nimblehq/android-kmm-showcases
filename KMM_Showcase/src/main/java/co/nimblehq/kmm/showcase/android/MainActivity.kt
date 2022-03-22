package co.nimblehq.kmm.showcase.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.nimblehq.kmm.showcase.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.tbMain)
    }
}
