package com.yasuda.tfmmangamark

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yasuda.tfmmangamark.model.User
import com.yasuda.tfmmangamark.util.MangaServiceGenerator
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bt_login.setOnClickListener {
            verificaLogin(txt_login.text.toString(), txt_password.text.toString())
        }

        bt_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun verificaLogin(l: String, p: String){
        var users = mutableListOf<User>()
        val service = MangaServiceGenerator.getService()

        service.getAllUsers().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                falhalogin()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                users = response.body()!!.toMutableList()
                for (user: User in users) {
                    if (user.login == l) {
                        if (user.password == p) {
                            pass(user.id)
                        }
                        else{
                            falhalogin()
                        }
                    }
                }

            }
        })
    }

    fun falhalogin(){
        Toast.makeText(applicationContext, "Login ou Senha Invalidos", Toast.LENGTH_LONG).show()
    }
    fun pass(id : Long){
        val intent = Intent(this, ListActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }
}