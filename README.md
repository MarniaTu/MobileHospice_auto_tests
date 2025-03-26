# Приложение «Мобильный хоспис»
## Процедура запуска авто-тестов

1. Запустить тестируемой приложение в Android Studio на выбранном эмуляторе

2. В build.gradle приложения добавить следующие зависимости:

- в раздел DefaultConfig
  testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"

- в раздел dependencies
  testImplementation 'junit:junit:4.13.2'

  androidTestImplementation 'junit:junit:4.13.2'

  androidTestImplementation 'androidx.test.ext:junit:1.1.5'

  androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'

  androidTestImplementation 'androidx.test.espresso:espresso-contrib:3.5.1'

  androidTestImplementation 'androidx.test:runner:1.4.0'

  androidTestImplementation 'androidx.test:rules:1.4.0'

  androidTestImplementation 'androidx.test.espresso:espresso-intents:3.4.0'

3. В пакете Android приложения создать директорию для тестов ru.iteco.fmhandroid.ui (androidTest)

4. В тестовой директории добавить папки для:

- тестов (tests)
- вспомогательных / кастомных классов (utils)
- тестовых данных (testdata)
- страниц PageObject (pages)

5. Для написания шаблона авто-теста рекомендуется использовать инструмент Espresso Test Recorder