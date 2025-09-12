package com.example.marvel_app_project.models.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * [HeroEntity] it's a data class (model) that is used by RoomDB to create DBTable structure.
 * It's also a Model that is used to transfer data from HeroRepository to HeroDao (RoomDB)
 * See [about RoomDB](https://metanit.com/kotlin/jetpack/16.2.php?ysclid=mfgko80w4a948973988)
 * @author Zyuzin Roman
 */
@Entity
data class HeroEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val serverId: String,
    val name: String,
    val description: String,
    val image: String,
)
