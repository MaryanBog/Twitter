package com.myproj.retpofit.models

import kotlin.random.Random

class TwitterGenerator {
    companion object {
        fun generateTwitts(): List<TwitterApi> {
            val twitts = ArrayList<TwitterApi>()
            val random = Random.nextInt(20, 40)
            for (i in 0..random) {
                when (Random.nextInt(0, 3)) {
                    0 -> {
                        twitts.add(
                            TwitterApi(
                                id = Random.nextInt(0, 5000),
                                text = "This is the sample text",
                                userName = "@mrHitman",
                                displayName = "Hitman",
                                quote = null,
                                avatar = "https://www.overclockers.ua/news/games/127543-egs-hitman-free.jpg",
                                image = "https://cdn.shazoo.ru/479551_0vFUfdqm7o_439861_wlrud4vbjy_hitman.jpg"
                            )
                        )
                    }
                    1 -> {
                        twitts.add(
                            TwitterApi(
                                id = Random.nextInt(0, 5000),
                                text = "This is the sample text",
                                userName = "@mrhitman",
                                displayName = "Hitman",
                                quote = Quote(
                                    userName = "@mrBond",
                                    text = "Bond, James Bond!"
                                ),
                                avatar = "https://www.overclockers.ua/news/games/127543-egs-hitman-free.jpg",
                                image = null
                            )
                        )
                    }
                    else -> {
                        twitts.add(
                            TwitterApi(
                                id = Random.nextInt(0, 5000),
                                text = "This is the sample text",
                                userName = "@mrhitman",
                                displayName = "Hitman",
                                quote = null,
                                avatar = "https://www.overclockers.ua/news/games/127543-egs-hitman-free.jpg",
                                image = null
                            )
                        )
                    }
                }
            }
            return twitts
        }
    }
}