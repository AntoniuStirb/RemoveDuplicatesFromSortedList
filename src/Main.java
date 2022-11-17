public class Main {
    public static void main(String[] args) {
        ListNode list = new ListNode(1, null); // create a new list
        list = addNodeAtEnd(list, 1); // adding an element to the list created before
        list = addNodeAtEnd(list, 2);
        list = addNodeAtEnd(list, 2);
        list = addNodeAtEnd(list, 3);
        list = addNodeAtEnd(list, 3);
        list = addNodeAtEnd(list, 4);

        printList(list);
        System.out.println();
        printList(deleteDuplicates(list));
    }


    public static ListNode deleteDuplicates(ListNode list) {
        ListNode secondList = new ListNode(); //I created a new empty list in order to add elements without duplicates
        ListNode head = secondList; // We must keep the head of the second list to avoid returning only the last element in the end

        if (list == null) {
            return null;     // if the list is empty it will return null
        }

        if (list.next == null) {
            secondList.next = list; // if the list has only one element, it will pass the only element in the second list
        }

        while (list.next != null) {  // if the list has more than one element, we go through the list until we reach the last element
            if (list.val == list.next.val) { // if two consecutive elements are equal, we pass on the next position
                list = list.next;
                if (list.next == null) {
                    secondList.next = list; //if we are at the last element of the list, we must keep it too, otherwise, the last element added will not be included
                    break;
                }
            } else {
                secondList.next = list; //if two consecutive elements are not equal,  we pass the element from the list to the second list
                secondList = secondList.next; //move to the next position in the second list
                list = list.next; //move to the next position in the first list
            }
        }
        return head.next; //the returns all the elemens of the list starting with the first one, which is the head
    }

    public static ListNode addNodeAtEnd(ListNode list, int value) { // I implemented a method to add an element at the and of a list
        ListNode newNode = new ListNode(value); //creating a new node
        ListNode head = list;

        while (list.next != null) {
            list = list.next;  //we need to get to the end of the list
        }

        list.next = newNode; //after reaching the end of the list, we insert the new element
        newNode.next = null;
        return head;
    }

    public static void printList(ListNode list) { //implemented method to print the list
        while (list != null) {
            System.out.println((list.val) + " ");
            list = list.next;
        }
    }
}