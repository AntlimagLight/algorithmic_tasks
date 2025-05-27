package tasks.linkedlistcircle;

class CustomLinkedList {
    Node head; // Голова списка

    // Метод для добавления узла в конец списка
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // Если список пуст, новый узел становится головой
        } else {
            Node current = head;
            // Проходим по списку до последнего узла
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Добавляем новый узел в конец
        }
    }

    // Замкнуть на элементе со значением
    public void addAndCircle(int data, int pos) {
        Node circled = head;
        int curpos = 0;
        try {
            while (curpos != pos) {
                circled = circled.next;
                curpos++;
                if (curpos == 100) return;
            }
        } catch (NullPointerException e) {
            System.out.println("NPE!");
            return;
        }

        Node newNode = new Node(data, circled);
        if (head == null) {
            head = newNode; // Если список пуст, новый узел становится головой
        } else {
            Node current = head;
            // Проходим по списку до последнего узла
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Добавляем новый узел в конец
        }
    }

    // Метод для печати элементов списка
    public void printList() {
        Node current = head;
        int breaker = 0;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
            breaker++;
            if (breaker == 100) {
                System.out.println("cyrcle");
                return;
            }
        }
        System.out.println("null");
    }
}
