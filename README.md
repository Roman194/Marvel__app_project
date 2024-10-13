# Production of the Marvell app
## Note
This project is showing the result of 2nd term at the "Digital Department" of OmSTU (with IT-firm "Effective" directly involve). <br/>
There were 6 labs in 2nd term. Each one was a part of the Marvel app. <br/>
## The result
During more than two month the Marvell App has been made. This app consists all major aspects of modern Android development<br/>
## Supported features
The Marvel app includes such techonlogies as:
- Jetpack Compose<br/>
- Retrofit<br/>
- Moshi<br/>
- Interceptors<br/>
- Working with Marvel API<br/>
- Either approach</br>
- Room DB</br>
- MVI design pattern</br>
- Dagger Hilt</br>
- FCM (Firebase)</br>
- Services</br>
- Broadcast Recievers</br>
</br>
Also The Marvel app supports:</br>
- Dark and light theme</br>
- Russian localization</br>
- Vertical / landscape orientation </br>
- Edge to edge approach</br>
- RTL</br>
## Screenshots</br>
Here you can see the result of the usage of app in different modes: <br/>

### Localization
|                                                             Default (English)                                                            |                                                           Russian                                                           |
|:---------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------:|
| <img src="https://github.com/Roman194/Marvel__app_project/assets/66479764/66d4953f-eb86-47b8-9033-2a9cf7dfcfdb" width=50% height=50%> | <img src="https://github.com/Roman194/Marvel__app_project/assets/66479764/4a5cb41c-6528-4940-aa40-bc2c8950781b" width=50% height=50%> |

### Theme
|                                                             Light theme                                                                 |                                                           Dark theme                                                         |
|:---------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------:|
| <img src="https://github.com/Roman194/Marvel__app_project/assets/66479764/220d323d-914a-4184-9015-a4a1c24476a6" width=50% height=50%> | <img src="https://github.com/Roman194/Marvel__app_project/assets/66479764/66d4953f-eb86-47b8-9033-2a9cf7dfcfdb" width=50% height=50%> |

### Orientation
|                                                            Portrait                                                                     |                                                          Landscape                                                           |
|:---------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------:|
| <img src="https://github.com/Roman194/Marvel__app_project/assets/66479764/faadef66-6643-4c8d-ae52-ff376a76c083" width=50% height=50%> | <img src="https://github.com/Roman194/Marvel__app_project/assets/66479764/3cc6c390-1644-4194-aedc-091439c0fd30" width=100% height=50%> |

### Text orientation
|                                                            LTR                                                                          |                                                          RTL                                                                 |
|:---------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------:|
| <img src="https://github.com/Roman194/Marvel__app_project/assets/66479764/66d4953f-eb86-47b8-9033-2a9cf7dfcfdb" width=50% height=50%> | <img src="https://github.com/Roman194/Marvel__app_project/assets/66479764/1662eafe-5d9a-482b-ba2b-26edbaf5c1f0" width=50% height=50%> |
| <img src="https://github.com/Roman194/Marvel__app_project/assets/66479764/98ac72d0-829f-4d92-9dc8-9fc02594e195" width=50% height=50%> | <img src="https://github.com/Roman194/Marvel__app_project/assets/66479764/24906d8e-8ba4-4fb2-8716-094d06a331bd" width=50% height=50%> |
## Video
Here you can see the video of working of the Marvel app:

https://github.com/user-attachments/assets/a678de5e-e783-4459-9fa1-a87b1052acf3


## How to run
* You need Android Studio (at least Koala) with Kotlin plugin (at least 1.9.0)
* Register on the website https://developer.marvel.com/docs#!/public/getCreatorCollection_get_0
* Get API_KEY and PRIVATE_API_KEY
* Add `API_KEY=<YourKey>` in `local.properties` file, for example `API_KEY="0945degbe7c90hhfc2k7ec88d85c34dd"`
* Add `PRIVATE_API_KEY=<YourKey>` in `local.properties` file, for example `PRIVATE_API_KEY="0ddadklfca3b9df2847c4b08977e9169af7cbd87"`
* Run -> Run 'app'
