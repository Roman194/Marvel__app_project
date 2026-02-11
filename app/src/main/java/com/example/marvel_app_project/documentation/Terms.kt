package com.example.marvel_app_project.documentation

import com.example.marvel_app_project.data.network.Either.Either.Fail
import com.example.marvel_app_project.data.network.Either.Either.Success

/**
 * В данном файле перечислены основные термины, используемые в данном приложении.
 *
 * Корутина - облегчённый поток. Является абстракцией в android для вызова асинхронных операций (работа с сетью, БД).
 * UI - User Interface (Пользовательский интерфейс - сокращение).
 * DI - Dependency Injection (Инъекция зависимостей - сокращение). Подробнее про DI см.
 * [здесь](https://www.youtube.com/live/yGiCNunSVN8?si=2q-cqxnb3kFm4D50).
 * ViewModel - класс, используемый для связи UI-представления и бизнес-логики экрана.
 * Нотификация - Всплывающее сообщение от приложения в верхней части экрана пользователя.
 * MVI (Model-View-Intent) - Паттерн проектирования, заключающийся в передаче событий и данных с и на
 * экраны в рамках "единого потока данных".
 * FCI (Firebase Cloude Messaging) - Интернет-сервис быстрой отправки нотификаций на телефоны пользователей.
 * Either - Способ передачи данных из интернета на UI-слой приложения. Он хранит в себе 2 состояния: [Success] и [Fail].
 * BroadcastReceiver - Один из четырёх основных компонентов в android-разработке, позволяющий управлять
 * процессами приложения в фоновом режиме.
 *
 * @author Zyuzin Roman
 */