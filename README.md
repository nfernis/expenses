# Expenses Tracker

<!-- TREE START --><!-- TREE END -->
```
.
├── .github
│   └── workflows
│       └── update-readme.yml
├── .gitignore
├── README.md
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── expenses
│       │               ├── Main.java
│       │               ├── service
│       │               │   ├── BudgetForToday.java
│       │               │   └── DaysToSalary.java
│       │               ├── ui
│       │               │   └── MainWindow.java
│       │               └── utils
│       │                   ├── CustomLevel.java
│       │                   └── UIHelper.java
│       └── resources
│           └── icons
│               └── icon.png
└── tree.txt

14 directories, 12 files
```
Декомпозиция:

**База данных** 



**Рассчитать бюджет на день**
чек бокс Оплачены ли обязательные платежи:
квартира
коммуналка (если нет, то предполагаем, что будет среднее значение коммуналки)
интернет
я.музыка
долги 

берем переменную Сколько дней до зп и на нее делим всю сумму



