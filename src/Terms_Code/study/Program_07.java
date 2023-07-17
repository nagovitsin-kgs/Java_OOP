package Terms_Code.study;
// пакет java.util содержит еще множество классов.

// И чтобы не подключать по отдельности каждый класс, мы можем сразу подключить
// весь пакет:

// import java.util.*; // импорт всех классов из пакета java.util

import java.util.Scanner; // импорт класса Scanner

public class Program_07 {

    public static void main(String[] args) {
        // полный путь без импорта:
        // java.util.Scanner in = new java.util.Scanner(System.in);

        // c импортом, вызываем только класс Scaner:
        Scanner in = new Scanner(System.in);

    }
}
// Возможна ситуация, когда мы используем два класса с одним и тем же названием
// из двух разных пакетов, например, класс Date имеется и в пакете java.util, и
// в пакете java.sql. И если нам надо одновременно использовать два этих класса,
// то необходимо указывать полный путь к этим классам в пакете:

// java.util.Date utilDate = new java.util.Date();
// java.sql.Date sqlDate = new java.sql.Date();
