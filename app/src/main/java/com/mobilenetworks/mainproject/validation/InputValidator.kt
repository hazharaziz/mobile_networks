package com.mobilenetworks.mainproject.validation

import android.text.TextUtils
import android.util.Patterns

class InputValidator {
    companion object {
        fun isValidEmail(target: CharSequence?): Boolean {
            return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target.toString()).matches()
        }
    }
}