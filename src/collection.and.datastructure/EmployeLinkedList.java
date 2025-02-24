package collection.and.datastructure;

public class EmployeLinkedList {

    private EmployeeNode head;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
    }

    public void printList() {
        EmployeeNode node = head;
        while (node != null) {
            System.out.print(node + "->");
            node = node.getNext();
        }

        System.out.println("Null");
    }
}
