# Объектно-ориентированное программирование (лекции).

Чтобы понять принципы ООП, книги не требуются. Взгляните вокруг себя. Всмотритесь в любой объект в реальном мире, опишите его наиболее подробно (материал, размер, цвет, вес, плотность, составные части и т.д.), это будут его свойства. Опишите, что и каким образом этот объект умеет делать (включаться, складываться, кушать электроэнергию, взаимодействовать с другими объектами или окружающей средой и т.д.), это будут его методы. Подумайте, для чего используется этот объект, что ему нужно изменить или добавить, чтобы использовать в других условиях или целях, и на основе всех собранных знаний создать более удобный экземпляр, это будет наследование и полиморфизм. Теперь немедленно забудьте обо всем, используйте объект по назначению, это будет инкапсуляция. Дальше останутся только тонкости выбранного Вами языка, шаблоны, методологии и прочаяие ересь тренды.

-   [Presentation_Lesson_01.md](/src/Lesson_01/Presentation_Lesson_01.md)

-   [Презентация Лекция 1](https://drive.google.com/file/d/1gY4M4rShrSXk5BOMn2ypgggLddZ_3EUi/view?usp=drive_link)

-   []()

-   []()

-   []()

# [Глава 3. Классы. Объектно-ориентированное программирование.](https://metanit.com/java/tutorial/3.1.php)

-   ## [Классы и объекты](https://metanit.com/java/tutorial/3.1.php)

    [Program_01](/src/Terms_Code/Program_01.java) Классы

    [Program_02](/src/Terms_Code/Program_02.java) Объекты (Конструкторы = 1)

    [Program_03](/src/Terms_Code/Program_03.java) Объекты (Констркуторы > 1)

    [Program_04](/src/Terms_Code/Program_04.java) Объекты (Ключевое слово this)

    [Program_05](/src/Terms_Code/Program_05.java) Объекты (Инициализаторы)

-   ## [Пакеты](https://metanit.com/java/tutorial/3.2.php)

    [Program_06](/src/Terms_Code/study/Program_06.java) package название_пакета;

    [Program_07](/src/Terms_Code/study/Program_07.java) Импорт пакетов и классов

    [Program_08](/src/Terms_Code/study/Program_08.java) Статический импорт

-   ## [Модификаторы доступа и инкапсуляция](https://metanit.com/java/tutorial/3.3.php)

    [Program_09](/src/Terms_Code/Program_09.java) Модификаторы доступа

    [Схема Modifier](/src/Terms_Code/Modifier.png)

    [Program_10](/src/Terms_Code/Program_10.java) Инкапсуляция

-   ## [Статические члены и модификатор static](https://metanit.com/java/tutorial/3.4.php)

    [Program_11](/src/Terms_Code/Program_11.java) Статические поля

    [Program_12](/src/Terms_Code/Program_12.java) Статические константы

    [Program_13](/src/Terms_Code/Program_13.java) Статические инициализаторы

    [Program_14](/src/Terms_Code/Program_14.java) Статические методы

    [Program_15](/src/Terms_Code/Program_15.java) Статические методы

-   ## [Объекты как параметры методов](https://metanit.com/java/tutorial/3.14.php)

    [Program_16](/src/Terms_Code/Program_16.java) Объекты классов, могут передаваться в методы (Изменится name)

    [Program_17](/src/Terms_Code/Program_17.java) Объекты классов, могут передаваться в методы (Не Изменится name)

-   ## [Внутренние и вложенные классы](https://metanit.com/java/tutorial/3.12.php)

    [Program_18](/src/Terms_Code/Program_18.java) Внутренние и вложенные классы

    [Program_19](/src/Terms_Code/Program_19.java) Внутренние и вложенные классы

    [Program_20](/src/Terms_Code/Program_20.java) Класс [Math20](/src/Terms_Code/Math20.java) (Факториал) Статические вложенные классы

-   ## [Наследование](https://metanit.com/java/tutorial/3.5.php)

    [Person21](/src/Terms_Code/Person21.java) Класс (базовый, родительский, суперкласс)

    [Employee21](/src/Terms_Code/Employee21.java) Класс (производный, наследник, подкласс) extends [Person21](/src/Terms_Code/Person21.java)

    [Program_21](/src/Terms_Code/Program_21.java) Использование классов Person21 и Employee21

    [Employee22](/src/Terms_Code/Employee22.java) Класс (производный, наследник, подкласс) extends [Person21](/src/Terms_Code/Person21.java)

    [Program_22](/src/Terms_Code/Program_22.java) Использование классов Person21 и Employee22

    [Program_23](/src/Terms_Code/Program_23.java) Наследование (Переопределение методов)

    [Program_24](/src/Terms_Code/Program_24.java) Наследование (Переопределение методов)

    [Program_25](/src/Terms_Code/Program_25.java) Запрет наследования, запрет переопределения методов

    [Program_26](/src/Terms_Code/Program_26.java) Динамическая диспетчеризация методов (Наследование и возможность переопределения методов) или (dynamic method lookup) динамический поиск метода

-   ## [Абстрактные классы](https://metanit.com/java/tutorial/3.6.php)

    [Program_27](/src/Terms_Code/Program_27.java) Абстрактные классы и методы

    [Program_28](/src/Terms_Code/Program_28.java) Абстрактные классы и методы

-   ## [Иерархия наследования и преобразование типов](https://metanit.com/java/tutorial/3.10.php)

    [Program_29](/src/Terms_Code/Program_29.java) Иерархия наследования и преобразование типов
    [Сlass_Hierarchy](/src/Terms_Code/Сlass_Hierarchy.png)

    [Program_30](/src/Terms_Code/Program_30.java) Оператор instanceof (проверяет, является ли переменная объектом типа)

-   ## [Интерфейсы](https://metanit.com/java/tutorial/3.7.php)

    [Program_31](/src/Terms_Code/Program_31.java) Определение интерфейса (interface => для использование => ключевое слово implements)

    [Program_32](/src/Terms_Code/Program_32.java) Динамическое создание объектов с типом интерфейс в программе как экземпляры обоих классов

    [Program_33](/src/Terms_Code/Program_33.java) Интерфейсы в преобразованиях типов

    [Program_34](/src/Terms_Code/Program_34.java) Методы по умолчанию в интерфейсах

    [Program_35](/src/Terms_Code/Program_35.java) Статические методы в интерфейсах

    [Program_36](/src/Terms_Code/Program_36.java) Приватные методы в интерфейсах

-   ## [Интерфейсы в механизме обратного вызова](https://metanit.com/java/tutorial/3.16.php)

-   ## [Перечисления enum](https://metanit.com/java/tutorial/3.8.php)

-   ## [Класс Object и его методы](https://metanit.com/java/tutorial/3.9.php)

-   ## [Обобщения (Generics)](https://metanit.com/java/tutorial/3.11.php)

-   ## [Ограничения обобщений](https://metanit.com/java/tutorial/3.17.php)

-   ## [Наследование и обобщения](https://metanit.com/java/tutorial/3.15.php)

-   ## [Ссылочные типы и клонирование объектов](https://metanit.com/java/tutorial/3.13.php)

-   ## [Records](https://metanit.com/java/tutorial/3.18.php)
