package org.unizd.rma.nekic

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Html.fromHtml
import android.widget.Button
import android.widget.TextView

class CharacterDetails : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        val character = intent.getSerializableExtra("character") as Character
        displayCharacterDetails(character)

        findViewById<Button>(R.id.backBtn).setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
    @SuppressLint("SetTextI18n")
    private fun displayCharacterDetails(character: Character) {
      //  nameTextView.text = Html.fromHtml("<b>Name:</b> ${drinkX.strDrink}")
        findViewById<TextView>(R.id.nameTextView).text = fromHtml("<b>Name:</b> ${character.name}")
        findViewById<TextView>(R.id.ageTextView).text = fromHtml("<b>Age:</b> ${character.age?.toString() ?: "Unknown"}")
        findViewById<TextView>(R.id.sexTextView).text = fromHtml("<b>Sex:</b> ${character.sex}")
        findViewById<TextView>(R.id.hairColorTextView).text = fromHtml("<b>Hair Color:</b> ${character.hairColor}")
        findViewById<TextView>(R.id.occupationTextView).text = fromHtml("<b>Occupation:</b> ${character.occupation}")
        findViewById<TextView>(R.id.gradeTextView).text = fromHtml("<b>Grade:</b> ${character.grade ?: "Unknown"}")
        findViewById<TextView>(R.id.religionTextView).text = fromHtml("<b>Religion:</b> ${character.religion}")
        findViewById<TextView>(R.id.voicedByTextView).text = fromHtml("<b>Voiceby:</b> ${character.voicedBy ?: "Unknown"}")
    }

}