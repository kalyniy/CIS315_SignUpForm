package edu.temple.singupform

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnSignUp)
            .setOnClickListener {
                verifyData()

            }
    }
    fun isValidEmail(target: CharSequence?): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }
    fun verifyData()
    {
        val nameView = findViewById<EditText>(R.id.name)
        val emailView = findViewById<EditText>(R.id.email)
        val passwordView1 = findViewById<EditText>(R.id.password)
        val passwordView2 = findViewById<EditText>(R.id.passwordConfirmation)

        var name: String = nameView.getText().toString();
        var email: String = emailView.getText().toString();
        var password1: String = passwordView1.getText().toString();
        var password2: String = passwordView2.getText().toString();

        var isEmpty: Boolean = false;
        // check for empty fields
        if (name.equals("")) {
            nameView.setError("Please enter your name.");
            isEmpty = true;
        }
        if (email.equals("")) {
            emailView.setError("Please enter your email.");
            isEmpty = true;
        }
        if (password1.equals("")) {
            passwordView1.setError("Please enter your password.");
            isEmpty = true;
        }
        if (password2.equals("")) {
            passwordView2.setError("Please confirm your password.");
            isEmpty = true;
        }
        if(isEmpty)
        {
            return;
        }
        // Email pattern check && passwords
        if(!isValidEmail(email) && !email.equals(""))
        {
            emailView.setError("Not a proper email address.");
        }
        if(!password1.equals(password2))
        {
            passwordView2.setError("Passwords don't match.");
            return;
        }
        var user: User = User(name, email, password1);
        


    }
}