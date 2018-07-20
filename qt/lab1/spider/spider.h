#ifndef SPIDER_H
#define SPIDER_H

#include <QWidget>

class SpiderWidget : public QWidget  //наследует от класса Qt - QWidget
{
    Q_OBJECT //макрос, необходимый для поддержки механизма сигналов/слотов
    //(в частности в данной работе позволяет использовать функцию tr(), а в дальнейшем и connect())

public:
    SpiderWidget(QWidget *parent = nullptr); //у главного окна приложения родителя нет (по умолчанию родительским окном является desktop)

    ~SpiderWidget() {}

private:
    void customizeWindowFlags();

public slots:
    void changeWindowState();

   void setCursorMouse();

    // QWidget interface
protected:
    virtual void moveEvent(QMoveEvent *event);

};



#endif // SPIDER_H
