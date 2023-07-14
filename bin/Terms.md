# Термины в Java, ООП!

### План:

1. Модификаторы доступа (public, private, protected, по умолчанию).
2. Инкапсуляция.
3.

## 1. Модификаторы доступа (public, private, protected, по умолчанию).

Все члены класса в языке Java - поля и методы - имеют модификаторы доступа.

Модификаторы доступа позволяют задать допустимую область видимости для членов класса, то есть контекст, в котором можно употреблять данную переменную или метод.

В Java используются следующие модификаторы доступа:

-   public: публичный, общедоступный класс или член класса. Поля и методы, объявленные с модификатором public, видны другим классам из текущего пакета и из внешних пакетов.

-   private: закрытый класс или член класса, противоположность модификатору public. Закрытый класс или член класса доступен только из кода в том же классе.

-   protected: такой класс или член класса доступен из любого места в текущем классе или пакете или в производных классах, даже если они находятся в других пакетах

Модификатор по умолчанию. Отсутствие модификатора у поля или метода класса предполагает применение к нему модификатора по умолчанию. Такие поля или методы видны всем классам в текущем пакете.

Рассмотрим модификаторы доступа на примере следующей программы:

[Program_01](/src/Terms_Code/Program_01.java)

В данном случае оба класса расположены в одном пакете - пакете по умолчанию, поэтому в классе **Program_01** мы можем использовать все методы и переменные класса Person, которые имеют модификатор по умолчанию, public и protected. А поля и методы с модификатором private в классе Program не будут доступны.

Если бы класс Program располагался бы в другом пакете, то ему были бы доступны только поля и методы с модификатором public.

Модификатор доступа должен предшествовать остальной части определения переменной или метода.

Для чего используется ключевое слово this?

Ключевое слово this ссылается на текущий экземпляр класса, а также используется в качестве модификатора первого параметра метода расширения. В этой статье рассматривается использование this с экземплярами класса.

Когда теряется this?

Как только метод передаётся отдельно от объекта – this теряется.

Объект — это сгруппированные вместе данные и методы для того, чтобы эти данные обрабатывать. Когда мы говорим о данных, имеем в виду переменные, конечно. Про переменные объекта говорят, что это «данные объекта» или «состояние объекта». Про методы объекта говорят: это «поведение объекта».

## 2. Инкапсуляция.

Инкапсуляция – это свойство системы, позволяющее объединить данные и методы, работающие с ними в классе, скрыв детали реализации и защитив от пользователя этого класса объектов.

Казалось бы, почему бы не объявить все переменные и методы с модификатором public, чтобы они были доступны в любой точке программы вне зависимости от пакета или класса?

Возьмем, например, поле age, которое представляет возраст. Если другой класс имеет прямой доступ к этому полю, то есть вероятность, что в процессе работы программы ему будет передано некорректное значение, например, отрицательное число. Подобное изменение данных не является желательным. Либо же мы хотим, чтобы некоторые данные были достуны напрямую, чтобы их можно было вывести на консоль или просто узнать их значение. В этой связи рекомендуется как можно больше ограничивать доступ к данным, чтобы защитить их от нежелательного доступа извне (как для получения значения, так и для его изменения). Использование различных модификаторов гарантирует, что данные не будут искажены или изменены не надлежащим образом. Подобное сокрытие данных внутри некоторой области видимости называется инкапсуляцией.

Так, как правило, вместо непосредственного применения полей используют методы доступа. Например:

[Program_02](/src/Terms_Code/Program_02.java)

И затем вместо непосредственной работы с полями name и age в классе Person мы будем работать с методами, которые устанавливают и возвращают значения этих полей.

Методы setName, setAge и наподобие еще называют мьютейтерами (mutator), так как они изменяют значения поля.

А методы getName, getAge и наподобие называют аксессерами (accessor), так как с их помощью мы получаем значение поля.

Причем в эти методы мы можем вложить дополнительную логику. Например, в данном случае при изменении возраста производится проверка, насколько соответствует новое значение допустимому диапазону.