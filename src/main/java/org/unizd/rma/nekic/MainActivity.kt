package org.unizd.rma.nekic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchData()
    }

    private fun fetchData() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://spapi.dev/api/characters")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                response.body?.let { responseBody ->
                    val responseData = responseBody.string()
                    val characters = parseJson(responseData)
                    runOnUiThread {
                        characterAdapter = CharacterAdapter(this@MainActivity, characters)
                        recyclerView.adapter = characterAdapter
                    }
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }
        })
    }

    private fun parseJson(jsonString: String): List<Character> {
        val gson = Gson()
        val jsonObject = JSONObject(jsonString)
        val dataArray = jsonObject.getJSONArray("data")
        val characters = mutableListOf<Character>()

        for (i in 0 until dataArray.length()) {
            val characterJson = dataArray.getJSONObject(i)
            val character = gson.fromJson(characterJson.toString(), Character::class.java)
            characters.add(character)
        }

        return characters
    }
}
