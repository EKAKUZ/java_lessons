# Stream API
Предоставляет набор методов для работы с данными, как с потоком. Позволяет представить различные наборы данных в виде потока, а далее: сортировать их, фильтровать, осуществлять поиск по различным критериям и т.д., кроме этого позволяет создавать новые потоки, создавать коллекции и мапы из текущего потока данных.

### Особенности работы со Stream API:
1. Stream никогда НЕ ХРАНИТ ДАННЫЕ
2. Для сохранения данных из Stream нужно использовать специальные методы.
3. Stream никогда НЕ ИЗМЕНЯЕТ ИСТОЧНИК (коллекцию, массив и тд), из которого он создан, все преобразования происходят только в потоках.
4. В своей работе методы stream используют лямбда выражения.

### Для работы с потоками данных необходимо:
1. Получить данные в виде потока - объект типа Stream
2. Выполнить **промежуточные операции** с потоком данных (промежуточные операции обрабатывают данные и возвращают Stream объект)
3. Выполнить **терминальную (конечную) операцию** (терминальная операция обрабатывает данные и завершает работу потока) **Без терминальной операции промежуточные операции не начнут выполняться!!!**

`Например, получили объект stream, далее выполняем промежуточные операции
stream.операция1() - вернет преобразованный объект stream
.операция2() - вернет преобразованный объект stream
.операция3()  - вернет преобразованный объект stream
.терминальнаяОперация(); - запускает промежуточные операции, данные обрабатываются, стрим закрывается`
### Методы получения Stream:
1. из коллекций collection.stream();
2. из массива Arrays.stream(arr);
3. из файла Files.lines(path_to_file);
4. из строки string.chars();
5. используя builder Stream.builder().add(obj1).add(obj2).add(objN).build();
6. из набора данных Stream.of(1, 4, 7);
### Числовые потоки:
1. IntStream intStream = IntStream.range(12, 100);
2. LongStream longStream = LongStream.builder().add(2).add(23).add(11).build();
3. DoubleStream doubleStream = DoubleStream.of(2.5, 12,8);
### Конвейерные методы для выполнения промежуточных операций:
1. filter(Predicate<? super T> predicate) - возвращает поток (Stream) с теми объектами, которые удовлетворяют условию;
2. map(Function<? super T, ? extends R> mapper) - возвращает поток (Stream), состоящий из обработанных функцией объектов;
3. limit(long maxSize) - возвращает поток (Stream), состоящий из объектов не превышающих maxSize;
4. skip(long n) - пропускает n первых элементов, возвращает поток (Stream), состоящий из оставшихся элементов (или пустой Stream);
5. distinct() - возвращает поток (Stream), состоящий из уникальных объектов (для сравнения использует метод equals объектов);
6. sorted() возвращает поток (Stream) отсортированных объектов;
7. sorted(Comparator<? super T> comparator) - возвращает поток (Stream) отсортированных объектов;
8. peek(Consumer<? super T> action) - возвращает поток (Stream), где каждый элемент обработан action;
9. mapToInt(ToIntFunction<? super T> mapper), mapToDouble(ToDoubleFunction<? super T> mapper), mapToLong(ToLongFunction<? super T> mapper) - аналог метода map, но возвращают числовой поток (Stream);
10. flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) - похож на метод map, но используется для выравнивания. Элементы отдельных потоков объединяет в общий стрим;
11. flatMapToInt(Function<? super T, ? extends IntStream> mapper), flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper), flatMapToLong(Function<? super T, ? extends LongStream> mapper) - аналог метода flatMap, но возвращают числовой поток (Stream).

`map и flatMap
String[][] strings = {
{"45", "78", "-90", "0", "1"},
{"441", "14", "28"},
{"122", "-6", "10", "50"},
};`

`String[][] s = Arrays.stream(strings)
.map(arr -> Arrays.stream(arr).distinct().sorted().toArray(String[]::new))
.toArray(String[][]::new); // [[-90, 0, 1, 45, 78], [14, 28, 441], [-6, 10, 122, 50]]`

