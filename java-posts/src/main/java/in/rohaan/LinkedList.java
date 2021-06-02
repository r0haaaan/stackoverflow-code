package in.rohaan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Code for https://stackoverflow.com/questions/67752828
 */
public class LinkedList {
    class Node{
        Bird bird;
        Node next;

        public Node(Bird bird) {
            this.bird = bird;
            this.next = null;
        }
    }

    //Head and tail of the singly linked list
    public Node head = null;
    public Node tail = null;

    //Add a new node to the list
    public void addNewNode(Bird bird) {
        //Create a new node
        Node newNode = new Node(bird);

        //Checks if the list is empty
        if(head == null) {
            //If list is empty head and tail points to the newNode
            head = newNode;
            tail = newNode;
        }
        else {
            //Only tail points to the newNode
            tail.next = newNode;
            tail = newNode;
        }
    }


    public int getCount() {  // to get a count of nodes in the list
        if (head != null) {
            Node current = head;
            int count = 0;
            while (current != null)
            {
                count++;
                current = current.next;
            }
            return count;
        }else
            return 0;
    }


    public void printList() {
        Node current = head;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes: ");
        while(current != null) {
            //Prints each node
            System.out.print("["+current.bird + "] ");
            current = current.next;
        }
        System.out.println();
    }

    public Bird GetNth(int index)  // to get a bird object from a node
    {
        Node current = head;
        int count = 0; /* index of Node we are
                          currently looking at */
        while (current != null)
        {
            if (count == index)
                return current.bird;
            count++;
            current = current.next;
        }
        return null;
    }

    public void sortListByFrequency() {

        Node current = head;
        Node nextNode = null;
        Bird temp;

        if(head == null) {
            return;
        }
        else {
            while(current != null) {
                nextNode = current.next;

                while(nextNode != null) {

                    //Swap nodes content if next node's bird count is lower
                    if(current.bird.getBirdCount() < nextNode.bird.getBirdCount()) {
                        temp = current.bird;
                        current.bird = nextNode.bird;
                        nextNode.bird = temp;
                    }
                    nextNode = nextNode.next;
                }
                current = current.next;
            }
        }
    }

    /*
     * Scan provided file line by line and delete list nodes
     * whose bird name is equal to any bird name found in input
     * file.
     */
    public void scanAndCompareFileEntriesAndRemoveNode(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException("Not able to find file for comparison");
        }

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                boolean deletionStatus = removeBirdWithName(line);
                if (deletionStatus) {
                    System.out.printf("Successfully deleted %s from list\n", line);
                }
            }
        }
    }

    /*
     * Remove Node with bird name equal to specified bird name.
     */
    private boolean removeBirdWithName(String name) {
        Node currentNode = head;
        Node prevNode = null;
        boolean birdFoundAndDeleted = false;

        while (currentNode != null) {
            if (currentNode.bird.getBirdName().equals(name)) {
                removeNodeFromLinkedList(prevNode, currentNode);
                birdFoundAndDeleted = true;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        return birdFoundAndDeleted;
    }

    /*
     * Remove Single Node from Linked List.
     */
    private void removeNodeFromLinkedList(Node prevNode, Node currentNode) {
        if (prevNode == null) {
            head = currentNode.next;
        } else {
            prevNode.next = currentNode.next;
        }
    }


    public static void main(String[] args) {
        readFile();
    }

    static void readFile() {
        //
        try {
            LinkedList list = new LinkedList(); // create the Singly Linked List
            FileReader fr = new FileReader(LinkedList.class.getResource("/birds.txt").getFile()); //access birds.txt
            BufferedReader br = new BufferedReader(fr);

            String currentLine = br.readLine();

            while(currentLine != null) {


                String s = currentLine; // obtain the string


                if (list.head==null) {  // if the list is empty, add a new node and make it a head
                    Bird a = new Bird(s);
                    list.addNewNode(a);
                }

                for (int i = 0; i < list.getCount(); i++) { // if the SSL is not empty, go thru the nodes and find a matching bird name
                    String currentBird = list.GetNth(i).getBirdName();
                    if (s.equals(currentBird)) {
                        list.GetNth(i).addBirdCount();  // if bird was found, add an increment
                        break;
                    }
                    if (i == list.getCount()-1 && !s.equals(currentBird)) { // if bird is not found, add a new node
                        Bird a = new Bird(s);
                        list.addNewNode(a);
                    }
                }
                currentLine = br.readLine();

            }
            br.close();
            fr.close();
            System.out.println("List not sorted: "+"\n");
            list.printList(); // print all nodes as part of SLL
            System.out.println("");
            System.out.println("List sorted by frequency: "+"\n");
            list.sortListByFrequency();
            list.printList();

            File secondFile = new File(LinkedList.class.getResource("/bird2.txt").getFile());
            System.out.println("\nComparing and Removing List nodes from " + secondFile.getAbsolutePath());
            list.scanAndCompareFileEntriesAndRemoveNode(secondFile);
            list.printList();



        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
