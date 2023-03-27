public class Buero {
  
  Queue<Person> queue;
  
  public Buero() {
    queue = new Queue<Person>();
  }
  
  public void hintenAnstellen(Person pP) {
    queue.enqueue(pP);
  }
  
  public void einlassen() {
    Person p = queue.front();
    System.out.println(p.getName() + " ist dran!");
    p.reingehen();
    queue.dequeue();
  }
  
  public void sprechstundeBeenden() {
    queue = new Queue<Person>();
    System.gc();
    /*oder
    queue = null;
    System.gc();*/
  }

} 

