package com.mobilenetworks.mainproject

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.mobilenetworks.mainproject.databinding.ActivityLoginBinding
import com.mobilenetworks.mainproject.validation.InputValidator
import java.util.*

class Login : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!
    private val _randomGenerator: Random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtEmail.addTextChangedListener {
            if (InputValidator.isValidEmail(it.toString())) {
                binding.emailWrapper.isErrorEnabled = false
            } else {
                binding.emailWrapper.error = getString(R.string.input_invalid_email)
            }
        }

        binding.txtPassword.addTextChangedListener {
            if (binding.passwordWrapper.editText?.text?.length != 0) {
                binding.passwordWrapper.isErrorEnabled = false
            }
        }

        binding.btnLogin.setOnClickListener {
            val loginSuccess = getString(R.string.login_successful)
            val enterValidEmail = getString(R.string.input_enter_email)
            val enterPassword = getString(R.string.input_enter_password)

            if (binding.txtEmail.length() != 0 &&
                InputValidator.isValidEmail(binding.emailWrapper.editText!!.text) &&
                binding.txtPassword.length() != 0) {
                Toast.makeText(this, loginSuccess, Toast.LENGTH_LONG).show()
            }
            if (binding.txtEmail.length() == 0 && binding.txtPassword.length() != 0) {
                binding.emailWrapper.error = enterValidEmail
            }
            if (binding.txtEmail.length() != 0 && binding.txtPassword.length() == 0) {
                binding.passwordWrapper.error = enterPassword
            }
            if (binding.txtEmail.length() == 0 && binding.txtPassword.length() == 0) {
                binding.emailWrapper.error = enterValidEmail
                binding.passwordWrapper.error = enterPassword
            }
        }

        binding.btnGoogleLogin.setOnClickListener {
            binding.btnGoogleLogin.setBackgroundColor(
                Color.argb(
                    255,
                    _randomGenerator.nextInt(255),
                    _randomGenerator.nextInt(255),
                    _randomGenerator.nextInt(255)
                )
            )
        }

        binding.btnFacebookLogin.setOnClickListener {
            binding.btnFacebookLogin.setBackgroundColor(
                Color.argb(
                    255,
                    _randomGenerator.nextInt(255),
                    _randomGenerator.nextInt(255),
                    _randomGenerator.nextInt(255)
                )
            )
        }

        binding.btnSwitchToSignup.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
    }
}