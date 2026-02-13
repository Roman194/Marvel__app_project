package com.example.marvel_app_project.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.marvel_app_project.models.ui.HeroUI
import com.example.marvel_app_project.ui.theme.Sizes
import com.example.marvel_app_project.ui.theme.Spaces
import com.example.marvel_app_project.ui.theme.interFamily

//GitHub Copilot CL 2nd prompt 3rd attempt
/**
 * Отлично! Но ещё не хватает отступа после ChooseHeroHeader, из-за чего он сливается с идущими ниже
 * него элементами. Также Весь текст SingleHeroTextField должен быть с такими же паддингами, но в
 * левом нижнем углу. Также в ErrorColumn нужен верхний паддинг, при этом расстояние между самими
 * элементами Column и после них нужно сократить. Также реализация в HeroLoading компонента загрузки
 * через AsymcImage избыточна. Достаточно просто использовать Image
 */
/**
 * [SingleHeroTextField] is a [Composable] component function that draws text info for [SingleHeroScreen].
 * See more about [Jetpack Compose](https://developer.android.com/compose)
 *
 * [Composable] компонент-функция [SingleHeroTextField], используемая для вывода текстовой инфорамции в [SingleHeroScreen].
 *
 * @author Zyuzin Roman
 */
@Composable
fun SingleHeroTextField(hero: HeroUI){
    Column(
        modifier = Modifier.padding(
            start = Spaces.heroCardText.start,
            bottom = Spaces.heroCardText.bottom,
            end = Spaces.heroCardText.end
        )
    ) {
        Text(
            text = hero.name,
            fontSize = Sizes.fontSizes.heroNameInSingleScreen,
            fontFamily = interFamily,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.height(Spaces.spacer.smallerHeight))
        Text(
            text = hero.description,
            fontSize = Sizes.fontSizes.heroDescription,
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}