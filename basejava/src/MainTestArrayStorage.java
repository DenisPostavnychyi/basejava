import model.Resume;
import repository.ArrayStorage;

import java.io.IOException;

public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) throws IOException {
        Resume r1 = new Resume();
        r1.uuid = "uuid1";
        r1.age = 21;
        r1.education = "secondary";
        Resume r2 = new Resume();
        r2.uuid = "uuid2";
        r2.age = 22;
        r2.education = "higher";
        Resume r3 = new Resume();
        r3.uuid = "uuid3";
        r3.age = 23;
        r3.education = "higher";

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.uuid));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        r2.age = r3.age;
        System.out.println("Upgrade r2");
        ARRAY_STORAGE.update(r2);
        System.out.println("r2 age: " + r2.age);

        printAll();
        ARRAY_STORAGE.delete(r3.uuid);
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
