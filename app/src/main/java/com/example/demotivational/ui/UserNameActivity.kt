package com.example.demotivational.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.demotivational.R
import com.example.demotivational.infra.SecurityPreferences
import com.example.demotivational.databinding.ActivityUserNameBinding
import com.example.demotivational.infra.Constants

class UserNameActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserNameBinding
    private lateinit var security: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        security = SecurityPreferences(this)

        binding.buttonSave.setOnClickListener(this)

        verifyUserName()
    }

    override fun onStop() {
        super.onStop()
        finish()
    }

    private fun verifyUserName() {
        val name = SecurityPreferences(this)
            .getString(Constants.Key.USER_NAME)
        val change = SecurityPreferences(this)
            .getString(Constants.Key.CHANGE_NAME)
        if (name != "" && change != Constants.Key.USER_NAME_EXISTS){
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) handleSave()
    }

    private fun handleSave() {
        val userName = binding.editUserName.text.toString()

        if (userName != "") {

            SecurityPreferences(this)
                .storeString(Constants.Key.USER_NAME, userName)

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        } else {
            Toast.makeText(
                this,
                R.string.warning_toast,
                Toast.LENGTH_SHORT
            ).show()
        }

    }

}