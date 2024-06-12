package com.example.room
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var db: UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = UserDatabase.getDatabase(this)

        // Inserting a user in the database
        lifecycleScope.launch {
            val user = User(id = 0, name = "John Doe", age = 25)
            db.userDao().insert(user)

            // Fetching users from the database
            val users = db.userDao().getAllUsers()
            users.forEach {
                println(it.name)
            }
        }
    }
}
