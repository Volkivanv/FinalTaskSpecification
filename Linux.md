## Работа в Linux
### Операционные системы и виртуализация (Linux)

1. #### Использование команды cat в Linux
    - Создать два текстовых файла: "Pets"(Домашние животные) и "Pack animals"(вьючные животные), используя команду `cat` в терминале Linux. В первом файле перечислить собак, кошек и хомяков. Во втором — лошадей, верблюдов и ослов.
```zsh
 ┏━[22:51:47]  
 ┃ /home/ivan
 ┗━➤  mkdir finalDZ
 ┏━[23:03:38]  
 ┃ /home/ivan
 ┗━➤  cat>Pets.txt 
Fido, Dog, 2020-01-01, (sit,stay,fetch)
Whiskers, Cat, 2019-05-15, (sit,pounce)         
Hammy,Hamster,2021-03-10, (roll,hide)
Buddy,Dog,2018-12-10, (sit,paw,bark)
Smudge,cat,2020-02-20, (sit,pounce,scratch)
Peanut,Hamster,2021-08-01, (roll,spin)
Bella,Dog,2019-11-11, (sit,stay,roll)     
Oliver,Cat,2020-06-30, (meow,scratch,jump)
 ┏━[23:20:00]  
 ┃ /home/ivan
 ┗━➤  cat>Pack_animals.txt
Thunder, Horse, 2015-07-21, (trot,canter,gallop)
Sandy, Camel, 2016-11-03, (walk,carry load)
Eeyore, Donkey, 2017-09-18, (walk,carry load,bray)
Storm, Horse, 2014-05-05, (trot,canter)
Dune, Camel, 2018-12-12, (walk, sit)
Burro, Donkey, 2019-01-23, (walk, bray,kick)
Blaze, Horse, 2016-02-29, (trot,jump,gallop)
Sahara, Camel, 2015-08-14, (walk,run)
```

 - Объединить содержимое этих двух файлов в один и просмотреть его содержимое.
 ```zsh
 ┏━[23:29:37]  
 ┃ /home/ivan
 ┗━➤  cat Pets.txt Pack_animals.txt > Human_Friends.txt
 ┏━[23:36:34]  
 ┃ /home/ivan
 ┗━➤  cat Human_Friends.txt
Fido, Dog, 2020-01-01, (sit,stay,fetch)
Whiskers, Cat, 2019-05-15, (sit,pounce)
Hammy,Hamster,2021-03-10, (roll,hide)
Buddy,Dog,2018-12-10, (sit,paw,bark)
Smudge,cat,2020-02-20, (sit,pounce,scratch)
Peanut,Hamster,2021-08-01, (roll,spin)
Bella,Dog,2019-11-11, (sit,stay,roll)
Thunder, Horse, 2015-07-21, (trot,canter,gallop)
Sandy, Camel, 2016-11-03, (walk,carry load)
Eeyore, Donkey, 2017-09-18, (walk,carry load,bray)
Storm, Horse, 2014-05-05, (trot,canter)
Dune, Camel, 2018-12-12, (walk, sit)
Burro, Donkey, 2019-01-23, (walk, bray,kick)
Blaze, Horse, 2016-02-29, (trot,jump,gallop)
 ```
 - Переименовать получившийся файл в "Human Friends".
 ```zsh
 ┏━[23:36:44]  
 ┃ /home/ivan
 ┗━➤  mv Human_Friends.txt HumanFriends.txt
 ┏━[23:39:26]  
 ┃ /home/ivan
 ┗━➤  ls
 DZ4                Pack_animals.txt   shell.sh   Документы      'Рабочий стол'
 DZ5                Pets.txt           snap       Загрузки        Шаблоны
 finalDZ            seminar_4          tmp        Изображения
 HumanFriends.txt   server             while.sh   Музыка
 Pack               shared             Видео      Общедоступные
 ```

2. #### Работа с директориями в Linux

