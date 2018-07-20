#include "mypicture.h"
#include <QPalette>
#include <QPixmap>
#include <QBrush>
#include <QDebug>

MyPicture::MyPicture(QWidget *parent) : QWidget(parent)
{

//    QPalette p;
    QPixmap dog("WomanAndDog.jpg");
   // dog.load(":/MyImages/Images/WomenAndDog.jpg");

//    p.setBrush(QPalette::Active, QPalette::Window, QBrush(dog));
//    this->setPalette(p);  /Images_lab1/icon1.ico


}
