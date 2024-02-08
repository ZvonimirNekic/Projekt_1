package org.unizd.rma.nekic

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(private val context: Context, private val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        //val occupationTextView: TextView = itemView.findViewById(R.id.occupationTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.nameTextView.text = character.name
        //holder.occupationTextView.text = character.occupation

        holder.itemView.setOnClickListener {
            val intent = Intent(context, CharacterDetails::class.java)
            intent.putExtra("character", character)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}
