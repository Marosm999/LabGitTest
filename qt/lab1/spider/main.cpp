#include "spider.h"
#include <QApplication>
#include <QTranslator>

#include <QDebug>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);//создание объекта, инкапсулирующего функциональность приложения.

    QTranslator translator; 		//создаем переводчик
    qDebug() << "isLoad: " << translator.load("spider_ru.qm");
    QApplication::installTranslator(&translator);

    QTranslator translator2; 		//создаем переводчик
    qDebug() << "isLoad: " << translator2.load(QLocale::system(),"qtbase", "_");
    QApplication::installTranslator(&translator2);



    SpiderWidget w;  //создание объекта для поддержки главного окна приложения.
    w.show(); //отобразить главное окно, иначе по умолчанию оно останется невидимым
//    w.showNormal();
//    w.windowTitle();
//    w.setWindowTitle("Hello!");
//    w.palette();



//    QTranslator t;
//    t.load("spider_ru.qm");
//    QApplication::installTranslator(t);




    return a.exec(); //запуск цикла обработки сообщений, выход из которого осуществляется только по желанию пользователя.
}
