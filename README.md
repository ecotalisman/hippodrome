# Testing and Logging
# Module 3 Project #2 JavaRush University

**Module 3. Java Professional**  
**Level 5, Lecture 7**

This program is a simulation of a hippodrome.  
To begin, as in the previous project, fork from the repository: [https://github.com/pavlo-plynko/hippodrome](https://github.com/pavlo-plynko/hippodrome) and clone this fork.

Your task is to add testing and logging.

## List of Required Tests

Each item from the following list should be implemented as a test method. When naming test methods, try to be concise but at the same time think about how to make it roughly understandable what is being tested in them. For example, compare these two test results:

<p align="center">
  <img src="https://github.com/ecotalisman/hippodrome/assets/67708040/02103b76-d6b0-4114-bb18-f77705b1e7e3">
</p>

In the second case, it is harder to understand which tests did not pass, and you will need to look at the logs.

### 1. Class Horse:
- **Constructor**:
  - Check that passing null as the first parameter to the constructor throws an IllegalArgumentException. Use the `assertThrows` method for this.
  - Check that passing null as the first parameter to the constructor will contain the message "Name cannot be null.". To do this, get the message from the caught exception and use the `assertEquals` method.
  - Check that passing an empty string or a string containing only whitespace characters (space, tab, etc.) to the constructor throws an IllegalArgumentException. To check with different variants of whitespace characters, make the test parameterized.
  - Check that passing an empty string or a string containing only whitespace characters (space, tab, etc.) to the constructor will contain the message "Name cannot be blank.".
  - Check that passing a negative number as the second parameter to the constructor throws an IllegalArgumentException.
  - Check that passing a negative number as the second parameter to the constructor will contain the message "Speed cannot be negative.".
  - Check that passing a negative number as the third parameter to the constructor throws an IllegalArgumentException.
  - Check that passing a negative number as the third parameter to the constructor will contain the message "Distance cannot be negative.".
- **getName method**:
  - Check that the method returns the string passed as the first parameter to the constructor.
- **getSpeed method**:
  - Check that the method returns the number passed as the second parameter to the constructor.
- **getDistance method**:
  - Check that the method returns the number passed as the third parameter to the constructor.
  - Check if the method returns zero if the object is created using a constructor with two parameters.
- **move method**:
  - Check that the method internally calls the `getRandomDouble` method with parameters 0.2 and 0.9. For this, use `MockedStatic` and its `verify` method.
  - Check that the method assigns a value to the distance calculated by the formula: distance + speed * getRandomDouble(0.2, 0.9). For this, mock `getRandomDouble` to return specific values that need to be set using parameterized test.

## 2. Hippodrome Class:
### Constructor
- Verify that passing `null` to the constructor throws an `IllegalArgumentException`.
- Ensure that when passing `null` to the constructor, the exception message reads "Horses cannot be null.".
- Check that when passing an empty list to the constructor, an `IllegalArgumentException` is thrown.
- Ensure that when passing an empty list to the constructor, the exception message reads "Horses cannot be empty.".

### getHorses Method
- Ensure the method returns a list containing the same objects in the same order as the list passed to the constructor. When creating a Hippodrome object, pass a list of 30 distinct horses to the constructor.

### move Method
- Verify the method invokes the `move` method on all horses. When creating a Hippodrome object, pass a list of 50 horse mocks to the constructor and utilize the `verify` method.

### getWinner Method
- Ensure the method returns the horse with the highest `distance` value.

## 3. Main Class:
### main Method
- Ensure the method does not run longer than 22 seconds. Use the `Timeout` annotation for this. After writing this test, disable it (use the `Disabled` annotation). This way, it won't consume time during the execution of all tests, but can be manually triggered if needed.

## Logging Requirements:
### 1. Main Class:
- After creating a Hippodrome object, add a log entry like: `2022-05-31 17:05:26,152 INFO Main: Race start. Number of participants: 7`
- After displaying information about the winner, add a log entry like: `2022-05-31 17:05:46,963 INFO Main: Race end. Winner: Cherry`

### 2. Hippodrome Class:
- If `null` was passed to the constructor, before throwing the exception, log: `2022-05-31 17:29:30,029 ERROR Hippodrome: Horses list is null`
- If an empty list was passed to the constructor, before throwing the exception, log: `2022-05-31 17:30:41,074 ERROR Hippodrome: Horses list is empty`
- At the end of the constructor, log: `2022-05-31 17:05:26,152 DEBUG Hippodrome: Hippodrome created, number of horses [7]`

### 3. Horse Class:
- If `null` was passed as the name to the constructor, log before throwing the exception: `2022-05-31 17:34:59,483 ERROR Horse: Name is null`
- If an empty name was passed to the constructor, log before throwing the exception: `2022-05-31 17:36:44,196 ERROR Horse: Name is blank`
- If a negative speed was passed to the constructor, log before throwing the exception: `2022-05-31 17:40:27,267 ERROR Horse: Speed is negative`
- If a negative distance was passed to the constructor, log before throwing the exception: `2022-05-31 17:41:21,938 ERROR Horse: Distance is negative`
- At the end of the constructor, log: `2022-05-31 17:15:25,842 DEBUG Horse: Horse created, name [Lobster], speed [2.8]`

Logs should be written to the `hippodrome.log` file located in the project root under the `logs` directory. Every day, the file should be renamed following the pattern `hippodrome.2021-12-31.log` and a new `hippodrome.log` should be created. For this, use the `RollingFile` appender. Meanwhile, files older than 7 days should be deleted. Use the following structure:

```
<DefaultRolloverStrategy>
    <Delete …>
        <IfFileName …/>
        <IfLastModified …/>
    </Delete>
</DefaultRolloverStrategy>
```

Search online to find what to place in place of the ellipsis :) 

