import com.sun.source.doctree.SeeTree;

import java.util.*;

public class CollectionsDemo {
    public static int checkSymbol(List<String> str, char symbol) {
        // Метод возвращает количество строк входного списка, у которых первый символ совпадает с заданным.
        int count = 0;
        for (String s : str) {
            if (!s.isEmpty() && s.charAt(0) == symbol) {
                count++;
            }
        }
        return count;
    }

    public static List<Human> checkSurname(List<Human> list, Human h) {
        // Метод возвращает список однофамильцев заданного человека среди людей из входного списка.
        List<Human> result = new ArrayList<Human>();
        for (Human human : list) {
            if (human.getSurname().equals(h.getSurname())) {
                result.add(human);
            }
        }
        return result;
    }

    public static List<Human> deleteHuman(List<Human> list, Human h) {
        // Метод возвращает копию входного списка, не содержащую выделенного человека.
        List<Human> copyList = list;
        copyList.remove(h);
        return copyList;
    }

    public static List<HashSet<Integer>> setIntersection(List<HashSet<Integer>> hashSets, HashSet<Integer> hashSet) {
        // Метод возвращает список всех множеств входного списка, которые не пересекаются с заданным множеством.

        List<HashSet<Integer>> setList1 = new ArrayList<>(hashSets);
        List<HashSet<Integer>> result = new ArrayList<>();

        for (HashSet<Integer> set : setList1) {
            HashSet<Integer> copySet = new HashSet<>(set);
            set.removeAll(hashSet);
            if (copySet.equals(set)) {
                result.add(set);
            }
        }
        return result;
    }

    public static List<Human> maxAgeList(List<Human> humanList) {
        // Метод возвращает множество людей из входного списка с максимальным возрастом.

        int maxAge = 0;
        ArrayList<Human> result = new ArrayList<>();

        for (Human person : humanList) {
            if (person.getAge() > maxAge) {
                maxAge = person.getAge();
            }
        }

        for (Human person : humanList) {
            if (person.getAge() == maxAge) {
                result.add(person);
            }
        }
        return result;
    }

    public static Set<Human> idContainedSet(Map<Integer, Human> maps, Set<Integer> identifiers) {
        // Метод возвращает множество людей, идентификаторы которых содержатся во входном множестве.

        HashSet<Human> result = new HashSet<>();

        for (Map.Entry<Integer, Human> entry : maps.entrySet()) {
            Integer key = entry.getKey();
            Human human = entry.getValue();
            if (identifiers.contains(key)) {
                result.add(human);
            }
        }
        return result;
    }

    public static List<Integer> ageEighteenList(Map<Integer, Human> maps) {
        // Метод возвращает список идентификаторов людей, чей возраст не менее 18 лет.

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Human> entry : maps.entrySet()) {
            Integer key = entry.getKey();
            Human human = entry.getValue();

            if (human.getAge() >= 18) {
                result.add(key);
            }
        }
        return result;
    }

    public static Map<Integer, Integer> idAndAgeMap(Map<Integer, Human> maps) {
        // Метод строит отображение, которое идентификатору сопоставляет возраст человека.

        Map<Integer, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, Human> entry : maps.entrySet()) {
            Integer key = entry.getKey();
            Human human = entry.getValue();
            result.put(key, human.getAge());
        }
        return result;
    }

    public static Map<Integer, List<Human>> ageAndPersonMap(Set<Human> people) {
//            Метод строит отображение, которое целому числу (возраст человека) сопоставляет список
//            всех людей данного возраста из входного множества.

        Map<Integer, List<Human>> result = new HashMap<>();
        for (Human human : people) {
            result.putIfAbsent(human.getAge(), new LinkedList<>());
            result.get(human.getAge()).add(human);
        }
        return result;
    }
}
