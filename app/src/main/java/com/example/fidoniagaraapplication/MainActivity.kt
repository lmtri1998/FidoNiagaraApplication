package com.example.fidoniagaraapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.facebook.CallbackManager
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.FacebookCallback
import com.facebook.login.LoginManager
import android.widget.Toast
import android.content.Intent






class MainActivity : AppCompatActivity() {

    private var callbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        FacebookSdk.sdkInitialize(getApplicationContext())
//        AppEventsLogger.activateApp(this)

        var btnLogInFacebook = findViewById<Button>(R.id.login_button)

        btnLogInFacebook.setOnClickListener(View.OnClickListener {
            callbackManager = CallbackManager.Factory.create()
            LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(loginResult: LoginResult) {
                        // App code
                        Toast.makeText(this@MainActivity, "success", Toast.LENGTH_LONG).show()
                    }

                    override fun onCancel() {
                        // App code
                        Toast.makeText(this@MainActivity, "cancel", Toast.LENGTH_LONG).show()
                    }

                    override fun onError(exception: FacebookException) {
                        // App code
                        Toast.makeText(this@MainActivity, "error", Toast.LENGTH_LONG).show()
                    }
                })
        })
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode, resultCode, data)

    }

}