`String[] s2 = Arrays.stream(strings)
.flatMap(arr -> Arrays.stream(arr).distinct().sorted())
.toArray(String[]::new); // [-90, 0, 1, 45, 78, 14, 28, 441, -6, 10, 122, 50]`
### Терминальные методы для выполнения конечных операций:
1. forEach(Consumer<? super T> action) применяет переданный метод (action) к каждому объекту потока (Stream), порядок обработки при параллельном выполнении не гарантируется;
2. forEachOrdered(Consumer<? super T> action) применяет переданный метод (action) к каждому объекту потока (Stream), порядок обработки при параллельном выполнении гарантируется;
3. anyMatch(Predicate<? super T> predicate) - возвращает true, если хотя бы один элемент потока соответствует условию;
4. allMatch(Predicate<? super T> predicate) - возвращает true, если все элементы потока соответствуют условию;
5. noneMatch(Predicate<? super T> predicate) - возвращает true, если ни один элемент потока соответствует условию;
6. findFirst() - возвращает первый элемент потока в Optional контейнере;
7. findAny() - возвращает случайный элемент потока в Optional контейнере;
8. min(Comparator<? super T> comparator) - возвращает минимальный элемент в Optional контейнере;
9. max(Comparator<? super T> comparator) - возвращает максимальный элемент в Optional контейнере;
10. count() - возвращает количество элементов в потоке (Stream);
11. Object[] toArray() - возвращает массив из значений потока (Stream);
12. A[] toArray(IntFunction<A[]> generator) - обычно принимает на вход ссылку на конструктор массива (например, Course[]::new для создания массива из экземпляров Course), возвращает массив из значений потока (Stream);
13. collect(Collector<? super T, A, R> collector) - представление результатов в виде коллекций и других структур данных;
14. sum() - возвращает сумму всех элементов числового потока (Stream);
15. average() - возвращает среднее арифметическое всех элементов числового потока (Stream);
16. parallel() - возвращает параллельный поток (Stream), если поток уже параллельный, то может вернуть самого себя;
17. sequential() - возвращает последовательный поток (Stream), если поток уже последовательный, то может вернуть самого себя;

`collection.stream(). // последовательные операции
.parallel()      // параллельные операции
.sequential()    // последовательные операции`
### Методы класса Collectors:
1. `toList(), toCollection(), toSet()` - возвращают экземпляр Collector для представления потока в виде списка, коллекции или множества
2. `toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)` - возвращают экземпляр Collector для представления потока в виде мапы, где **keyMapper** - функция генерации ключей, **valueMapper** - функция генерации значений, **mergeFunction** - способ решения коллизий при одинаковых ключах;
4. `averagingInt(ToIntFunction<? super T> mapper), averagingLong(ToLongFunction<? super T> mapper), averagingDouble(ToDoubleFunction<? super T> mapper)` - возвращают экземпляр Collector, позволяющий вычислять средние арифметические значения, основываясь на элементах потока;
5. `summingInt(ToIntFunction<? super T> mapper), summingLong(ToLongFunction<? super T> mapper), summingDouble(ToDoubleFunction<? super T> mapper)` - возвращают экземпляр Collector, позволяющий вычислять сумму значений, основываясь на элементах потока;
6. `summarizingInt(ToIntFunction<? super T> mapper), summarizingLong(ToLongFunction<? super T> mapper), summarizingDouble(ToDoubleFunction<? super T> mapper)` - возвращают экземпляр SummaryStatistics с разными агрегатными значениями, основываясь на элементах потока;
7. `partitioningBy(Predicate<? super T> predicate)` - возвращают экземпляр Collector, позволяющий разделить коллекцию на две части по соответствию условию и преобразовать их в Map<Boolean, List>
8. `groupingBy(Function<? super T,? extends K> classifier)` - возвращают экземпляр Collector, позволяющий разделить коллекцию и вернуть Map<N, List>, где T - тип последнего стрима, N - значение разделителя.