import java.util.Arrays;

public class Main {


  public static void main(String[] args) {
    int numberOfInsertionsForAdd;
    int numberOfInsertionsForDelete;

    if (args.length != 1) {
      throw new IllegalArgumentException("Please input number of 9's to be inserted");
    } else {
      numberOfInsertionsForAdd = Integer.parseInt(args[0]);
      numberOfInsertionsForDelete = Integer.parseInt(args[0]);

    }

    CoolCoolList list = new CoolCoolList();

    System.out.println("\nThere are " + numberOfInsertionsForAdd + " elements in this list\n");

    while (numberOfInsertionsForAdd > 0) {
      list.add(9);
      numberOfInsertionsForAdd--;
    }
    System.out.println("\n");

    while (numberOfInsertionsForDelete > 0) {
      list.deleteLast();
      numberOfInsertionsForDelete--;
    }


    System.out.println("\ninsert no resize: " + list.insertNOResize + "/" + list.totalInsertNoResize);
    System.out.println("\ninsert no resize: " + list.insertNOResize / list.totalInsertNoResize);


    System.out.println("\ninsert resize: " + list.insertResize + "/" + list.totalInsertResize);
    System.out.println("\ninsert resize: " + list.insertResize / list.totalInsertResize);


    System.out.println("\ndelete no resize: " + list.deleteNOResize + "/" + list.totalDeleteNoResize);
    System.out.println("\ndelete no resize: " + list.deleteNOResize / list.totalDeleteNoResize);


    System.out.println("\ndelete resize: " + list.deleteResize + "/" + list.totalDeleteResize);
    System.out.println("\ndelete resize: " + list.deleteResize / list.totalDeleteResize);
    System.out.println("\ntotal insert: " + list.totalAddTime / list.getNumTimesAdded());
    System.out.println("\ntotal delete: " + list.totalDeleteTime / list.getNumTimesDeleted());


  }


  public static class CoolCoolList {
    private Integer[] initial;
    private int maxSize;
    private int elementCounter;
    public int numTimesAdded;
    public int numTimesDeleted;
    public long insertResize;
    public long insertNOResize;
    public long deleteResize;
    public long deleteNOResize;
    public long totalAddTime;
    public long totalDeleteTime;


    public boolean haveResized;


    public int totalInsertResize;
    public int totalInsertNoResize;
    public int totalDeleteResize;
    public int totalDeleteNoResize;


    public CoolCoolList() {
      maxSize = 50;
      this.initial = new Integer[maxSize];
      this.elementCounter = 0;
      this.numTimesAdded = 0;
      this.numTimesDeleted = 0;
    }

    public long getNumTimesAdded() {
      return this.numTimesAdded;
    }

    public void add(int newVal) {
      numTimesAdded++;
      haveResized = false;
      long startTime = System.nanoTime();
      if (elementCounter == maxSize) {
        // Doubling size.
        maxSize = maxSize * 2;
        // Creating new array.
        initial = Arrays.copyOf(initial, maxSize);
        haveResized = true;
      }
      initial[elementCounter] = newVal;
      elementCounter++;

      long endTime = System.nanoTime();

      long actualTime = endTime - startTime;

      if (haveResized) {
        totalInsertResize++;
        insertResize += actualTime;
      } else {
        totalInsertNoResize++;
        insertNOResize += actualTime;
      }

      totalAddTime += actualTime;
    }


    public void deleteLast() {
      numTimesDeleted++;
      long startTime = System.nanoTime();
      this.elementCounter--;

      haveResized = false;

      if (elementCounter < 0) {
        throw new IllegalArgumentException("No elements to delete!");
      } else if (elementCounter <= maxSize / 4) {

        this.maxSize = maxSize / 2;

        Integer[] newList = Arrays.copyOf(initial, maxSize);

        newList[elementCounter] = null;

        for (int i = 0; i < elementCounter; i++) {
          this.initial[elementCounter] = newList[elementCounter];
        }

        haveResized = true;


      } else {
        initial[elementCounter] = null;
      }

      long endTime = System.nanoTime();

      long actualTime = endTime - startTime;

      if (haveResized) {
        totalDeleteResize++;
        deleteResize += actualTime;
      } else {
        totalDeleteNoResize++;
        deleteNOResize += actualTime;
      }

      totalDeleteTime += actualTime;
    }

    public long getNumTimesDeleted() {
      return this.numTimesDeleted;
    }
  }
}