---
### 🇺🇦 Ukrainian version:
---
# Тестування та логування
# Модуль 3 Проєкт #2 JavaRush University

**Модуль 3. Java Professional**  
**Рівень 5, Лекція 7**

Ця програма – імітація іподрому.  
Для початку, як і в попередньому проєкті, зроби собі форк із репозиторію: [https://github.com/pavlo-plynko/hippodrome](https://github.com/pavlo-plynko/hippodrome) і склонуй цей форк.

Твоє завдання – додати тестування та логування.

## Список необхідних тестів
Кожен пункт із подальшого списку потрібно реалізувати як тестовий метод. Під час називання тестових методів намагайся бути лаконічним, але водночас подумай, як зробити так, щоб можна було приблизно зрозуміти, що саме в них тестується. Наприклад, порівняй ці два результати тестування:

<p align="center">
  <img src="https://github.com/ecotalisman/hippodrome/assets/67708040/02103b76-d6b0-4114-bb18-f77705b1e7e3">
</p>

> У другому випадку важче зрозуміти, які тести не пройшли, і тобі доведеться дивитися логи.

### 1. Клас Horse:

- **конструктор**
  - Перевірити, що при передачі до конструктора першим параметром null буде викинуто IllegalArgumentException.
  - Перевірити, що при передачі до конструктора першим параметром null виняток міститиме повідомлення "Name cannot be null.".
  - Перевірити, що при передачі до конструктора першим параметром порожнього рядка або рядка, що містить лише пробільні символи (пробіл, табуляція, тощо), буде викинуто IllegalArgumentException.
  - Перевірити, що при передачі до конструктора першим параметром порожнього рядка або рядка, що містить лише пробільні символи (пробіл, табуляція, тощо), виняток міститиме повідомлення "Name cannot be blank.".
  - Перевірити, що при передачі до конструктора другим параметром від'ємного числа, буде викинуто IllegalArgumentException;
  - Перевірити, що при передачі до конструктора другим параметром від'ємного числа, виняток міститиме повідомлення "Speed cannot be negative.";
  - Перевірити, що при передачі до конструктора третім параметром від'ємного числа, буде викинуто IllegalArgumentException;
  - Перевірити, що при передачі до конструктора третім параметром від'ємного числа, виняток міститиме повідомлення "Distance cannot be negative.";

- **метод getName**
  - Перевірити, що метод повертає рядок, який передавався першим параметром до конструктора.

- **метод getSpeed**
  - Перевірити, що метод повертає число, яке передалося другим параметром до конструктора.

- **метод getDistance**
  - Перевірити, що метод повертає число, яке передалося третім параметром конструктора.
  - Перевірити, чи метод повертає нуль, якщо об'єкт створено за допомогою конструктора з двома параметрами.

- **метод move**
  - Перевірити, що метод викликає всередині метод getRandomDouble параметрів 0.2 і 0.9. Для цього потрібно використовувати MockedStatic і його метод verify.
  - Перевірити, що метод присвоює дистанції значення, яке обчислюється за такою формулою: distance + speed * getRandomDouble(0.2, 0.9). Для цього потрібно замокати getRandomDouble, щоб він повертав певні значення, які треба встановити за допомогою параметризації тесту.

## 2. Клас Hippodrome:

### Конструктор:
- Перевірити, що при передачі до конструктора `null` буде викинуто `IllegalArgumentException`;
- Перевірити, що при передачі до конструктора `null` виняток міститиме повідомлення "Horses cannot be null.";
- Перевірити, що при передачі до конструктора порожнього списку буде викинуто `IllegalArgumentException`;
- Перевірити, що при передачі до конструктора порожнього списку виняток міститиме повідомлення "Horses cannot be empty.";

### метод `getHorses`:
- Перевірити, що метод повертає список, який містить ті ж об'єкти і в такій самій послідовності, що й список, який передався до конструктора. При створенні об'єкта Hippodrome передай до конструктора список із 30 різних коней;

### метод `move`:
- Перевірити, що метод викликає метод `move` у всіх коней. При створенні об'єкта Hippodrome передай до конструктора список із 50 моків коней та скористайся методом `verify`.

### метод `getWinner`:
- Перевірити, що метод повертає коня з найбільшим значенням `distance`.

## 3. Клас Main:

### метод `main`:
- Перевірити, що метод виконується не довше 22 секунд. Для цього скористайся анотацією `Timeout`. Після написання цього тесту, вимкни його (скористайся анотацією `Disabled`). Таким чином він не займатиме час під час запуску всіх тестів, а за необхідності його можна буде запустити вручну.

## Що потрібно логувати:

### 1. Клас Main:
- Після створення об'єкта іподрому, додати в лог запис типу: `2022-05-31 17:05:26,152 INFO Main: Початок стрибків. Кількість учасників: 7`
- Після виведення інформації про переможця, додати в лог запис типу: `2022-05-31 17:05:46,963 INFO Main: Закінчення стрибків. Переможець: Вишня`

### Клас Hippodrome:
- Якщо до конструктора передався `null`, то перед прокиданням виключення треба додати в лог запис типу:`2022-05-31 17:29:30,029 ERROR Hippodrome: Horses list is null`
- Якщо до конструктора передався порожній список, то перед прокиданням виключення треба додати в лог запис типу:`2022-05-31 17:30:41,074 ERROR Hippodrome: Horses list is empty`
- Наприкінці конструктора додати в лог запис типу:`2022-05-31 17:05:26,152 DEBUG Hippodrome: створення Hippodrome, коней [7]`

### 3. Клас Horse:
- Якщо конструктор замість імені передав `null`, перед прокиданням винятку треба додати в лог запис типу: `2022-05-31 17:34:59,483 ERROR Horse: Name is null`
- Якщо ім'я, що передалося до конструктора порожнє, перед прокиданням винятку треба додати в лог запис типу: `2022-05-31 17:36:44,196 ERROR Horse: Name is blank`
- Якщо швидкість, що передалася до конструктора менша за нуль, перед прокиданням винятку треба додати в лог запис типу: `2022-05-31 17:40:27,267 ERROR Horse: Speed is negative`
- Якщо дистанція, що передалася до конструктора менша за нуль, перед прокиданням винятку треба додати в лог запис типу: `2022-05-31 17:41:21,938 ERROR Horse: Distance is negative`
- Наприкінці конструктора додати в лог запис типу: `2022-05-31 17:15:25,842 DEBUG Horse: створення Horse, ім'я [Лобстер], швидкість [2.8]`

### Логи:
- Логи мають записуватися до файлу `hippodrome.log`, який розташовується в корені проєкту в папці `logs`.
- Кожен день файл має переназиватися за шаблоном у `hippodrome.2021-12-31.log` і замість нього повинен створюватися новий `hippodrome.log`. 
- Для цього використовуй апендер `RollingFile`.
- Водночас файли старше 7 днів мають видалятися. 
- Для цього можеш використовувати таку конструкцію:
```
<DefaultRolloverStrategy>
    <Delete …>
        <IfFileName …/>
        <IfLastModified …/>
    </Delete>
</DefaultRolloverStrategy>
```
Погугли, що треба вказати замість трьох крапок :)
