package org.unizd.rma.nekic

import java.io.Serializable

data class CharacterResponse(
    val data: List<Character>
) : Serializable

data class Character(
    val id: Int,
    val name: String,
    val age: Int?,
    val sex: String,
    val hairColor: String,
    val occupation: String,
    val grade: String?,
    val religion: String,
    val voicedBy: String?,
    val createdAt: String,
    val updatedAt: String,
    val url: String,
    val familyUrl: String,
    val relatives: List<Relative>,
    val episodes: List<String>
) : Serializable

data class Relative(
    val url: String,
    val relation: String
) : Serializable
