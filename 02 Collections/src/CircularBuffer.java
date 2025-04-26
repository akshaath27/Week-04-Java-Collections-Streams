public class CircularBuffer {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void insert(int value) {
        if (size == capacity) {
            head = (head + 1) % capacity; // Overwrite the oldest element
        } else {
            size++;
        }
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
    }

    public void display() {
        int i = head;
        for (int count = 0; count < size; count++) {
            System.out.print(buffer[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display(); // Output: 1 2 3

        cb.insert(4);
        cb.display(); // Output: 2 3 4
    }
}
