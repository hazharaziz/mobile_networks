package com.mobilenetworks.mainproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.mobilenetworks.mainproject.databinding.ActivitySignupBinding
import com.mobilenetworks.mainproject.validation.InputValidator

class Signup : AppCompatActivity() {

    private var _binding: ActivitySignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backToLoginButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.txtFullName.addTextChangedListener {
            if (binding.fullNameWrapper.editText?.text?.length != -1) {
                binding.fullNameWrapper.isErrorEnabled = false
            }
        }

        binding.txtEmail.addTextChangedListener {
            if (InputValidator.isValidEmail(it.toString())) {
                binding.emailWrapper.isErrorEnabled = false
            } else {
                binding.emailWrapper.error = getString(R.string.input_invalid_email);
            }
        }

        binding.txtPhone.addTextChangedListener { text ->
            if (text?.length == 11) {
                binding.phoneWrapper.isErrorEnabled = false
            } else {
                binding.phoneWrapper.error = getString(R.string.input_invalid_phone)
            }
        }

        binding.txtPassword.addTextChangedListener {
            if (binding.passwordWrapper.editText?.text?.length != 0) {
                binding.passwordWrapper.isErrorEnabled = false
            }
        }

        binding.txtConfirmPassword.addTextChangedListener {
            if (binding.txtConfirmPassword.text.toString() == binding.txtConfirmPassword.text.toString()) {
                binding.confirmPasswordWrapper.isErrorEnabled = false
            } else {
                binding.confirmPasswordWrapper.error = getString(R.string.input_confirm_password_incorrect)
            }
        }

        binding.btnSignupCreate.setOnClickListener {
            var validInput = true
            if (binding.txtFullName.length() == 0) {
                binding.fullNameWrapper.error = getString(R.string.input_enter_full_name)
                validInput = false
            }
            if (!InputValidator.isValidEmail(binding.txtEmail.text.toString())) {
                binding.emailWrapper.error = getString(R.string.input_enter_email)
                validInput = false
            }
            if (binding.txtPhone.length() == 0) {
                binding.phoneWrapper.error = getString(R.string.input_enter_phone)
                validInput = false
            }
            if (binding.txtPassword.length() == 0) {
                binding.passwordWrapper.error = getString(R.string.input_enter_password)
                validInput = false
            }
            if (binding.txtConfirmPassword.length() == 0) {
                binding.confirmPasswordWrapper.error = getString(R.string.input_enter_confirm_password)
                validInput = false
            }

            if (validInput && binding.txtPassword.text.toString() != binding.txtConfirmPassword.text.toString()) {
                Toast.makeText(this, getString(R.string.input_confirm_password_incorrect), Toast.LENGTH_LONG).show()
                validInput = false
            }

            if (validInput) {
                Toast.makeText(this, getString(R.string.signup_user_created), Toast.LENGTH_LONG).show()
            }
        }

        binding.btnSwitchToLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}