#include "spider.h"
#include <QDebug>
#include <QIcon>
#include <QPalette>
#include <QPixmap>
#include <QBrush>
#include <QApplication>
#include <QDesktopWidget>
#include <QBitmap>
#include <QCursor>
#include <QColorDialog>
#include <QColor>
#include <QFileDialog>
#include<QTranslator>






SpiderWidget::SpiderWidget(QWidget *parent)  //заготовки для реализации конструктора и деструктора
    : QWidget(parent)
{


        qDebug()<<this->windowFlags();

    Qt::WindowFlags flags=Qt::Window;
    flags|=Qt::WindowStaysOnTopHint;
    flags|=Qt::CustomizeWindowHint;
    flags|=Qt::WindowTitleHint;
    flags|=Qt::WindowMinimizeButtonHint;
    flags|=Qt::WindowMaximizeButtonHint;
    flags|=Qt::WindowCloseButtonHint;
    this->setWindowFlags(flags);


 setWindowTitle(QObject::tr("Spider"));
 setWindowIcon(QIcon("icon1.ico"));

 QPalette p;
 //p.setColor(QPalette::Window,QColor(255,0,0));//Qt::red
 p.setColor(QPalette::Active,QPalette::Window,QColor(255,0,0));//Qt::red
 //p.setColor(QPalette::Inactive,QPalette::Window,Qt::green);//Qt::red
 QBrush brush(Qt::green,Qt::CrossPattern);
 p.setBrush(QPalette::Inactive,QPalette::Window,brush);//Qt::red
 this->setPalette(p);
QPixmap dog("WomanAndDog.jpg");

p.setBrush(QPalette::Active, QPalette::Window, QBrush(dog));
this->setPalette(p);



 setGeometry(400, 400, 600, 200);

setMaximumSize(600, 600);
setMinimumSize(500, 500);

setFixedHeight(600);
setFixedSize(500,500);
setFixedWidth(500);

resize(dog.size());



QColor col1 = QColorDialog::getColor();
if (col1.isValid()) p.setColor(QPalette::Active,QPalette::Window, col1);

QString filename = QFileDialog::getOpenFileName(0,"Open Dialog", ".", "*.jpg" );

QBrush b()

p.setBrush();

qDebug() << "filename: " << filename;


}

void SpiderWidget::changeWindowState()
{

}

void SpiderWidget::setCursorMouse()
{
    qDebug() << __func__;
    QPixmap pix("./Images_lab1/icon1.ico");
    pix.setMask(QBitmap("./Images_lab1/icon1.ico"));
    QCursor cur(pix);
    this->setCursor(cur);
}

void SpiderWidget::moveEvent(QMoveEvent *event)
{
    Q_UNUSED(event);
    static int cnt = 0;
    qDebug() << __func__ << ": " << cnt;
    ++cnt;
}







// *.pro файл





