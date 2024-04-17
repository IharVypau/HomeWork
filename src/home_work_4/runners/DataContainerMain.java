package home_work_4.runners;

import home_work_4.DataContainer;
import home_work_4.utils.comparators.StringLenghtComparator;
import home_work_4.utils.comparators.NumberComparator;

import java.util.Comparator;

public class DataContainerMain {
    public static void main(String[] args) {
        /*
         * 1. Создать класс DataContainer у которого есть один дженерик (обобщение).
         * 2. Внутри DataContainer должно быть поле T[] data, внутренний массив, которое предназначено для хранения передаваемых объектов.
         * 3. Из-за особенностей дженериков в данном классе обязательно будет присутствовать один конструктор DataContainer(T[]).
         * */
        DataContainer<String> container1 = new DataContainer<>(new String[]{"i", "hello", "1", "Как домашка"});
        DataContainer<Integer> container2 = new DataContainer<>(new Integer[]{3, 2, 33, null, null, null});
        DataContainer<Integer> container3 = new DataContainer<>(new Integer[]{1, null, 3, null, null, 55});
        DataContainer<Integer> container4 = new DataContainer<>(new Integer[]{});

        /*
         * 4. В данном классе должен быть метод int add(T item) который добавляет данные во внутреннее поле data
         *    и возвращает номер позиции в которую были вставлены данные, начиная с 0.
         *   4.1 Если поле data не переполнено то данные нужно добавлять в первую позицию (ячейку) после последней заполненной позиции (ячейки).
         *       4.1.1 Пример: data = [1, 2, 3, null, null, null]. Вызвали add(777). Должно получиться data = [1, 2, 3, 777, null, null]. Метод add вернёт число 3.
         *       4.1.2 Пример: data = [1, 2, 3, null, null, null]. Вызвали add(null). Должно получиться data = [1, 2, 3, null, null, null]. Метод add вернёт число -1. -1 будет индикатором того что данный элемент в наш контейнер вставлять нельзя.
         *       4.1.3 Пример: data = [1, null, 3, null, null, null]. Вызвали add(777). Должно получиться data = [1, 777, 3, null, null, null]. Метод add вернёт число 1.
         *   4.2 В случае если поле data переполнено, нужно придумать механизм который будет расширять пространство для новых элементов.
         * */
        int idx1 = container1.add("31");
        int idx2 = container2.add(777);
        int idx3 = container3.add(777);
        int idx4 = container4.add(null);
        System.out.println(idx4);

        /*
         *   5. В данном классе должен быть метод T get(int index).
         * */
        int idx5 = container4.add(999);
        System.out.println(container4.get(idx5));
        System.out.println(container4);

        /*
         * 6. В данном классе должен быть метод T[] getItems(). Данный метод возвращает массив из поля data.
         * */
        String[] items = container1.getItems();

        /*
         * 7. Добавить метод boolean delete(int index) который будет удалять элемент из нашего поля data по индексу.
         *   7.1 Метод возвращает true если у нас получилось удалить данные.
         *   7.2 Метод возвращает false если нет такого индекса.
         *   7.3. Освободившуюся ячейку в поле data необходимо удалить полностью. Пустых элементов не должно быть.
         * */
        System.out.println(container3);
        System.out.println(container3.delete(idx3));
        System.out.println(container3.delete(5));
        System.out.println(container3);

        /*
         * 8. Добавить метод boolean delete(T item) который будет удалять элемент из нашего поля data.
         *   8.1 Метод возвращает false если передают null.
         *   8.2 Метод возвращает true если у нас получилось удалить данные.
         *   8.3 Метод возвращает false если нет такого элемента.
         *   8.4 Освободившуюся ячейку необходимо удалить полностью. Пустых элементов не должно быть.
         *
         * */

        System.out.println(container1);
        System.out.println(container1.delete((String) "hello"));
        System.out.println(container1);
        System.out.println(container1.delete((String) "bye"));

        /*
         * 9. Добавить НЕ СТАТИЧЕСКИЙ метод void sort(Comparator<.......> comparator).
         *
         * */
        DataContainer<Integer> container5 = new DataContainer<>(new Integer[]{3, 1, 3, 777});
        container5.sort(new NumberComparator());
        System.out.println(container5);

        /*
         * 10. Переопределить метод toString() в классе и выводить содержимое data без ячеек в которых хранится null.
         * */
        DataContainer<Integer> container6 = new DataContainer<>(new Integer[]{11, null, 5, null,});
        System.out.println(container6);

        /*
         * 11.* В DataContainer добавить СТАТИЧЕСКИЙ метод void sort(DataContainer<.............> container) с дженериком extends Comparable.
         * */
        DataContainer.sort(container6);
        System.out.println(container6);

        /*
         * 12.* В DataContainer добавить СТАТИЧЕСКИЙ метод void sort(DataContainer<.............> container, Comparator<.......> comparator)
         * который будет принимать объект DataContainer и реализацию интерфейса Comparator.
         * */
        //DataContainer.sort(container1, new StringLenghtComparator());
        DataContainer.sort(container1, (a, b) -> a.length() - b.length());
        //DataContainer.sort(container2, new NumberComparator());
        DataContainer.sort(container2, (a, b) -> a - b);

        System.out.println(container2);

        /*
         * 13.** Реализовать в DataContainer интерфейс Iterable
         * */
        for (String value : container1) {
            System.out.print(value + " ");
        }
    }
}
