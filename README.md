# ComposeNoteApp

### This project to study '[Domain Layer](https://developer.android.com/topic/architecture/domain-layer)' and declarative UI with ‘[Android Jetpack Compose](https://developer.android.com/jetpack/compose)’

I have already completed the ['DevFest 2021 Android Jetpack Compose'](https://github.com/winter-love-dev/ComposeFest2021) training course. Also, because I have experience developing declarative UI with iOS and Flutter, I was able to remember and learn this Compose study quickly and easily.

---
</br>

## Some screen recording

<div align="left">

| Writing Note | Editing Note | Delete Note |
| :---------------: | :---------------: | :---------------: |
| <img src="https://github.com/winter-love-dev/ComposeNoteApp/assets/26156815/fd62e001-2a2b-4a6b-bafd-99789ba9bb13" align="center" width="250px"/> | <img src="https://github.com/winter-love-dev/ComposeNoteApp/assets/26156815/4e0feb14-efa7-41bf-b498-f8a31a053c0c" align="center" width="250px"/> | <img src="https://github.com/winter-love-dev/ComposeNoteApp/assets/26156815/38a9543e-66b2-4c18-b3dc-bd39523f99c8" align="center" width="250px"/> |

</div>

## Tech Stack

<p align="left">
  <a href="https://kotlinlang.org"><img alt="Kotlin Version" src="https://img.shields.io/badge/Kotlin-1.8.10-blueviolet.svg?style=flat"/></a>
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
</p>

All library info : [libs.versions.toml](gradle/libs.versions.toml)

- <b>AAC-ViewModel</b> Combined with the screen, it maintains screen state and handles UI state and screen rotation events.
- <b>Coroutine</b> Asynchronous Task. Used 'Flow' to make data flow and reflect it in the UI. 
- Jetpack
  - <b>Hilt</b> Dependency Injection
  - <b>Room</b>
    - Focused on implementing functionality by leveraging SQLite wrapped in an abstraction layer, and combined 'Flow' to implement UI interaction more easily.
  - <b>Compose</b>
    - Programming in ‘Custom UI Component’ units
    - ‘Custom UI component’ that emits events based on higher-order functions
    - Implement a UI testable screen by separating @Composable functions

---

# Architecture

## Compose UI Programming referring [Unidirectional data flow document Pattern](https://developer.android.com/jetpack/compose/architecture#udf).
![state-unidirectional-flow](https://github.com/winter-love-dev/ComposeNoteApp/assets/26156815/9c96df0f-14db-4c53-a5ff-0d7337259dae)

## MVVM Design pattern with Dependency Injection, Reference by [App Arhitecture Guide](https://developer.android.com/jetpack/guide?hl=ko#mobile-app-ux)  
![mvvm_example](https://github.com/winter-love-dev/CatchBottle/assets/26156815/f61d9746-f375-4cfa-80ea-20a3cb0ceafb)

## Multi Module Architecture, Reference by [android/nowinandroid](https://github.com/android/nowinandroid)
![dep_graph_app](https://github.com/winter-love-dev/CatchBottle/assets/26156815/22cdd95a-29ee-4ea6-be8e-fe42ffeae5a2)

## Domain Layer, Reference by [Domain Layer Docs](https://developer.android.com/topic/architecture/domain-layer)

Work Focused
- Define feature specification
- Programming on the repository layer or feature layer, By domain layer specification.
- Programming in ‘UseCase’ units
- And code abstraction

![mad-arch-domain-overview](https://github.com/winter-love-dev/CatchBottle/assets/26156815/5997a25a-3d89-4314-8bb8-d7f5253c6faf)


---
</br>



# License
```
Copyright 2023 winter-love-dev

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
