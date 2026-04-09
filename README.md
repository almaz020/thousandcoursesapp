# 📱 Thousand Courses App

Android-приложение для просмотра онлайн-курсов.

---

## 🚀 Функционал

* 🔐 Экран входа (валидация email и пароля)
* 📚 Список курсов (загрузка с API)
* ❤️ Добавление курсов в избранное (с сохранением в БД)
* ⭐ Экран избранных курсов
* 🔄 Сортировка курсов по дате публикации
* 📱 Bottom Navigation (Главная / Избранное / Профиль)

---

## 🧱 Архитектура

Проект реализован с использованием **Clean Architecture + MVVM**

### Слои:

* **Data**

  * Retrofit API
  * DTO модели
  * Repository implementation
  * Room (локальная БД)

* **Domain**

  * UseCase
  * Бизнес-логика
  * Модели

* **Presentation**

  * Jetpack Compose UI
  * ViewModel
  * StateFlow

---

## 🛠 Технологии

* Kotlin
* Jetpack Compose
* Retrofit
* Coroutines + Flow
* Koin (Dependency Injection)
* Room (SQLite)
* Navigation Compose

---

## 🔗 API

Данные получаются из mock API:

https://drive.usercontent.google.com/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download

---

## 💾 Работа с избранным

* Избранные курсы сохраняются локально с помощью Room
* UI автоматически обновляется через Flow
* Реализована реактивная синхронизация API + БД

---

## 🎨 UI/UX

* Полностью реализован на Jetpack Compose
* Ограничение текста описания (2 строки)
* Поддержка состояний (через StateFlow)
* Анимация избранного
* Форматирование даты

---

## 📌 Особенности

* Используется реактивный подход (Flow)
* Чистая архитектура (разделение слоев)
* Масштабируемая структура проекта
* Минимальное количество хардкода

