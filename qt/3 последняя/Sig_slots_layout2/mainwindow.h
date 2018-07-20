#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QWidget>
#include<QPushButton>
#include<QHBoxLayout>
#include<QLabel>
#include<QLineEdit>
#include<QSpinBox>
#include<QSlider>
#include<QSignalMapper>
#include<QStackedLayout>
#include<QComboBox>


class mainWindow : public QWidget
{
    Q_OBJECT

    QHBoxLayout *mainLayout;
    QPushButton* btn;
    QLineEdit* edit ;
    QLabel* label;
    QSpinBox* spinBox;
    QSlider* slider;

    QPushButton *Horizontal;
    QPushButton *Vertical;

    QVBoxLayout *buttonsLayout;

    QHBoxLayout *horizontalLayout;
    QVBoxLayout *verticalLayout;
    QGridLayout *gridLayout;

QSignalMapper *signalMapper;

QPushButton *gridButton;

   QVBoxLayout* demoStackLayout;
     QStackedLayout* stackLayout;
     QPushButton *stackButton;

     QComboBox* comboBox;



signals:
void mySignal(int);


public slots:
void mySlot (QString str);
//void changeLayout(QLayout* pNewLayout);
void changeLayout(QObject *newLayout);


// void spinboxValueChanged(int value);
//      {
//        if (button)
//        {
//          button->clicked();
//        }
//      }


 public:
    mainWindow(QWidget *parent = 0);
    ~mainWindow();
};

#endif // MAINWINDOW_H
