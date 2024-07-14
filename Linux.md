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

- Создать новую директорию и переместить туда файл "Human Friends".

```zsh
 ┏━[20:31:21]  
 ┃ /home/ivan
 ┗━➤  ll
итого 80K
drwxrwxr-x 4 ivan ivan 4,0K мая  5 22:42  DZ4
drwxrwxr-x 4 ivan ivan 4,0K мая  7 22:58  DZ5
-rw-rw-r-- 1 ivan ivan  587 июл 11 23:34  HumanFriends.txt
-rw-rw-r-- 1 ivan ivan    0 июл 11 23:20  Pack
-rw-rw-r-- 1 ivan ivan  311 июл 11 23:28  Pack_animals.txt
-rw-rw-r-- 1 ivan ivan  276 июл 11 23:12  Pets.txt
drwxrwxr-x 7 ivan ivan 4,0K апр 22 21:24  seminar_4
drwxrwxr-x 2 ivan ivan 4,0K мар 29 21:47  server
drwxr-x--- 2 root root 4,0K мар 28 23:42  shared
-rwxrwxr-x 1 ivan ivan  242 мая  3 01:38  shell.sh
drwx------ 6 ivan ivan 4,0K апр 18 08:11  snap
drwxr-xr-x 2 root root 4,0K мая  3 00:47  tmp
-rwxrwxr-x 1 ivan ivan   42 апр 17 22:57  while.sh
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56  Видео
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56  Документы
drwxr-xr-x 2 ivan ivan 4,0K мая  6 00:39  Загрузки
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56  Изображения
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56  Музыка
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56  Общедоступные
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56 'Рабочий стол'
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56  Шаблоны
 ┏━[20:31:24]  
 ┃ /home/ivan
 ┗━➤  mkdir finalDZ                        
 ┏━[20:43:08]  
 ┃ /home/ivan
 ┗━➤  mv HumanFriends.txt finalDZ          
 ┏━[20:44:33]  
 ┃ /home/ivan
 ┗━➤  ll
итого 80K
drwxrwxr-x 4 ivan ivan 4,0K мая  5 22:42  DZ4
drwxrwxr-x 4 ivan ivan 4,0K мая  7 22:58  DZ5
drwxrwxr-x 2 ivan ivan 4,0K июл 14 20:44  finalDZ
-rw-rw-r-- 1 ivan ivan    0 июл 11 23:20  Pack
-rw-rw-r-- 1 ivan ivan  311 июл 11 23:28  Pack_animals.txt
-rw-rw-r-- 1 ivan ivan  276 июл 11 23:12  Pets.txt
drwxrwxr-x 7 ivan ivan 4,0K апр 22 21:24  seminar_4
drwxrwxr-x 2 ivan ivan 4,0K мар 29 21:47  server
drwxr-x--- 2 root root 4,0K мар 28 23:42  shared
-rwxrwxr-x 1 ivan ivan  242 мая  3 01:38  shell.sh
drwx------ 6 ivan ivan 4,0K апр 18 08:11  snap
drwxr-xr-x 2 root root 4,0K мая  3 00:47  tmp
-rwxrwxr-x 1 ivan ivan   42 апр 17 22:57  while.sh
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56  Видео
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56  Документы
drwxr-xr-x 2 ivan ivan 4,0K мая  6 00:39  Загрузки
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56  Изображения
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56  Музыка
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56  Общедоступные
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56 'Рабочий стол'
drwxr-xr-x 2 ivan ivan 4,0K мар 28 22:56  Шаблоны
 ┏━[20:44:53]  
 ┃ /home/ivan
 ┗━➤  cd finalDZ           
 ┏━[20:45:14]  
 ┃ /home/ivan/finalDZ
 ┗━➤  ll
итого 4,0K
-rw-rw-r-- 1 ivan ivan 587 июл 11 23:34 HumanFriends.txt
```

3. #### Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”
   - Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.
```zsh
 ┏━[00:11:26]  
 ┃ /home/ivan/finalDZ
 ┗━➤  sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.32-1_all.deb
 ┏━[00:12:21]  
 ┃ /home/ivan/finalDZ
 ┗━➤  sudo dpkg -i mysql-apt-config_0.8.32-1_all.deb
 ┏━[00:16:28]  
 ┃ /home/ivan/finalDZ
 ┗━➤  sudo apt-get update 
 ┏━[00:18:45]  
 ┃ /home/ivan/finalDZ
 ┗━➤  sudo apt-get install mysql-shell
```

4. #### Управление deb-пакетами
   - Установить и затем удалить deb-пакет, используя команду `dpkg`.
```zsh
 ┏━[00:47:48]  
 ┃ /home/ivan/finalDZ
 ┗━➤  wget https://zoom.us/client/latest/zoom_amd64.deb
 ┏━[00:49:10]  
 ┃ /home/ivan/finalDZ
 ┗━➤  sudo dpkg -i zoom_amd64.deb

```
![img.png](img.png)
```zsh
┏━[00:49:32]  
┃ /home/ivan/finalDZ
┗━➤  sudo dpkg -r zoom
(Чтение базы данных … на данный момент установлено 237983 файла и каталога.)
Удаляется zoom (6.1.1.443) …
run post uninstall script, action is remove ...
Обрабатываются триггеры для shared-mime-info (2.1-2) …
Обрабатываются триггеры для mailcap (3.70+nmu1ubuntu1) …
Обрабатываются триггеры для gnome-menus (3.36.0-1ubuntu3) …
Обрабатываются триггеры для desktop-file-utils (0.26-1ubuntu3) …
```