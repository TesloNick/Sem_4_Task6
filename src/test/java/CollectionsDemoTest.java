import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsDemoTest {

    @Test
    public void checkSymbol() {
        // Метод возвращает количество строк входного списка, у которых первый символ совпадает с заданным.
        char symbol = 'a';
        List<String> str = List.of("abc", "", "alliance", "xyz");
        assertEquals(2, CollectionsDemo.checkSymbol(str, symbol));
    }

    @Test
    public void checkSurname() {
        // Метод возвращает список однофамильцев заданного человека среди людей из входного списка.

        List<Human> humanList = new ArrayList<>();

        Human human1 = new Human("Иванов", "Иван", "Иванович", 20);
        Human human2 = new Human("Петров", "Пётр", "Петрович", 15);
        Human human3 = new Human("Сергеев", "Евгений", "Олегович", 34);
        Human human4 = new Human("Иванов", "Александр", "Фёдорович", 17);

        humanList.add(human1);
        humanList.add(human2);
        humanList.add(human3);

        List<Human> humanList2 = CollectionsDemo.checkSurname(humanList, human4);
        assertEquals(1, humanList2.size());
    }

    @Test
    public void deleteHuman() {
        // Метод возвращает копию входного списка, не содержащую выделенного человека.

        ArrayList<Human> humanList = new ArrayList<>();

        Human human1 = new Human("Петров", "Кирилл", "Михайлович", 8);
        Human human2 = new Human("Кисляков", "Федор", "Данилович", 43);
        Human human3 = new Human("Иванов", "Валерий", "Сергеевич", 17);

        humanList.add(human1);
        humanList.add(human2);
        humanList.add(human3);

        List<Human> humanList2 = CollectionsDemo.deleteHuman(humanList, human1);
        assertEquals(2, humanList2.size());
    }

    @Test
    public void setIntersection() {
        // Метод возвращает список всех множеств входного списка, которые не пересекаются с заданным множеством.

        List<HashSet<Integer>> testlist = new ArrayList<>();

        HashSet<Integer> a = new HashSet<>(List.of(1, 3, 5));
        HashSet<Integer> b = new HashSet<>(List.of(2, 8, 6));
        HashSet<Integer> c = new HashSet<>(List.of(7, 4, 9));

        List<HashSet<Integer>> k = new ArrayList<>();
        k.add(a);
        k.add(b);
        testlist.add(a);
        testlist.add(b);

        assertEquals(CollectionsDemo.setIntersection(testlist, c), k);
    }

    @Test
    public void maxAgeList() {
        // Метод возвращает множество людей из входного списка с максимальным возрастом.

        List<Human> humanList = new ArrayList<>();

        Student human1 = new Student("Киселёв", "Владимир", "Андреевич", 35, "ФЦТК");
        Student human2 = new Student("Петров", "Илья", "Дмитрьевич", 25, "ФЦТК");
        Student human3 = new Student("Сидоров", "Александр", "Викторович", 35, "ФЦТК");

        humanList.add(human1);
        humanList.add(human2);
        humanList.add(human3);

        humanList = CollectionsDemo.maxAgeList(humanList);
        assertEquals(35, humanList.get(0).getAge());
        assertEquals(2, humanList.size());
    }

    @Test
    public void idContainedSetTest() {
        // Метод возвращает множество людей, идентификаторы которых содержатся во входном множестве.

        Human human1 = new Human("Киселёв", "Владимир", "Андреевич", 27);
        Human human2 = new Human("Петров", "Илья", "Дмитрьевич", 33);
        Human human3 = new Human("Сидоров", "Александр", "Викторович", 41);

        HashMap<Integer, Human> humanHashMap = new HashMap<>();
        humanHashMap.put(1000135, human1);
        humanHashMap.put(1000542, human2);
        humanHashMap.put(1000780, human3);

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1000125);
        hashSet.add(1000130);
        hashSet.add(1000135);

        Set<Human> humanSet = CollectionsDemo.idContainedSet(humanHashMap, hashSet);

        assertEquals(1, humanSet.size());
    }

    @Test
    public void ageEighteenListTest() {
        // Метод возвращает список идентификаторов людей, чей возраст не менее 18 лет.

        HashMap<Integer, Human> humanHashMap = new HashMap<>();

        Human human1 = new Human("Киселёв", "Владимир", "Андреевич", 17);
        Human human2 = new Human("Петров", "Илья", "Дмитрьевич", 18);
        Human human3 = new Human("Сидоров", "Александр", "Викторович", 41);

        humanHashMap.put(1000135, human1);
        humanHashMap.put(1000542, human2);
        humanHashMap.put(1000780, human3);

        List<Integer> humanList = CollectionsDemo.ageEighteenList(humanHashMap);
        assertEquals(2, humanList.size());
    }

    @Test
    public void idAndAgeMapTest() {
        // Метод строит отображение, которое идентификатору сопоставляет возраст человека.

        Map<Integer, Human> humanHashMap = new HashMap<>();

        Human human1 = new Human("Киселёв", "Владимир", "Андреевич", 17);
        Human human2 = new Human("Петров", "Илья", "Дмитрьевич", 18);
        Human human3 = new Human("Сидоров", "Александр", "Викторович", 41);

        humanHashMap.put(1000135, human1);
        humanHashMap.put(1000542, human2);
        humanHashMap.put(1000780, human3);

        Map<Integer, Integer> humanHashMap2 = CollectionsDemo.idAndAgeMap(humanHashMap);

        assertEquals("{1000542=18, 1000780=41, 1000135=17}", humanHashMap2.toString());
    }

    @Test
    public void ageAndPersonMapTest() {

//            Метод строит отображение, которое целому числу (возраст человека) сопоставляет список
//            всех людей данного возраста из входного множества.

        Set<Human> people = new HashSet<>();

        Human human1 = new Human("Киселёв", "Владимир", "Андреевич", 25);
        Human human2 = new Human("Петров", "Илья", "Дмитрьевич", 35);
        Human human3 = new Human("Сидоров", "Александр", "Викторович", 45);
        Human human4 = new Human("Иванов", "Федор", "Олегович", 35);

        people.add(human1);
        people.add(human2);
        people.add(human3);
        people.add(human4);

        Map<Integer, List<Human>> humanHashMap = CollectionsDemo.ageAndPersonMap(people);

        assertEquals(humanHashMap.get(35).size(), 2);
    }
}