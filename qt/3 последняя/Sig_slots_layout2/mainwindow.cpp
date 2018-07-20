#include "mainwindow.h"
#include<QDebug>
#include<QPushButton>
#include<QMessageBox>
#include<QHBoxLayout>
#include<QLabel>
#include<QLineEdit>
#include<QSpinBox>
#include<QSlider>
#include<QComboBox>
#include<QSignalMapper>
#include<QStackedLayout>

void mainWindow::mySlot(QString str)
{
    int n = str.toInt();
    emit mySignal(n);

}


mainWindow::mainWindow(QWidget *parent)
    : QWidget(parent)
{

     QLineEdit* edit = new QLineEdit(this);
     edit->setMinimumSize(100,50);
     edit->setMaxLength(100);
     edit->setValidator(new QIntValidator(0, 70, edit));

     QLabel* label = new QLabel(this);
     label->setMinimumSize(100,50);
     label = new QLabel("Not set", this);
     label->setFrameStyle(QFrame::Box);
     label->setMinimumWidth(30);
     label->setAlignment(Qt::AlignCenter);

     QSpinBox* spinBox = new QSpinBox(this);
     spinBox->setMaximumSize(100, 50);
     spinBox->setMaximum(50);

     //QSlider* slider = new QSlider(this);
     slider = new QSlider(Qt::Horizontal, this);
     slider->setMaximum(70);
     slider->setMaximumHeight(70);
     slider->setTickPosition(QSlider::TicksAbove);
     slider->setTickInterval(10);

     comboBox = new QComboBox(this);
     comboBox->addItem("SpinBox");
     comboBox->addItem("Slider");
     comboBox->addItem("LineEdit");
     comboBox->hide();

//горизонтальная компановка
     horizontalLayout = new QHBoxLayout();
     horizontalLayout->addWidget(spinBox, 0, Qt::AlignHCenter | Qt::AlignVCenter);
     horizontalLayout->addWidget(slider);
     horizontalLayout->addWidget(label, 0, Qt::AlignHCenter | Qt::AlignVCenter);
     horizontalLayout->addWidget(edit, 0, Qt::AlignHCenter | Qt::AlignVCenter);

//вертикальная компоновка
     verticalLayout = new QVBoxLayout();
     verticalLayout->addWidget(spinBox, 0, Qt::AlignHCenter | Qt::AlignVCenter);
     verticalLayout->addWidget(slider);
     verticalLayout->addWidget(label, 0, Qt::AlignHCenter | Qt::AlignVCenter);
     verticalLayout->addWidget(edit, 0, Qt::AlignHCenter | Qt::AlignVCenter);

//компоновка с помощью таблицы

     gridLayout = new QGridLayout();
     gridLayout->addWidget(spinBox, 0, 0, 1, 1, Qt::AlignHCenter | Qt::AlignVCenter);
     gridLayout->addWidget(slider, 0, 1, 1, 1);
     gridLayout->addWidget(edit, 1, 0, 1, 1,  Qt::AlignHCenter | Qt::AlignVCenter);
     gridLayout->addWidget(label, 1, 1, 1, 1, Qt::AlignHCenter | Qt::AlignVCenter);

//кнопочная компановка
      Horizontal= new QPushButton(("Horizontal"), this);
      Vertical = new QPushButton(("Vertical"), this);
      gridButton = new QPushButton(tr("Grid"), this);
      stackButton = new QPushButton(tr("Stack"), this);
      buttonsLayout = new QVBoxLayout();
      buttonsLayout->addWidget(Horizontal);
      buttonsLayout->addWidget(Vertical);
      buttonsLayout->addWidget(gridButton);
      buttonsLayout->addWidget(stackButton);
// стековая компоновка

      stackLayout = new QStackedLayout();
      stackLayout->addWidget(edit);
      stackLayout->addWidget(spinBox);
      stackLayout->addWidget(slider);
      stackLayout->setStackingMode(QStackedLayout::StackAll);

      demoStackLayout = new QVBoxLayout();
      demoStackLayout->addWidget(comboBox, 0, Qt::AlignHCenter);
      demoStackLayout->addWidget(label, 0, Qt::AlignHCenter);
      demoStackLayout->addLayout(stackLayout);

//QObject::connect(comboBox, static_cast<void(QComboBox::*)(int)>(&QComboBox::activated), stackLayout, &QStackedLayout::setCurrentIndex);

// создаем сигнал

signalMapper = new QSignalMapper(this);


//главная компановка
mainLayout = new QHBoxLayout(this);
mainLayout->addLayout(horizontalLayout);
mainLayout->addLayout(buttonsLayout);
//mainLayout->addLayout(gridButton);
//mainLayout->addLayout(stackButton);


// выход
      QPushButton* btn = new QPushButton( "Exit", this);
      mainLayout->addWidget(btn);


//  btn->move(100, 100);
//  btn->show();
      connect(btn, SIGNAL( clicked() ), this, SLOT( close() ) );

      //Сигналы и слоты

// slider, spinBox
      connect(slider, SIGNAL(valueChanged(int)), spinBox, SLOT(setValue(int)));
// spinBox, slider
       connect(spinBox, SIGNAL(valueChanged(int)), slider, SLOT(setValue(int)));
//spinBox, остальные
      connect(btn, SIGNAL(clicked(bool)), this, SLOT(close()));
// edit, spinBox//12
      connect(edit, SIGNAL(textChanged(QString)), this,
              SLOT(mySlot(QString)));
      connect(this, SIGNAL(valueChanged(int)), spinBox, SLOT(setValue(int)));
// spinBox, lineEdit //12
      connect(spinBox, SIGNAL(valueChanged(QString)), edit,
          SLOT(setText(QString)));
// spinBox, label
      connect(spinBox, SIGNAL(valueChanged(int)), label, SLOT(setNum(int)));


//	соединим сигнал QLineEdit::textChanged(QString)со слотом mainWindow:: (QString)
// соединим сигнал mainWindow::mySignal(int)) со слотом QSpinBox:: setValue(int)

      connect(edit, SIGNAL(textChanged(QString)), this, SLOT(mySlot(QString)));

      connect(this, SIGNAL(mySignal(int)), spinBox, SLOT(setValue(int)));

      connect(Horizontal, SIGNAL(clicked(bool)), signalMapper,
              SLOT(map()));
      signalMapper->setMapping(Horizontal, horizontalLayout);
      connect(Vertical, SIGNAL(clicked(bool)), signalMapper,
              SLOT(map()));
      signalMapper->setMapping(Vertical, verticalLayout);
      connect(gridButton, SIGNAL(clicked(bool)), signalMapper,
              SLOT(map()));
      signalMapper->setMapping(gridButton, gridLayout);;
      connect(stackButton, SIGNAL(clicked(bool)), signalMapper,
              SLOT(map()));
      signalMapper->setMapping(stackButton, demoStackLayout);

      connect(signalMapper, SIGNAL(mapped(QObject*)), this,
              SLOT(changeLayout(QObject*)));

//      mainLayout=new QHBoxLayout(this);
//      mainLayout->addLayout(hLayout);
//      mainLayout->addWidget(btn);
//      setLayout(mainLayout);

//      edit=new QLineEdit(this);
//      label=new QLabel(this);
//      spinBox = new QSpinBox(this);
//      slider = new QSlider(this);

//      hLayout=new QHBoxLayout();
//      hLayout->addWidget(edit);
//      hLayout->addWidget(label);
//      hLayout->addWidget(spinBox);
//      hLayout->addWidget(slider);
//      mainLayout=new QHBoxLayout();
//      mainLayout->addLayout(hLayout);
//      mainLayout->addWidget(btn);

spinBox->setRange(0, 100);
//setLayout(hLayout);

//QLayout::setMargin(int)

// this->layout()->setMargin(100);
 //this->layout()->setSpacing(100);

//void QSpinBox::setRange ( int minimum, int maximum )
//this->spinBox()->setRange(0,99);


}

