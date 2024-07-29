package com.ecoapp.data

import com.ecoapp.R
import com.ecoapp.data.model.EcoItem
import com.ecoapp.data.model.EcoDetail

object EcoDataProvider {

  private fun createSubItems(
        ids: List<Int>,
        titles: List<String>,
        subtitles: List<String>,
        imageResIds: List<Int>
    ): List<EcoDetail> {
      return ids.zip(titles.zip(subtitles.zip(imageResIds))) { id, triple ->
          val (title, pair) = triple
          val (subtitle, imageResId) = pair
          EcoDetail(id, title, subtitle, imageResId)
      }
    }

    fun getEcoData(): List<EcoItem> {
        return listOf(
            EcoItem(
                imageResId = R.drawable.bird,
                subItems = createSubItems(
                    ids = listOf(1, 2, 3, 4, 5, 6),
                    listOf("Eagle", "Peacock", "Owl", "Pigeon", "Sparrow", "Crow"),
                    listOf(
                        "A majestic bird of prey",
                        "Known for its colorful plumage",
                        "Symbol of wisdom",
                        "Common city bird",
                        "Small and agile bird",
                        "Highly intelligent bird"
                    ),
                   listOf(R.drawable.eagle,R.drawable.peacock,R.drawable.owl,R.drawable.pigeon,R.drawable.sparrow,
                       R.drawable.crow)
                )
            ),
            EcoItem(
                imageResId = R.drawable.animal,
                subItems = createSubItems(
                    ids = listOf(7, 8, 9, 10, 11, 12),
                    listOf("Lion", "Tiger", "Bear", "Crocodile", "Wolf", "Fox"),
                    listOf(
                        "The king of the jungle",
                        "Largest of the big cats",
                        "Powerful and large mammals",
                        "Reptile with a powerful bite",
                        "Social and intelligent predator",
                        "Clever and adaptable"
                    ),
                    listOf(R.drawable.lion,R.drawable.tiger,R.drawable.bear,R.drawable.crocodile,R.drawable.wolf,
                        R.drawable.fox)
                )
            ),
            EcoItem(
                imageResId = R.drawable.flower,
                subItems = createSubItems(
                    ids = listOf(13, 14, 15, 16, 17, 18, 19, 20),
                    listOf(
                        "Rose",
                        "Jasmine",
                        "Sunflower",
                        "Lotus",
                        "Lavender",
                        "Marigold",
                        "Hibiscus",
                        "Millingtonia Hortensis"
                    ),
                    listOf(
                        "Classic symbol of love",
                        "Fragrant white flower",
                        "Bright and cheerful",
                        "Symbol of purity",
                        "Known for its soothing scent",
                        "Bright and vibrant flowers",
                        "Tropical flower",
                        "Sweet-scented flower"
                    ),
                    listOf(R.drawable.rose,R.drawable.jasmine,R.drawable.sunflower,R.drawable.lotus,R.drawable.lavender,
                        R.drawable.marigold,R.drawable.hibiscus,R.drawable.millingtonia)
                )
            )
        )
    }
}

