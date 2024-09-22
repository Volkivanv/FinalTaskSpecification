package src.core;

import src.core.animals.Animal;
import src.core.util.AnimalValidException;

public class Counter implements AutoCloseable{

    Animal animal;
    public Counter(Animal inAnimal) {
        this.animal = inAnimal;
    }

    public synchronized Integer add(Integer count) throws AnimalValidException {
        if(animal.AnimalValid()) {
            Integer newCount = count + 1;
            return newCount;
        } else {
            throw new AnimalValidException();
        }
    }
    public synchronized Integer sub(Integer count) {
        Integer newCount = count;
        if(count > 0 ) newCount--;
        return newCount;
    }


    @Override
    public void close() throws Exception {
        System.out.println("counter closed");
    }
}