void mainWindow::changeLayout(QObject *newLayout)
{
    if(newLayout == demoStackLayout)
    {
        comboBox->setVisible(true);

        for(int i = 0; i < stackLayout->count(); ++i)
            stackLayout->itemAt(i)->widget()->hide();

        stackLayout->currentWidget()->show();
        stackLayout->setStackingMode(QStackedLayout::StackOne);
    }
    else
    {
        comboBox->setVisible(false);
        stackLayout->setStackingMode(QStackedLayout::StackAll);
    }

    QLayoutItem *oldLayout = mainLayout->itemAt(0);
    mainLayout->removeItem(oldLayout);

    mainLayout->insertLayout(0, static_cast<QLayout *>(newLayout));

}







//void MainWidget::changeLayout(QObject *newLayout)

//  {  if(newLayout == Vertical)
//    {
//        comboBox->setVisible(true);

//        for(int i = 0; i < demoStackLayout->count(); ++i)
//            demoStackLayout->itemAt(i)->widget()->hide();

//        demoStackLayout->currentWindow()->show();
//        demoStackLayout->setStackingMode(QStackedLayout::StackOne);
//    }
//    else
//    {
//        comboBox->setVisible(false);
//        demoStackLayout->setStackingMode(QStackedLayout::StackAll);
//    }

//    QLayoutItem *oldLayout = mainLayout->itemAt(0);
//    mainLayout->removeItem(oldLayout);
//    mainLayout->insertLayout(0, newLayout);
//  }

// {
//    QLayoutItem* pCurLayout= mainLayout->itemAt(0);
//    if (pNewLayout != pCurLayout)
//    {
//        if (pNewLayout == demoStackLayout)
//        {
//            comboBox->setVisible(true);
//            spinBox->hide(); edit->hide(); slider->hide();
//            stackLayout->currentWidget()->show();
//            stackLayout->setStackingMode(QStackedLayout::StackOne);
//        }
//        else
//        {
//            comboBox->setVisible(false);
//            stackLayout->setStackingMode(QStackedLayout::StackAll);
//        }
//        mainLayout->removeItem(pCurLayout);
//        mainLayout->insertLayout(0, pNewLayout);
//    } }


mainWindow::~mainWindow()
{
   // mainLayout->removeItem(mainLayout->itemAt(0));

    layout()->disconnect();
    delete horizontalLayout;
    delete verticalLayout;
    delete gridLayout;
    delete demoStackLayout;
}
