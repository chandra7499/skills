class Member {
    String name;
    int age;

    Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Compartment {
    int compartmentNumber;
    Member[] members;
    Compartment next;
    Compartment prev;

    Compartment(int compartmentNumber) {
        this.compartmentNumber = compartmentNumber;
        members = new Member[60];
    }

    void addMember(int seatNumber, Member member) {
        if (seatNumber >= 0 && seatNumber < 60) {
            members[seatNumber] = member;
        }
    }

    void removeMember(int seatNumber) {
        if (seatNumber >= 0 && seatNumber < 60) {
            members[seatNumber] = null;
        }
    }

    void displayMembers() {
        System.out.println("Members in Compartment " + compartmentNumber + ":");
        for (int i = 0; i < 60; i++) {
            if (members[i] != null) {
                System.out.println("Seat " + i + ": " + members[i].name + " (Age: " + members[i].age + ")");
            }
        }
    }
}

class TrainJourney {
    Compartment head;
    Compartment tail;

    void addCompartment(int compartmentNumber) {
        Compartment compartment = new Compartment(compartmentNumber);
        if (head == null) {
            head = compartment;
            tail = compartment;
        } else {
            tail.next = compartment;
            compartment.prev = tail;
            tail = compartment;
        }
    }

    void displayTrainState() {
        Compartment current = head;
        while (current != null) {
            current.displayMembers();
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TrainJourney train = new TrainJourney();
        train.addCompartment(1);
        train.addCompartment(2);
        // Add more compartments as needed
        
        // Add 60 members to compartment 1
        for (int i = 0; i < 60; i++) {
            train.head.addMember(i, new Member("Passenger" + i, 25));
        }

        // Remove passengers from compartment 1 (9th and 12th seats)
        train.head.removeMember(9);
        train.head.removeMember(12);

        // Add compartments at Nagpur
        train.addCompartment(3);
        train.addCompartment(4);

        // Display the state of the train
        train.displayTrainState();
    }
}
