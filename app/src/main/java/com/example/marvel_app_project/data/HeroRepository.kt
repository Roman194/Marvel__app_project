package com.example.marvel_app_project.data

import com.example.marvel_app_project.data.network.Either.Either
import com.example.marvel_app_project.models.data.HeroEntity
import com.example.marvel_app_project.models.data.HeroReserve
import com.example.marvel_app_project.models.data.SingleHeroReserve

/**
 * It's the interface that is used to communicate between UI ViewModels and different data layer services (Network / DataBase).
 * It has it's implementation as [HeroRepositoryImpl].
 *
 * Это интерфейс, используемый для коммуникации между UI ViewModels и различными сервисами data-слоя (Network / Database).
 * Данный интерфейс имеет реализацию. Это [HeroRepositoryImpl].
 *
 * @see HeroEntity
 * @see HeroReserve
 * @see SingleHeroReserve
 * @see Either
 * @author Zyuzin Roman
 *
 */
interface HeroRepository {

    /**
     * fun [upsertHero] is used to add new hero to DB table.
     * This function is triggered by [singleHero] fun
     * @param heroEntity is the Hero object that is going to be added
     *
     * функция [upsertHero] используется для добавления новго героя в БД.
     * Эта функция вызывается из [singleHero] composable-функции.
     * параметр heroEntity это объект типа Hero, который будет добавлен в БД
     */

    suspend fun upsertHero(heroEntity: HeroEntity)

    /**
     * fun [updateHero] is used to update info about existing hero in DB table.
     * This function is triggered by [allHeroes] fun
     * @param heroEntity is the Hero object that is going to be updated
     *
     * функция [updateHero] используется для обновления информации о существующем герое в БД.
     * Эта функция вызывается из [allHeroes] composable-функции.
     * параметр heroEntity это объект типа Hero, который будет обновлён в БД
     */

    suspend fun updateHero(heroEntity: HeroEntity)

    /**
     * fun [allHeroes] is used to get to UI info about all heroes from the Marvel API.
     * If the request to it was failed the [HeroReserve] data will be used.
     * The function is triggered by app launches or user UI interaction
     *
     * функция [allHeroes] используется для отправки на UI-слой информации обо всех героях с MarvelAPI.
     * Если запрос зафейлится, то значения из [HeroReserve] будут использованы вместо данных с API.
     * Функция вызывается при открытии приложения или взаимодействии пользователя с UI
     *
     */

    suspend fun allHeroes(): Either<HeroReserve, List<HeroEntity>>

    /**
     * fun [randSingleHero] isn't used in this app nowadays. It will be used to choose random hero for sending "Heroes needs you" notification.
     * Still it has fully functional realization on data layer
     *
     * функция [randSingleHero] на текущий момент не используется. Она будет использована для выбора рандомного героя при отправке нотификации "Heroes needs you".
     * Так или иначе, функция имеет полную реализацию функционала на data-слое
     */

    suspend fun randSingleHero(): HeroEntity

    /**
     * fun [singleHero] is used to provide to UI the data about clicked hero. This fun is necessary to open singleHeroScreen with correct hero info.
     * The function is triggered by user UI interaction.
     * @param heroServerID is the APIs hero ID to get updated data about it.
     * @param heroID is the DB ID which is used when there is no connection with API or [heroServerID] wasn't found in API (case for heroes from [ObjectData] sample)
     *
     * функция [singleHero] используется для передачи данных на UI-слой о герое, на к-го кликнул п-ль.
     * Эта функция необоходима для открытия [singleHeroScreen] с корректной информацией о кликнутом герое.
     * Функция вызывается в результате вз-ия п-ля с UI.
     * параметр heroServerID это API-шый hero ID, используемый для получения обновлённых данных о герое с сервера.
     * параметр heroID это БД-шный айдишник, используемый когда отсутствует подключение к API или [heroServerID] не был обнаружен (для случаев использования героев из [ObjectData])
     *
     */

    suspend fun singleHero(heroID: Int, heroServerID: String): Either<SingleHeroReserve, HeroEntity>
}