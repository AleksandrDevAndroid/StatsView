package ru.netology.nmedia.ui

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val view = binding.stats
        val defaultData = listOf(
            0.0F,
            0.25F,
            0.25F,
            0.25F,
        )
        binding.buttonOne.setOnClickListener {
            view.animation = StatsView.AnimationType.PARALLEL
            view.data = defaultData
        }

        binding.buttonTwo.setOnClickListener {
            view.animation = StatsView.AnimationType.SEQUENTIAL

            view.data = defaultData

        }

        binding.buttonThree.setOnClickListener {
            view.animation = StatsView.AnimationType.BILATERAL
            view.data = defaultData
        }

    }
}