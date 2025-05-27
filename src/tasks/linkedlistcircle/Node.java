package tasks.linkedlistcircle;

class Node {
    int val; // Данные узла
    Node next; // Ссылка на следующий узел

    Node(int val) {
        this.val = val;
        this.next = null; // Изначально следующий узел равен null
    }

    Node(int val, Node node) {
        this.val = val;
        this.next = node;
    }
}