package com.ei.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        Lbtn.setOnClickListener {
            val email=Lemail.text.toString()
            val pass=Lpass.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty()){
                auth.createUserWithEmailAndPassword(email,pass)
                    .addOnCompleteListener(this){task->
                        if(task.isSuccessful){
                            toast("Success")

                                val intent= Intent(this,MainActivity::class.java)
                                startActivity(intent)

                        }else{
                            toast("Sorry")
                        }

                    }
            }else{
                toast("Please fill all required")
            }

        }

    }
}
