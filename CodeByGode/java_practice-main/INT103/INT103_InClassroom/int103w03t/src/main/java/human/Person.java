package human;

public class Person implements Comparable<Person> {
    final int id;
    final String name;

    public Person(int id, String name) { this.id = id; this.name = name; }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        return this == o || this.id == ((Person) o).id;
    }

    @Override
    public int compareTo(Person p) {
        int x = this.id - p.id;
        if (x != 0) return x;
        return this.name.compareTo(p.name); 
    }
    
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + '}';
    }
    
}
