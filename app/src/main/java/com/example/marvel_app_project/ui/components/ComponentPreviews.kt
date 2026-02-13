package com.example.marvel_app_project.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.theme.Marvel_app_projectTheme

@Preview(showBackground = true)
@Composable
fun ChooseHeroHeaderPreview() {
    Marvel_app_projectTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            ChooseHeroHeader()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroCardPreview() {
    Marvel_app_projectTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            HeroCard(
                hero = HeroUI(
                    id = 1,
                    serverId = "1009144",
                    name = "Spider-Man",
                    description = "Bitten by a radioactive spider, high school student Peter Parker gained the speed, strength and powers of a spider.",
                    image = "https://kartinki.pics/uploads/posts/2022-03/1646974026_3-kartinkin-net-p-kartinki-dedpula-3.jpg"
                ),
                onAction = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SingleHeroTextFieldPreview() {
    Marvel_app_projectTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            SingleHeroTextField(
                hero = HeroUI(
                    id = 1,
                    serverId = "1009144",
                    name = "Spider-Man",
                    description = "Bitten by a radioactive spider, high school student Peter Parker gained the speed, strength and powers of a spider.",
                    image = "https://kartinki.pics/uploads/posts/2022-03/1646974026_3-kartinkin-net-p-kartinki-dedpula-3.jpg"
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorColumnPreview() {
    Marvel_app_projectTheme {
        ErrorColumn(errorMessage = "Can't reach data from the server")
    }
}



