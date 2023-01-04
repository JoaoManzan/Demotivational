package com.example.demotivational.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.demotivational.R
import com.example.demotivational.data.Mock
import com.example.demotivational.infra.SecurityPreferences
import com.example.demotivational.databinding.ActivityMainBinding
import com.example.demotivational.infra.Constants
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var menuFilter = Constants.MenuFilter.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.hide()

        listeners()

        showUserName()

        resetChangeUserName()

        handleMenu(R.id.image_all)

        handlePhrase()

    }


    private fun listeners(){
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageSad.setOnClickListener(this)
        binding.imageRainy.setOnClickListener(this)
        binding.textHelloUser.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.button_new_phrase -> {
                handlePhrase()

            }
            in listOf(R.id.image_all,R.id.image_sad,R.id.image_rainy ) -> {
                handleMenu(view.id)
            }

            R.id.text_hello_user -> {
                changeUserName()
            }
        }
    }

    private fun showUserName() {
        val name =
            SecurityPreferences(this).getString(Constants.Key.USER_NAME)
        val hello = binding.textHelloUser.text.toString()
        binding.textHelloUser.text = buildString {
            append("$hello ${name.capitalize()}!")
        }
    }

    private fun changeUserName(){
        SecurityPreferences(this)
            .storeString(Constants.Key.CHANGE_NAME, Constants.Key.USER_NAME_EXISTS)
        startActivity(Intent(this, UserNameActivity::class.java))
        finish()
    }

    private fun resetChangeUserName(){
        SecurityPreferences(this)
            .storeString(Constants.Key.CHANGE_NAME, "")}

    private fun handleMenu(id: Int) {

        binding.imageAll.setColorFilter(
            ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSad.setColorFilter(
            ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageRainy.setColorFilter(
            ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(
                    ContextCompat.getColor(this, R.color.white))
                menuFilter = Constants.MenuFilter.ALL
            }
            R.id.image_sad -> {
                binding.imageSad.setColorFilter(
                    ContextCompat.getColor(this, R.color.white))
                menuFilter = Constants.MenuFilter.SAD
            }
            R.id.image_rainy -> {
                binding.imageRainy.setColorFilter(
                    ContextCompat.getColor(this, R.color.white))
                menuFilter = Constants.MenuFilter.RAINY
            }
        }
    }

    private fun handlePhrase() {
            binding.textViewDemotivation.text = Mock().randomizePhrases(menuFilter,
        Locale.getDefault().language)
    }
}


